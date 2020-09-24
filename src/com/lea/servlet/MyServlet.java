package com.lea.servlet;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * 除了startup.bat启动之外
 * catalina run 命令也可以启动：执行时可以查看打印的异常
 *
 * 规范：
 *  1.Servlet规范来自于java规范中的一种
 *  2.作用：
 *      1. 在Servlet中，指定 动态资源文件开发步骤
 *      2. 在Servlet规范中，指定Http服务器调用动态资源文件规则
 *      3. 指定Http服务器管理动态资源文件实例对象规则
 *
 * Servlet生命周期：
 *  实例化：当访问servlet时，容器会实例化Servlet，如果load-on-startup >= 0 时 容器启动时，会自动创建。只会执行一次
 *  初始化： 初始化阶段会调用，也只会调用一次
 *  服务： 可能会执行多次，收到request 和 response 处理逻辑，在一个连接未销毁时，此方法可能会被调用多次
 *  销毁： 当容器停止，或重启，都会引起销毁Servlet对象，只执行一次
 *
 *
 *  配置初始页面需要去tomcat安装目录下，conf文件夹下的web.xml 最下面修改配置
 *  <welcome-file-list>
 *         <welcome-file>index.html</welcome-file>
 *         <welcome-file>index.htm</welcome-file>
 *         <welcome-file>index.jsp</welcome-file>
 *     </welcome-file-list>
 *
 * @author lzc
 * @create 2020/09/21 下午 6:03
 */
public class MyServlet implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("hi,we are coming");
        System.out.println("态度决定成败");
        System.out.println("2020我们会有更好的未来");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
