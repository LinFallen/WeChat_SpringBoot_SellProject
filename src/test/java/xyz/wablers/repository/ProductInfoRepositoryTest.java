package xyz.wablers.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.wablers.dataobject.ProductInfo;

import java.math.BigDecimal;
import java.util.List;

/**
 * @description: TEST
 * @author Wablers
 * @date 2021/8/5 12:08
 * @version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Test
    public void save() {
        ProductInfo product = new ProductInfo();
        product.setProductId("1");
        product.setProductName("米饭");
        product.setProductPrice(new BigDecimal(2.0));
        product.setProductStock(20);
        product.setProductDescription("东北大米");
        product.setProductIcon("http://www.xxxx.jpg");
        product.setProductStatus(0);
        product.setCategoryType(2);
        productInfoRepository.save(product);
    }

    @Test
    public void findByProductStatus() {
        List<ProductInfo> productInfoList = productInfoRepository.findByProductStatus(0);
        Assert.assertNotEquals(0, productInfoList.size());

    }
}