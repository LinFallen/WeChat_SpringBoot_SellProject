package xyz.wablers.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.wablers.dataobject.OrderDetail;
import xyz.wablers.dataobject.OrderMaster;
import xyz.wablers.dataobject.ProductInfo;
import xyz.wablers.dto.CartDTO;
import xyz.wablers.dto.OrderDTO;
import xyz.wablers.enums.OrderStatusEnum;
import xyz.wablers.enums.PayStatusEnum;
import xyz.wablers.enums.ResultEnum;
import xyz.wablers.exception.SellException;
import xyz.wablers.repository.OrderDetailRepository;
import xyz.wablers.repository.OrderMasterRepository;
import xyz.wablers.service.OrderService;
import xyz.wablers.service.ProductInfoService;
import xyz.wablers.utils.KeyUtil;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Wablers
 * @version 1.0
 * @description: TODO
 * @date 2021/8/11 13:52
 */

@Service
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductInfoService productInfoService;
    @Autowired
    private OrderMasterRepository orderMasterRepository;
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    /**
     * @description: 、计算总价、写入订单数据库（orderMaster和orderDetail）、扣库存
     * @param: orderDTO
     * @return:
     */
    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        // 随机生成订单Id
        String orderId = KeyUtil.genUniqueKey();
        // 将每件商品的购买数量和Id加入购物车列表;lambda表达式，更简便
        List<CartDTO> cartDTOS= orderDTO.getOrderDetailList().stream()
                .map(e -> new CartDTO(e.getProductId(), e.getProductQuantity())).collect(Collectors.toList());
        // 订单总价
        BigDecimal orderAmount = new BigDecimal(0);
        for (OrderDetail orderDetail : orderDTO.getOrderDetailList()) {
            // 查询商品(数量, 价格)
            ProductInfo productInfo = productInfoService.findOne(orderDetail.getProductId());
            if (productInfo == null) {
                // 若商品不存在
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            // 将orderDetail信息补全
            BeanUtils.copyProperties(productInfo, orderDetail);
            orderDetail.setOrderId(orderId);
            orderDetail.setDetailId(KeyUtil.genUniqueKey());
            // 加上每件商品总价
            orderAmount = orderAmount.add(orderDetail.getProductPrice()
                    .multiply(new BigDecimal(orderDetail.getProductQuantity())));
        }

        // 将订单加入到数据库
        orderDetailRepository.saveAll(orderDTO.getOrderDetailList());
        // 将订单概要添加到数据库
        OrderMaster orderMaster = new OrderMaster();
        orderDTO.setOrderId(orderId);
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMaster.setOrderAmount(orderAmount);
        orderMasterRepository.save(orderMaster);

        // 扣库存
        productInfoService.decreaseStock(cartDTOS);
        // webSocket发送消息，告知卖家有新订单

        return orderDTO;
    }

    @Override
    public OrderDTO findOne(String orderId) {
        return null;
    }

    @Override
    public Page<OrderDTO> findList(String buyerOpenid, Pageable pageable) {
        return null;
    }

    @Override
    public OrderDTO cancel(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO finish(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO paid(OrderDTO orderDTO) {
        return null;
    }
}
