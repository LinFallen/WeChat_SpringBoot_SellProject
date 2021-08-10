package xyz.wablers.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.wablers.dataobject.ProductCategory;

import java.util.Arrays;

/**
 * @description: TODO
 * @author Wablers
 * @date 2021/8/5 11:13
 * @version 1.0
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {

    @Autowired
    private CategoryServiceImpl categoryService;

    @Test
    public void getOne() {
        System.out.println(categoryService.getOne(2));
    }

    @Test
    public void findAll() {
        System.out.println(categoryService.findAll());
    }

    @Test
    public void findByCategoryTypeIn() {
        System.out.println(categoryService.findByCategoryTypeIn(Arrays.asList(1,2,3)));
    }

    @Test
    public void findByCategoryType() {
        System.out.println(categoryService.findByCategoryType(2));
    }

    @Test
    public void save() {
        ProductCategory productCategory = new ProductCategory("男生专享", 10);
        System.out.println(categoryService.save(productCategory));
    }
}