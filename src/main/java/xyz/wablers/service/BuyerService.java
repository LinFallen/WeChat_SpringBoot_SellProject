package xyz.wablers.service;

import xyz.wablers.dto.OrderDTO;

/**
 * @author Wablers
 * @version 1.0
 * @description: 买家端
 * @date 2021/8/12 21:21
 */
public interface BuyerService {
    /**
     * 查询一个订单
     * @return
     */
    OrderDTO findOrderOne(String openid, String orderId);

    /**
     * 取消订单
     * @return
     */
    OrderDTO cancelOrder(String openid, String orderId);
}
