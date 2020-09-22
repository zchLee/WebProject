package com.lea.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * 推荐此方法实现Servlet
 * HttpServlet 继承于GenericServlet 在专注service方法后，
 * 1.将请求 Request，响应 response 做了封装，
 * 2.优化请求方式
 * 3.在Http服务器运行期间，一个Servlet实现类，只能被创建一个实例对象
 * 4.在Http服务器关闭时刻，将所有Servlet实现了都销毁
 *
 * // 与请求协议无关的service方法
 *     public void service(ServletRequest req, ServletResponse res)
 *
 *  HttpServlet service(): 使用了设计模式
 *     根据不同请求方式，调用不同方法，（doGet doPost等） 这些方法由子类来实现
 * @author lzc
 * @create 2020/09/21 下午 8:28
 */
public class HttpsServlet extends HttpServlet {

    /*
    特定Http协议请求的service方法，将此方法交给父类HttpServlet操作，
     判断进入不同请求方式的方法，
     我们只需要重写Http协议不同请求方式的方法
     */
//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        // 在响应里写入返回数据
//        ServletOutputStream outputStream = resp.getOutputStream();
//        outputStream.write("I get you ".getBytes());
//        outputStream.close();
//    }

    /*
    HttpServletRequest：
        读取请求协议包中的信息，封装到请求对象
        作用：
            1.读取Http协议包请求行中的信息
            2.保存请求头或请求参数信息
            3.可以代替浏览器向Http服务器申请资源文件调用
    HttpServletResponse:
        实现类由Http服务器提供，将doGet/doPost方法执行结果写入到响应体中交给浏览器处理
        主要功能：
            1.将执行结果，以二进制数组写入响应体中
            2.设置响应头的content-type属性值，从而控制浏览器使用对应编译器将响应体 二进制数组编译成【文字、图片、视屏、命令】
            3.设置响应头中的 location 属性，将一个请求地址赋值给location。从而控制浏览器向指定服务器发送请求（重定向）
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 请求体
        // 读取url等信息
        StringBuffer requestURL = req.getRequestURL();
        // 获得参数 获得所有的参数名称
        Enumeration<String> parameterNames = req.getParameterNames();
        String keyname = req.getParameter("keyname");
        // 服务器内转发
        req.getRequestDispatcher("/a").forward(req, resp);


        // 响应体
        // 在响应里写入返回数据,tomcat将响应体 推向客户端
        resp.setContentType("text/html;charset=UTF-8");  //content-type 客户端通过此配置，做出对应处理，默认是text
        String url = "https://www.baidu.com?q=中国好声音";
//        resp.setLocale();

        ServletOutputStream outputStream = resp.getOutputStream();
        outputStream.write("<h1>I get you. this get </h1>".getBytes());
        outputStream.write("</br>吃个寂寞".getBytes());
        outputStream.close();
//        重定向
        // 通过响应对象，将地址赋值给响应头中的location属性， 然后友浏览器重新转发请求
        resp.sendRedirect(url);
//        resp.encodeRedirectURL()
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8"); // 设置请求体，编码格式
        ServletOutputStream outputStream = resp.getOutputStream();
        outputStream.write("i'm post. you are safe. ".getBytes());
        outputStream.close();
    }
}
