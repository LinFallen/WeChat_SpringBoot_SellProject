package xyz.wablers.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import xyz.wablers.dataobject.OrderMaster;
import xyz.wablers.dto.OrderDTO;

/**
 * @author Wablers
 * @version 1.0
 * @description: 订单有关Service
 * @date 2021/8/11 10:57
 */
public interface OrderService {
    /**
     * @description: 创建订单
     */
    OrderDTO create(OrderDTO orderDTO);

    /**
     * @description: 查询单个订单
     */
    OrderDTO findOne(String orderId);

    /**
     * @description: 查询订单列表
     */
    Page<OrderDTO> findList(String buyerOpenid, Pageable pageable);

    /**
     * @description: 取消订单
     */
    OrderDTO cancel(OrderDTO orderDTO);

    /**
     * @description: 完结订单
     */
    OrderDTO finish(OrderDTO orderDTO);

    /**
     * @description: 支付订单
     */
    OrderDTO paid(OrderDTO orderDTO);
}
