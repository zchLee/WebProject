package com.lea.servlet;

import javax.servlet.http.HttpServlet;

/**
 *
 * 配置初始页面需要去tomcat安装目录下，conf文件夹下的web.xml 最下面修改配置
 *    <welcome-file-list>
 *           <welcome-file>index.html</welcome-file>
 *           <welcome-file>index.htm</welcome-file>
 *           <welcome-file>index.jsp</welcome-file>
 *    </welcome-file-list>
 *
 *  也可以自定义设置:
 *      在web/WEB-INF/web.xml 配置
 *      <welcome-file-list>
 *             <welcome-file>login.html</welcome-file>
 *      </welcome-file-list>
 * @author lzc
 * @create 2020/09/22 下午 5:25
 */
public class SetDefaultSourceServlet extends HttpServlet {
}
