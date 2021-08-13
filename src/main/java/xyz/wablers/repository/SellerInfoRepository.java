package xyz.wablers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.wablers.dataobject.SellerInfo;

/**
 * @author Wablers
 * @version 1.0
 * @description: TODO
 * @date 2021/8/13 16:49
 */
public interface SellerInfoRepository extends JpaRepository<SellerInfo, String> {
    SellerInfo findByOpenid(String openid);
}
