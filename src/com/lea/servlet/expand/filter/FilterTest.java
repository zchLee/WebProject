package com.lea.servlet.expand.filter;


import com.alibaba.druid.util.StringUtils;

import javax.servlet.AsyncContext;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

/**
 *
 * 过滤器：
 *  在Http服务器被调用资源之前，对服务器尽心拦截
 *  作用：
 *      1. 拦截Http服务器，帮助服务器检测当前请求合法性
 *      2. 拦截Http服务器，对当前请求，进行增强操作
 *
 *  1、实体类要实现Filter接口
 *  2、重写doFile方法
 *  3、在web.xml过滤器中实现注册到Http服务器
 *
 * @author lzc
 * @create 2020/09/24 下午 1:56
 */
public class FilterTest implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 1.通过拦截请求对象得到请求包参数信息， 从而得到来访用户的数据信息
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String contextPath = request.getContextPath();
        System.out.println("请求路劲:" + contextPath);
        String name = request.getParameter("name");
        // 2. 通过逻辑判断后，然后做是否允许请求的操作
        if (!StringUtils.isEmpty(name)) {  // 用户登录了 合法，放行
            // 放行
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            // 不合法,跳转到指定页面
            servletResponse.setContentType("text/html;charset=UTF-8");
            PrintWriter writer = servletResponse.getWriter();
            writer.println("<h1>");
            writer.println("你没登录！");
            writer.println("</h1>");

        }
    }
}
