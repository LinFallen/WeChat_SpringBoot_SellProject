package xyz.wablers.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.wablers.dataobject.ProductInfo;
import xyz.wablers.enums.ProductStatusEnum;
import xyz.wablers.repository.ProductInfoRepository;
import xyz.wablers.service.ProductInfoService;


import java.util.List;
import java.util.Optional;

/**
 * @author Wablers
 * @version 1.0
 * @description: ProductInfoService 实现
 * @date 2021/8/5 12:53
 */

@Service
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class ProductInfoServiceImpl implements ProductInfoService {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Override
    public ProductInfo findOne(String productId) {
        Optional<ProductInfo> productInfo = productInfoRepository.findById(productId);
        // isPresent方法,判断返回的Optional是否为有价值的值（即是否不为空），若不为空则为true，否则false
        if (productInfo.isPresent()){
            return productInfo.get();
        }
        return null;
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return productInfoRepository.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return productInfoRepository.save(productInfo);
    }
}
