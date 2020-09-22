package com.lea.servlet.httpsession;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * HttpSession:服务器端的共享数据，也称为会话作用域对象
 *      同一个用户，同一个浏览器，同一个网站，共享同一个HttpSession
 *
 * HttpSession与Cookie的区别
 *  1.存储位置不同：
 *    Cookie存放在客户端
 *    HttpSession存放在服务器上
 *  2.存放数据类型不同：
 *      Cookies只能存放Sting
 *      Session可以存放任意类型
 *  3.存放数据数量：
 *      一个Cookie只能存放一个
 *      一个Session可以存多个，使用map存储共享数据
 *  4.参照物：
 *      Cookie相当于客户端存储信息
 *      Session相当于服务器端存储信息，相对隐秘安全
 *
 * Session与Cookie怎么关联
 *      Session借Cookie传递JSESSIONId，来标识同一客户端，并返回此客户端所设置的共享数据
 * Session的销毁时机
 *      在浏览器关闭时，意味着用户与他的HttpSession关系切断，
 *      但tomcat无法检测浏览器何时关闭，因此在浏览器关闭时并不会导致tomcat将浏览器关联的HttpSession进行销毁
 *      为了解决此问题，Tomcat给每个Session设置了一个空闲时间
 *      这个空闲时间默认30分钟，如果当前HttpSession对象空闲时间达到了30分钟，此时tomcat会销毁此HttpSession对象
 *
 *      // 空闲时间可设置：
 *          在web/WEB-INF/web.xml
 *              <session-config>
 *                  <session-timeout>5</session-timeout><!-- 当前服务器中，每一个HttpSession的空闲时间是5分钟 -->
 *              </session-config>
 * @author lzc
 * @create 2020/09/22 下午 10:57
 */
public class SessionTest extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取
        HttpSession session = req.getSession();
//        req.getSession(false);  返回当前用户的session，没有返回空
//        session.getId()
        // 添加数据
        session.setAttribute("key", new Object());
//        session.
    }
}
