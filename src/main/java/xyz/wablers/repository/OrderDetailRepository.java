package xyz.wablers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.wablers.dataobject.OrderDetail;

import java.util.List;

/**
 * @author Wablers
 * @version 1.0
 * @description: TODO
 * @date 2021/8/10 18:53
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {

    List<OrderDetail> findByOrderId(String orderId);
}
