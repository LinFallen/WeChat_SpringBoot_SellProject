package xyz.wablers.service;

import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.model.RefundResponse;
import xyz.wablers.dto.OrderDTO;

/**
 * @author Wablers
 * @version 1.0
 * @description: 支付接口
 * @date 2021/8/12 16:25
 */
public interface PayService {

    PayResponse create(OrderDTO orderDTO);

    PayResponse notify(String notifyData);

    RefundResponse refund(OrderDTO orderDTO);
}
