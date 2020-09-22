package com.lea.servlet.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 全局作用域对象：
 *   每个ServletWeb项目都有且只有一个全局作用域对象。可以作为共享数据供其他Servlet使用
 *
 * 生命周期：
 *      1. 在Http服务器启动过程中，自动在当前项目中，创建一个全局作用域对象
 *      2. 在Http服务器运行期间一直存活
 *      3. 在Http服务器准备关闭时，当前项目的全局作用域对象才会被销毁
 *
 * 怎么获取、设置：
 *          在Servlet实现类中的请求方式方法内，通过 HttpServletRequest 实现类的getServletContext(); 方法获取
 *          request.getServletContext();
 *
 * @author lzc
 * @create 2020/09/22 下午 8:58
 */
public class ServletContextTest extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext application = req.getServletContext();
        // 存放数据
        application.setAttribute("key1", "Servlet1");

    }
}
