package xyz.wablers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.wablers.dataobject.ProductInfo;

import java.util.List;

/**
 * @description: 商品信息接口
 * @author Wablers
 * @date 2021/8/5 12:07
 * @version 1.0
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {

    // 查询某状态的所有商品
    List<ProductInfo> findByProductStatus(Integer status);
}
