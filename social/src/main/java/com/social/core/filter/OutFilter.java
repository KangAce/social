package com.social.core.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.Enumeration;

/**
 * @package :com.social.core.filter
 *  * @Author        :fjnet
 * @Date :Create in 2018年 11月 28日  15:02 2018/11/28
 * @Description : ${description}
 * @Modified By :
 * @Version :&Version&
 **/
public class OutFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest)request;
        HttpServletResponse httpServletResponse = (HttpServletResponse)response;
        System.out.println(httpServletResponse.getOutputStream());
        ServletOutputStream outputStream = httpServletResponse.getOutputStream();
        System.out.println("------------响应----------------");
        //过滤器放行
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
