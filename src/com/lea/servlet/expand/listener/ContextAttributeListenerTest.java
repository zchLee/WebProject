package com.lea.servlet.expand.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

/**
 *
 * ServletContextAttributeListener: 检测全局作用域对象共享数据变化
 *            contextAdd()        全局作用域对象添加共享数据
 *            contextReplace()    在全局作用域对象更新共享数据
 *            contextRemove()     在全局作用域对象删除共享数据
 *
 * 实现接口，还要去web.xml里配置，注册到服务器
 *
 * @author lzc
 * @create 2020/09/23 下午 2:31
 */
public class ContextAttributeListenerTest implements ServletContextAttributeListener {
    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
        System.out.println("添加了：" + event.getName() + "--" + event.getValue());
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent event) {
        System.out.println("删除了数据：" + event.getName() + "--" + event.getValue());
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent event) {
        System.out.println("更新了数据：" + event.getName() + "--" + event.getValue());
    }
}
