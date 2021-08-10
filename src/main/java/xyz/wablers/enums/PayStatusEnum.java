package xyz.wablers.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Wablers
 * @version 1.0
 * @description: 支付状态枚举
 * @date 2021/8/10 18:41
 */

@Getter
@AllArgsConstructor
public enum PayStatusEnum {
    WAIT(0, "未支付"),
    SUCCESS(1, "支付成功");

    private Integer code;

    private String message;
}
