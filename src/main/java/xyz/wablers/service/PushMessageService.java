package xyz.wablers.service;

import xyz.wablers.dto.OrderDTO;

/**
 * @author Wablers
 * @version 1.0
 * @description: 推送消息
 * @date 2021/8/14 12:37
 */
public interface PushMessageService {

    /**
     * 订单状态变更消息
     * @param orderDTO
     */
    void orderStatus(OrderDTO orderDTO);
}
