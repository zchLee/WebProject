package com.lea.servlet.expand.listener;

import com.lea.servlet.util.DBUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Connection;

/**
 * 监听器：
 *  来自Servlet规范下接口，共有8个接口。在tomcat存在servlet-api.jar
 *      ServletContextListener：监听全局作用域对象的初始化 contextInitlized(); 和被销毁时执行操作 contextDestory();
 *
 *  监听器需要开发人员自定义，监听器用于监控【作用域对象生命周期的变化时刻】、以及【作用域对象共享数据变化】
 *
 * 2，作用域对象
 *      1）、在servlet规范中，认为在服务器内存可以在两个Servlet之间提供数据共享的方案的对象，就被称为作用域对象
 *      2）、Servlet规范下作用域对象
 *          ServletContext：全局作用域对象
 *          HttpSession：会话作用域对象
 *          HttpServletRequest: 请求作用域对象
 *
 *  3.监听器接口实现类开发规范：三步
 *      1）、根据实际情况，选择对应的监听接口进行实现
 *      2）、重写监听事件接口，【监听事件处理方法】
 *      3）、在web.xml文件中，监听接口注册到Http服务器
 * @author lzc
 * @create 2020/09/23 下午 1:22
 */
public class ListenerTest implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
//        ThreadLocal<Connection> connPool = new ThreadLocal<>();
        // 为了防止每次连接，都要连接数据库浪费数据库资源，此处定义一个线程池
//        for (int i = 0; i < 20; i++) {
//            Connection conn = DBUtils.getConnection();
//            System.out.println(conn);
//            connPool.set(conn);
//        }
        System.out.println("初始化，我context来世走一遭。");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("销毁，context：人间不值得，下辈子我要做一条狗");
    }
}
