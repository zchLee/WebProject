package com.lea.servlet.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lzc
 * @create 2020/09/22 下午 9:10
 */
public class OtherServletContext extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext application = req.getServletContext();
        // 从全局作用域中获取指定key的值
        Object key1 = application.getAttribute("key1");
//        this.getServletContext()
        System.out.println(key1);
    }
}
