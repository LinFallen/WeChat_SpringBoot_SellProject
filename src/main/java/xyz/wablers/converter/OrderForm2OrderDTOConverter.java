package xyz.wablers.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;
import xyz.wablers.dataobject.OrderDetail;
import xyz.wablers.dto.OrderDTO;
import xyz.wablers.enums.ResultEnum;
import xyz.wablers.exception.SellException;
import xyz.wablers.form.OrderForm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wablers
 * @version 1.0
 * @description: TODO
 * @date 2021/8/12 20:46
 */

@Slf4j
public class OrderForm2OrderDTOConverter {

    public static OrderDTO convert(OrderForm orderForm) {
        Gson gson = new Gson();
        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());

        List<OrderDetail> orderDetailList = new ArrayList<>();
        try {
            orderDetailList = gson.fromJson(orderForm.getItems(),
                    new TypeToken<List<OrderDetail>>() {}.getType());
        } catch (Exception e) {
            log.error("[对象转换]错误, string={}", orderForm.getItems());
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        orderDTO.setOrderDetailList(orderDetailList);

        return orderDTO;
    }
}
