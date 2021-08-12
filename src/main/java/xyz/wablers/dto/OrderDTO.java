package xyz.wablers.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import xyz.wablers.dataobject.OrderDetail;
import xyz.wablers.enums.OrderStatusEnum;
import xyz.wablers.enums.PayStatusEnum;
import xyz.wablers.utils.serializer.Date2LongSerializer;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author Wablers
 * @version 1.0
 * @description: 订单公用数据传输
 * @date 2021/8/11 13:45
 */

@Data
public class OrderDTO {

    // 订单id
    private String orderId;
    // 买家名字
    private String buyerName;
    // 买家手机号
    private String buyerPhone;
    // 买家地址
    private String buyerAddress;
    // 买家微信
    private String buyerOpenid;
    // 订单总金额
    private BigDecimal orderAmount;
    // 订单状态, 默认0为新下单
    private Integer orderStatus;
    // 支付状态, 默认0为未支付
    private Integer payStatus;
    // 创建时间，@JsonSerialize使其生成json时自动按Date2LongSerializer类要求进行转换
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;
    // 更新时间
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;
    // 该订单概要对应的订单详情，一对多关系，@JsonInclude当该字段值为null时，生成json不包含该字段
    //@JsonInclude(JsonInclude.Include.NON_EMPTY)
    List<OrderDetail> orderDetailList;
}
