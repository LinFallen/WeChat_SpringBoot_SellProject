package xyz.wablers.constant;

/**
 * @author Wablers
 * @version 1.0
 * @description: redis有关常量
 * @date 2021/8/9 14:20
 */
public interface RedisConstant {

    /**
     * @description:  生成token的前缀，即生成token的格式应该是token_xxxxxxx
     * @param: null
     */
    String TOKEN_PREFIX = "token_%s";

    /**
     * @description:  redis过期时间，2小时，单位:秒
     * @param: null
     */
    Integer EXPIRE = 7200;
}
