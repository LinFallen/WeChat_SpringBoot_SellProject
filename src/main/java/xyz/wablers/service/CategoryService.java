package xyz.wablers.service;

import xyz.wablers.dataobject.ProductCategory;

import java.util.List;

/**
 * @description: 类目接口
 * @author Wablers
 * @date 2021/8/5 11:15
 * @version 1.0
 */
public interface CategoryService {

    /**
     * 根据id查询类目信息
     *
     * @return
     */
    ProductCategory getOne(Integer categoryId);

    /**
     * 获取所有类目信息
     *
     * @return
     */
    List<ProductCategory> findAll();

    /**
     * 通过指定类目编号范围，获取符合要求的所有类目
     *
     * @return
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    /**
     * 通过指定类目编号，获取符合要求的类目
     *
     * @return
     */
    ProductCategory findByCategoryType(Integer categoryType);

    /**
     * 保存该类目
     *
     * @return
     */
    ProductCategory save(ProductCategory productCategory);
}