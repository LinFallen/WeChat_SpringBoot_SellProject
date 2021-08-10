package xyz.wablers.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.wablers.dataobject.OrderDetail;
import xyz.wablers.service.ProductInfoService;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @description: OrderDetailRepositoryTest
 * @author Wablers
 * @date 2021/8/10 19:58
 * @version 1.0
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    ProductInfoService productInfoService;

    @Test
    public void saveTest() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("500");
        orderDetail.setOrderId("234567");
        BeanUtils.copyProperties(productInfoService.findOne("1"),orderDetail);
        orderDetail.setProductQuantity(2);

        OrderDetail result =  orderDetailRepository.save(orderDetail);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByOrderId() {
        System.out.println(orderDetailRepository.findByOrderId("234567"));
    }
}