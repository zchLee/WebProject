package com.lea.servlet.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lzc
 * @create 2020/09/21 下午 11:36
 */
@WebServlet("/A")
public class ForwardA extends HttpServlet {

    /*
        forward:
            1.服务器内部转发，对用户不可见
            2.共享同一个request作用域
                request作用域：拥有存储数据的空间，作用域是一次请求有效（包含多次转发）
                可以将数据存入request后，在一次请求过程中的任何位置进行获取，可以传递任何类型数据

                存：req.setAttribute("key", new Object());

                取：req.getAttribute("key", new Object());
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("key", new Object());
        // 转发路劲可以是同样的servlet，也可以是jsp文件，jsp是servlet的另一种表达形式
        req.getRequestDispatcher("B").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
