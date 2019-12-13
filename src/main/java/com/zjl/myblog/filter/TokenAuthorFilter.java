package com.zjl.myblog.filter;

import com.zjl.myblog.constant.ViewConsts;
import com.zjl.myblog.util.CookieUtil;
import com.zjl.myblog.util.IpUtil;
import com.zjl.myblog.util.LogUtil;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author JLZHANG
 * @version 5.1.0 2019/12/13
 * @date: 2019/12/13
 * @function: TODO
 */
@WebFilter(filterName = "TokenAuthorFilter",urlPatterns = "/*")
public class TokenAuthorFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 强转
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        HttpServletResponse response=(HttpServletResponse)servletResponse;
        // 获取token
        String token=CookieUtil.getCookie ( request,ViewConsts.TOKEN );
        // 获取ip
        String ip=IpUtil.getIpAddr ( request );
        if(StringUtils.isEmpty ( token )){
            request.setAttribute ( ViewConsts.TOKEN, ViewConsts.USER_STATUS);
            LogUtil.info ( TokenAuthorFilter.class,"该用户未登录，他的IP是：{0}",ip);
        }
        else {
            LogUtil.info(TokenAuthorFilter.class, "该用户已登录，他的Cookie和IP是{0}：", token, ip);
        }
        filterChain.doFilter ( request,response );
    }

}
