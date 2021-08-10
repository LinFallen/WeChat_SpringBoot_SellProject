package xyz.wablers.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description:  cookie工具类
 * @param: null
 * @return:
 */
public class CookieUtil {

    /**
     * 设置cookie值
     */
    public static void setCookie(HttpServletResponse response,String key,String value,Integer expire){
        Cookie cookie = new Cookie(key,value);
        cookie.setPath("/");
        cookie.setMaxAge(expire);
        response.addCookie(cookie);
    }

    /**
     * 获取key为name的cookie
     */
    public static Cookie getCookie(HttpServletRequest request,String name){
        Cookie[] cookies = request.getCookies();
        if (cookies == null) return null;
        for (Cookie cookie : cookies){
            if (cookie.getName().equals(name)){
                return cookie;
            }
        }
        return null;
    }
}
