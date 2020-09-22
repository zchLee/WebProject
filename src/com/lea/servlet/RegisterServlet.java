package com.lea.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * HttpServletRequest:客户端请求信息
 * HttpServletResponse：服务端响应客户端输出信息
 * @author lzc
 * @create 2020/09/21 下午 9:33
 */
@WebServlet("/rs")
public class RegisterServlet extends HttpsServlet {

    // tomcat8以后的版本对url的编码格式进行了自动转换
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("提交的数据:" + username + "\t" + password);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 中文乱码解决方案
        req.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
//        System.out.println("提交的数据:" + username + "\t" + password);

//        resp.setCharacterEncoding("UTF-8");  // 设置服务器端编码格式
//        resp.setHeader("ContentType","text/html;charset=UTF-8");

        resp.setContentType("text/html;charset=UTF-8");  // 设置响应编码格式
        PrintWriter writer = resp.getWriter();
//        writer.println("register success!");
        writer.println("注册成功");
    }
}
