package com.lea.servlet.cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Cookie 存在于Servlet-api.jar
 *      同一个浏览器/用户提供服务，此时可以借助Cookie对象进行共享数据
 *      Cookie存放当前用户的私人数据，在共享数据过程中，提高服务质量
 *
 * 操作步骤：
 *      1.用户通过浏览器第一次向服务器请求时，对应servlet就创建一个Cookie存储于当前用户相关数据
 *      2.最后将Cookie写入响应头，返回给浏览器
 *      3.浏览器在收到响应包后，将cookie保存在浏览器缓存中
 *      此后同用户，同浏览器访问Http服务时，浏览器会将Cookie放到请求体中。发送到服务器
 *
 * Cookie销毁时机：
 *      1.默认情况下，Cookie对象存在与浏览器缓存中，因此浏览器关闭时，Cookie就会被销毁
 *      // 可以手动设置，要求客户端将接受的Cookie存放在客户端计算机硬盘上（需要制定存活时间）,
 *      在这个存活时间内，关闭浏览器，关闭服务器都不会导致cookie失效
 * @author lzc
 * @create 2020/09/22 下午 9:17
 */
public class CookieTest extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求发送过来的多个cookie
        Cookie[] cookies = req.getCookies();
        if (null == cookies || cookies.length == 0) { // 请求没有带cookie，新建cookie
            // 一个cookie只能放一个键值对,key不能是中文
            Cookie cookie = new Cookie("key","value");
            cookie.setMaxAge(60); // 设置cookie过期时间，存活60秒
            // 将Cookie放进响应体中，返回给浏览器
            resp.addCookie(cookie);
        }


    }
}
