package xyz.wablers.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.wablers.dataobject.ProductCategory;
import xyz.wablers.repository.ProductCategoryRepository;
import xyz.wablers.service.CategoryService;

import java.util.List;
import java.util.Optional;

/**
 * @description: 类目接口实现
 * @author Wablers
 * @date 2021/8/5 11:15
 * @version 1.0
 */

@Service
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private ProductCategoryRepository categoryRepository;

    @Override
    public ProductCategory getOne(Integer categoryId) {
        Optional<ProductCategory> category = categoryRepository.findById(categoryId);
        return category.isPresent() ? category.get() : null;
    }

    @Override
    public List<ProductCategory> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return categoryRepository.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public ProductCategory findByCategoryType(Integer categoryType) {
        return categoryRepository.findByCategoryType(categoryType);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return categoryRepository.save(productCategory);
    }
}
