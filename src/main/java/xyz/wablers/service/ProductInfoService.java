package xyz.wablers.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import xyz.wablers.dataobject.ProductInfo;
import xyz.wablers.dto.CartDTO;

import java.util.List;

/**
 * @author Wablers
 * @version 1.0
 * @description: 商品信息查询接口
 * @date 2021/8/5 12:31
 */
public interface ProductInfoService {
    /**
     * @description: 根据id查询商品信息
     * @param: productId
     */
    ProductInfo findOne(String productId);
    /** 
     * @description: 查询所有上架商品 -- 客户端使用 
     * @param:
     */ 
    List<ProductInfo> findUpAll();
    /** 
     * @description: 根据分页条件, 返回所有商品信息 -- 服务端使用
     * @param: pageable
     */ 
    Page<ProductInfo> findAll(Pageable pageable);
    /**
     * @description: 添加完整商品信息
     * @param: productInfo
     */
    ProductInfo save(ProductInfo productInfo);
    /**
     * @description:  加库存
     * @param: cartDTOList
     */
    void increaseStock(List<CartDTO> cartDTOList);
    /**
     * @description: 减库存
     * @param: cartDTOList
     */
    void decreaseStock(List<CartDTO> cartDTOList);

}
