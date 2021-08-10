package xyz.wablers.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Wablers
 * @version 1.0
 * @description: 商品状态枚举
 * @date 2021/8/5 14:09
 */

@Getter
@AllArgsConstructor
public enum ProductStatusEnum {
    UP(0, "在上架"),
    DOWN(1, "已下架");
    // 状态码
    private Integer code;
    // 商品状态描述
    private String message;
}
