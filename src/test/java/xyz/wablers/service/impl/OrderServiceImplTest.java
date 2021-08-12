package xyz.wablers.service.impl;

import lombok.extern.slf4j.Slf4j;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.wablers.dataobject.OrderDetail;
import xyz.wablers.dataobject.OrderMaster;
import xyz.wablers.dto.OrderDTO;
import xyz.wablers.enums.OrderStatusEnum;
import xyz.wablers.enums.PayStatusEnum;
import xyz.wablers.repository.OrderMasterRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceImplTest {

    @Autowired
    private OrderServiceImpl orderService;

    private final String BUYER_OPENID = "110110";

    private final String ORDER_ID = "16287484605243088";

    @Test
    public void create() throws Exception {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("大兄弟");
        orderDTO.setBuyerAddress("家里");
        orderDTO.setBuyerPhone("12345678900");
        orderDTO.setBuyerOpenid(BUYER_OPENID);

        // 购物车
        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail o1 = new OrderDetail();
        o1.setProductId("65");
        o1.setProductQuantity(1);
        orderDetailList.add(o1);
        orderDTO.setOrderDetailList(orderDetailList);
        OrderDTO result =  orderService.create(orderDTO);
        log.info("[创建订单] result={}", result);
        Assert.assertNotNull(result);
    }

    @Test
    public void findOne() {
        OrderDTO result =  orderService.findOne(ORDER_ID);
        log.info("[查询单个订单] result={}", result);
        Assert.assertEquals(ORDER_ID, result.getOrderId());
    }

    @Test
    public void findList() {
        PageRequest pageRequest = PageRequest.of(0,2);
        Page<OrderDTO> orderDTOPage = orderService.findList(BUYER_OPENID, pageRequest);
        Assert.assertNotEquals(0, orderDTOPage.getTotalElements());
    }

    @Test
    public void cancel() {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        OrderDTO result = orderService.cancel(orderDTO);
        Assert.assertEquals(OrderStatusEnum.CANCEL.getCode(), result.getOrderStatus());
    }

    @Test
    public void finish() {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        OrderDTO result = orderService.finish(orderDTO);
        Assert.assertEquals(OrderStatusEnum.FINISHED.getCode(), result.getOrderStatus());
    }

    @Test
    public void paid() {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        OrderDTO result = orderService.paid(orderDTO);
        Assert.assertEquals(PayStatusEnum.SUCCESS.getCode(), result.getPayStatus());
    }
}