package com.zjl.myblog.filter;

import com.zjl.myblog.constant.ViewConsts;
import com.zjl.myblog.util.CookieUtil;
import com.zjl.myblog.util.IpUtil;
import com.zjl.myblog.util.LogUtil;
import lombok.extern.java.Log;
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
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 强转
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        HttpServletResponse response=(HttpServletResponse)servletResponse;
        // 获取token
        String token=CookieUtil.getCookie ( request,ViewConsts.TOKEN );
        if(StringUtils.isEmpty ( token )){
            request.setAttribute ( ViewConsts.TOKEN, ViewConsts.USER_STATUS);
            LogUtil.info ( TokenAuthorFilter.class,"该用户未登录，他的IP是：{0}",IpUtil.getIpAddr ( request ) );
        }
        LogUtil.info (  TokenAuthorFilter.class, "该用户已登录，他的Cookie是：{0}",token);
        filterChain.doFilter ( request,response );
    }

    @Override
    public void destroy() {

    }
}
