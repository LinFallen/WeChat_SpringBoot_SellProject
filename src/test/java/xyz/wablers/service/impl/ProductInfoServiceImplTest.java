package xyz.wablers.service.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.wablers.dataobject.ProductInfo;
import xyz.wablers.enums.ProductStatusEnum;

import java.math.BigDecimal;
import java.util.List;

/**
 * @description: TEST
 * @author Wablers
 * @date 2021/8/5 14:41
 * @version 1.0
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoServiceImplTest {

    @Autowired
    private ProductInfoServiceImpl productInfoService;

    @Test
    public void findOne() {
        ProductInfo productInfo = productInfoService.findOne("1");
        //Assert.assertEquals("1", productInfo.getProductId());
        if (productInfo != null) {
            if (productInfo.getProductId() != null) {
                System.out.println(productInfo.getProductId());
            }
        }
    }

    @Test
    public void findUpAll() {
        List<ProductInfo> productInfoList = productInfoService.findUpAll();
        Assert.assertNotEquals(0, productInfoList.size());
    }

    @Test
    public void findAll() {
        PageRequest request = PageRequest.of(0, 2);
        Page<ProductInfo> productInfoPage = productInfoService.findAll(request);
        System.out.println(productInfoPage.getTotalElements());
        Assert.assertNotEquals(0, productInfoPage.getSize());
    }

    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setCategoryType(2);
        productInfo.setProductDescription("随便瞎写");
        productInfo.setProductIcon("http://www.scg.jpg");
        productInfo.setProductId("65");
        productInfo.setProductName("味增汤");
        productInfo.setProductPrice(new BigDecimal(1.116));
        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());
        productInfo.setProductStock(30);
        System.out.println(productInfoService.save(productInfo));
    }
}