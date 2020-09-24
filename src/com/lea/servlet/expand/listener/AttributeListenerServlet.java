package com.lea.servlet.expand.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lzc
 * @create 2020/09/23 下午 2:34
 */
@WebServlet("/listener/contextAttribute")
public class AttributeListenerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = req.getServletContext();
        // 添加数据
        context.setAttribute("liam", "get chicken");
        // 更新数据
        context.setAttribute("liam", "get much beef");
        // 添加一条新数据
        context.setAttribute("qiqi", "how are you?");
        // 删除数据
        context.removeAttribute("liam"); // 刚开始时，liam写错了，所有没有删除成功，就没有触发删除监听器方法
    }
}
