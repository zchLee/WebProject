package com.lea.servlet.httpsession;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @author lzc
 * @create 2020/09/22 下午 11:09
 */
public class OtherSession extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取
        HttpSession session = req.getSession();
//        session.getId()  唯一sessionId
        // 获取当前会话的所有session names
        Enumeration<String> attributeNames = session.getAttributeNames();
        // 通过key获取value
        Object key = session.getAttribute("key");
    }
}