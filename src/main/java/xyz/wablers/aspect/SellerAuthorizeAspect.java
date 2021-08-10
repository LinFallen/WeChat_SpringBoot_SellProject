package xyz.wablers.aspect;

import com.mysql.cj.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import xyz.wablers.constant.CookieConstant;
import xyz.wablers.constant.RedisConstant;
import xyz.wablers.exception.SellerAuthorizeException;
import xyz.wablers.utils.CookieUtil;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Wablers
 * @version 1.0
 * @description: 日志切面
 * @date 2021/8/9 13:23
 */

@Aspect
@Slf4j
@Component
public class SellerAuthorizeAspect {

    @Autowired
    private StringRedisTemplate redisTemplate;

    //
    /**
     * @description:  切点范围为xyz.wablers.controller包下除SellerUserController的所有Seller*
     */
    @Pointcut("execution(public * xyz.wablers.controller..Seller*.*(..)) && " +
            "!execution(public * xyz.wablers.controller..SellerUserController.*(..))")
    public void verify() {
    }

    @Before("verify()")
    public void doVerify() {
        // 获取HttpSerRequest
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 获取cookie
        Cookie cookie = CookieUtil.getCookie(request, CookieConstant.TOKEN);

        if (cookie == null) {
            //
            log.warn("【登陆校验】登录失败，cookie为空");
            throw new SellerAuthorizeException();
        }

        String token = redisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_PREFIX,cookie.getValue()));

        if (StringUtils.isEmptyOrWhitespaceOnly(token)) {
            //如果redis中不存在
            log.warn("【登陆校验】登录失败，redis查询为空");
            throw new SellerAuthorizeException();
        }
    }


}
