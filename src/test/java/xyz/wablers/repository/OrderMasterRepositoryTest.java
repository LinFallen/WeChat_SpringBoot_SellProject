package xyz.wablers.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.wablers.dataobject.OrderMaster;

import java.math.BigDecimal;

/**
 * @description: OrderMasterRepositoryTest
 * @author Wablers
 * @date 2021/8/10 18:55
 * @version 1.0
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository repository;



    @Test
    public void saveTest() {
        /*OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("123456");
        orderMaster.setBuyerName("唐三藏");
        orderMaster.setBuyerPhone("11012012345");
        orderMaster.setBuyerAddress("东土大唐");
        orderMaster.setBuyerOpenid("74318");
        orderMaster.setOrderAmount(new BigDecimal(3.0));

        OrderMaster result =  repository.save(orderMaster);
        Assert.assertNotNull(result);*/
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("234568");
        orderMaster.setBuyerName("孙悟空");
        orderMaster.setBuyerPhone("11012023456");
        orderMaster.setBuyerAddress("花果山");
        orderMaster.setBuyerOpenid("500");
        orderMaster.setOrderAmount(new BigDecimal(72.0));

        OrderMaster result =  repository.save(orderMaster);
        Assert.assertNotNull(result);

    }

    private final String OPENID = "500";

    @Test
    public void findByBuyerOpenid() throws Exception {
        PageRequest request = PageRequest.of(0, 3);

        Page<OrderMaster> result = repository.findByBuyerOpenid(OPENID, request);
        Assert.assertNotEquals(0, result.getTotalElements());
    }
}