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
public class LogFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest)request;
        System.out.println(request.getRemoteAddr());
        System.out.println(request.getRemoteHost());
        System.out.println(request.getRemotePort());
        System.out.println(request.getServerName());
        System.out.println(request.getServerPort());
        System.out.println(new Date());
        System.out.println(httpServletRequest.getRequestURL());
        System.out.println(httpServletRequest.getRequestURI());
        System.out.println(httpServletRequest.getContextPath());
        System.out.println(httpServletRequest.getServletPath());
        System.out.println(httpServletRequest.getQueryString());
        Enumeration attributeNames = request.getAttributeNames();
        Enumeration parameterNames = request.getParameterNames();
        while (attributeNames.hasMoreElements()){
            System.out.println(attributeNames.nextElement()+":"+request.getAttribute((String) attributeNames.nextElement()));
        }
        while (parameterNames.hasMoreElements()){
            String parameterName = (String) parameterNames.nextElement();
            System.out.println(parameterName);
            System.out.println(request.getParameter(parameterName));
        }

        System.out.println("----------------------------");
        //过滤器放行
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
