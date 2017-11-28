package com.inks.hb.common;


import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;

import java.sql.SQLException;

/**
 * 数据库工具类 - 使用连接池进行连接
 */
public class DBUtil {

    private static ComboPooledDataSource dataSource;

    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();// 本地线程对象

    static {
        try {
            // 读取配置文件的mysql字段信息
            dataSource = new ComboPooledDataSource("mysql");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 通过连接池对象返回数据库连接
     *
     * @return Connection 连接对象
     * @throws SQLException 数据库错误
     */
    public static Connection getConnection() throws SQLException {
        // 从threadLocal获得连接对象
        Connection conn = threadLocal.get();

        // 如果连接对象不存在或者是已经被关闭的，就从连接池取出一个连接对象返回，如果已经存在，就直接返回
        if (conn == null || conn.isClosed()) {
            conn = dataSource.getConnection();
            // 设置到threadLocal中
            threadLocal.set(conn);
        }
        return conn;
    }


    public static void close() {
        // 从本地线程中获得连接
        Connection conn = threadLocal.get();
        try {
            // 在连接不为空 且 没关闭时
            if (conn != null && !conn.isClosed()) {
                // 解除绑定
                threadLocal.set(null);
                // 关闭连接
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}