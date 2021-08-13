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
public enum PayStatusEnum implements CodeEnum<Integer> {

    WAIT(0, "等待支付"),
    SUCCESS(1, "支付成功"),
    ;

    private Integer code;

    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
