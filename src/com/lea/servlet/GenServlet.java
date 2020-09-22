package com.lea.servlet;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * 专注service方法，简化了servlet开发，只关心业务本身
 *  实现了简单的init和destroy
 *  与协议无关
 *
 * @author lzc
 * @create 2020/09/21 下午 8:21
 */
public class GenServlet extends GenericServlet {

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("简洁的Servlet.. ");
    }
}
