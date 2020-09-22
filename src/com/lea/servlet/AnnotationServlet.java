package com.lea.servlet;

import javax.servlet.annotation.WebServlet;

/**
 *
 * String name() default "";  servlet名字
 *
 * String[] value() default {}; 配置url路径，可以配置多个
 *
 * String[] urlPatterns() default {}; 配置url路径，和value作用一样，但是不能和value同时使用
 *
 * int loadOnStartup() default -1;  加载顺序 默认为-1，请求时，创建实例
 *
 *  // 下面的没用过，过一眼就成
 *      WebInitParam[] initParams() default {};
 *      boolean asyncSupported() default false;
 *      String smallIcon() default "";
 *      String largeIcon() default "";
 *      String description() default "";
 *      String displayName() default "";
 *
 * @author lzc
 * @create 2020/09/21 下午 9:06
 */
@WebServlet(value = {"/hello","/hi"})
public class AnnotationServlet extends HttpsServlet {


}
