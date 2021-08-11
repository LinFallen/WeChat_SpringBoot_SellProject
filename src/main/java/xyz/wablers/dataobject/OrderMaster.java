package xyz.wablers.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import xyz.wablers.enums.OrderStatusEnum;
import xyz.wablers.enums.PayStatusEnum;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author Wablers
 * @version 1.0
 * @description: 订单概要表
 * @date 2021/8/10 13:21
 */

@Entity
@Data
@DynamicUpdate
@DynamicInsert
public class OrderMaster {

    // 订单id
    @Id
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
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();
    // 支付状态, 默认0为未支付
    private Integer payStatus = PayStatusEnum.WAIT.getCode();
    // 创建时间
    private Date createTime;
    // 更新时间
    private Date updateTime;
}
