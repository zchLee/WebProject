package com.lea.servlet.expand.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author lzc
 * @create 2020/09/24 下午 2:53
 */
public class LoginFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String uri = request.getRequestURI();
        System.out.println(uri);
        boolean login = uri.contains("login");
        boolean defaultT = uri.contains("/WebProject_war_exploded/");
        boolean index = uri.contains("index");
        // 登录访问或者默认访问或首页 不拦截
        if (login || defaultT || index) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        HttpSession session = request.getSession(false);
        if (null == session) {
            // 未登录 跳转到登录页面
//            request.getRequestDispatcher("/login.html").forward(request, response);
//            request.getRequestDispatcher("/login").forward(request, response);
//            response.sendRedirect("/WebProject_war_exploded/login");
            response.sendRedirect("/WebProject_war_exploded/login.html");
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);

    }

    @Override
    public void destroy() {

    }
}
