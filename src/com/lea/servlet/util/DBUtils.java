package com.lea.servlet.util;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.sql.dialect.sqlserver.ast.SQLServerOutput;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author lzc
 * @create 2020/09/21 下午 10:42
 */
public class DBUtils {

    private static DruidDataSource dataSource;

//    private static final ThreadLocal<Connection> THREAD_LOCAL = new ThreadLocal<>();

    static {
        try {
            Properties properties = new Properties();
            InputStream is = DBUtils.class.getClassLoader().getResourceAsStream("database.properties");
            properties.load(is);
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 获取连接
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }

    // 关闭自动提交
    public static Connection begin() {
        Connection connection = null;
        try {
            connection = getConnection();
            connection.setAutoCommit(false);
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }

    // 提交事务
    public static void commit() {
        Connection connection = null;
        try {
            connection = getConnection();
            connection.commit();
        } catch (Exception throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll(connection, null, null);
        }
    }

    // 回滚
    public static void rollback() {
        Connection connection = null;
        try {
            connection = getConnection();
            connection.rollback();
        } catch (Exception throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll(connection, null, null);
        }
    }

    // 关闭连接
    public static void closeAll(Connection con, Statement s, ResultSet rs) {
        if (null != rs) {
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (null != s) {
            try {
                s.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (null != con) {
            try {
                con.close();
//                THREAD_LOCAL.remove();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

}
