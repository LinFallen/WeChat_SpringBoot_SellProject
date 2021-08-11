package xyz.wablers.utils;

import java.util.Random;

/**
 * @author Wablers
 * @version 1.0
 * @description: 生成主键工具类
 * @date 2021/8/11 17:12
 */
public class KeyUtil {
    /**
     * @description: 生成唯一主键
     * 在一毫秒内产生冲突的可能性是 1/10000
     * synchronized关键字，防止多线程冲突
     * @return: System.currentTimeMillis() + number
     */
    public static synchronized String genUniqueKey() {
        Random random= new Random();
        // 生成一个四位的随机数
        String number = String.valueOf(random.nextInt(9000) + 1000);
        return System.currentTimeMillis() + number;
    }
}
