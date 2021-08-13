package xyz.wablers.enums;

/**
 * @author Wablers
 * @version 1.0
 * @description: 约定枚举类都必须实现CodeEnum中的方法
 * @date 2021/8/13 16:12
 */
public interface CodeEnum<T>
{
    T getCode();
}

