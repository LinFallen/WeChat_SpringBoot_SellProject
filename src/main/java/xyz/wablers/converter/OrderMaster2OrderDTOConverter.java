package xyz.wablers.converter;

import org.springframework.beans.BeanUtils;
import xyz.wablers.dataobject.OrderMaster;
import xyz.wablers.dto.OrderDTO;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Wablers
 * @version 1.0
 * @description: 将OrderMaster类转换为OrderDto类
 * @date 2021/8/12 15:37
 */
public class OrderMaster2OrderDTOConverter {
    public static OrderDTO convert(OrderMaster orderMaster) {
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster, orderDTO);
        return orderDTO;
    }

    public static List<OrderDTO> convert(List<OrderMaster> orderMasters) {
        return orderMasters.stream().map(e -> convert(e)).collect(Collectors.toList());
    }
}
