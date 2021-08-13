package xyz.wablers.utils;

import xyz.wablers.enums.CodeEnum;

/**
 * @author Wablers
 * @version 1.0
 * @description: 枚举常量工具类
 * @date 2021/8/13 16:11
 */
public class EnumUtil {

    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass) {
        for (T each: enumClass.getEnumConstants()) {
            if (code.equals(each.getCode())) {
                return each;
            }
        }
        return null;
    }
}
