package xyz.wablers.enums;

import lombok.Getter;

/**
 * @author Wablers
 * @version 1.0
 * @description: 订单状态枚举
 * @date 2021/8/10 17:49
 */
@Getter
public enum OrderStatusEnum implements CodeEnum<Integer> {
    NEW(0, "新订单"),
    FINISHED(1, "完结"),
    CANCEL(2, "已取消"),
    ;

    private Integer code;

    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
