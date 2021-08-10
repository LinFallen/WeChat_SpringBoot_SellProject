package xyz.wablers.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @author Wablers
 * @version 1.0
 * @description: 订单详情
 * @date 2021/8/10 18:46
 */

@Data
@Entity
public class OrderDetail {

    //订单详情id，使用string，使用KeyUtil手动生成Id，防止多线程冲突，模拟大型项目
    @Id
    private String detailId;
    // 订单id
    private String orderId;
    // 商品id
    private String productId;
    // 商品名称
    private String productName;
    // 单价
    private BigDecimal productPrice;
    // 商品数量
    private Integer productQuantity;
    // 商品小图
    private String productIcon;
}
