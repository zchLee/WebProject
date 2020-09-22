package com.lea.servlet.controller;

import com.lea.servlet.HttpsServlet;
import com.lea.servlet.util.DBUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.MapHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lzc
 * @create 2020/09/21 下午 11:07
 */
// 此处value第一个字符要有 /
@WebServlet("/login")
public class Login extends HttpsServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        // 接受参数
        String username = req.getParameter("username");
        String pwd = req.getParameter("pwd");

        // 校验，
        // 此处图方便，表、dao、service都没有建，第一次学要一步一个脚印的做，我这是复习以前学过的知识
//        Connection connection = DBUtils.getConnection();
//        String sql = "select * from user where username = ? and password = ?";
//        QueryRunner runner = new QueryRunner();
        try {
//            Map<String, Object> result = runner.query(connection, sql, new MapHandler(), username, pwd);
            Map<String, Object> result = new HashMap<>();
//            result.put("s", "v");
            PrintWriter writer = resp.getWriter();
            writer.println("<html>");
            writer.println("<head>");
            writer.println("<meta charset='UTF-8'>");
            writer.println("<title>结果页面</title>");
            writer.println("</head>");
            writer.println("<body>");
            if (!result.isEmpty()) {
                // 返回登录成功
                writer.println("<h1>登录成功</h1>");
            }else {
                writer.println("<h1>账号或密码错误</h1>");
            }
            writer.println("</body>");
            writer.println("</html>");
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
    }
}
