package com.zjl.myblog.util;

import com.zjl.myblog.constant.ViewConsts;
import org.springframework.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author JLZHANG
 * @version 5.1.0 2019/12/13
 * @date: 2019/12/13
 * @function: TODO
 */
public class CookieUtil {

    public static String getCookie(HttpServletRequest request, String cookieName) {

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(cookieName)) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    public static String getCookie(HttpServletRequest request){
        String token=(String)request.getAttribute ( ViewConsts.TOKEN );
        if(StringUtils.isEmpty ( token )){
            return null;
        }
        return token;
    }
    public static void writeCookie(HttpServletResponse response, String cookieName, String value) {
        Cookie cookie = new Cookie(cookieName, value);
        cookie.setPath("/");
        cookie.setMaxAge(24*60* 60);
        response.addCookie(cookie);
    }

}
