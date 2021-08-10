package xyz.wablers.repository;

import org.hibernate.criterion.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import xyz.wablers.dataobject.OrderMaster;

/**
 * @author Wablers
 * @version 1.0
 * @description: 订单概要接口
 * @date 2021/8/10 18:51
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {

    Page<OrderMaster> findByBuyerOpenid(String buyerOpenid, Pageable pageable);
}
