package inks.hb.common;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;

import java.sql.SQLException;

/**
 * 数据库工具类 - 使用连接池进行连接
 * c3p0可以自动回收空闲的连接～～～
 */
public class DBUtil {

    private static ComboPooledDataSource dataSource;

    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();// 本地线程对象

    static {
        try {
            dataSource = new ComboPooledDataSource("mysql"); //自动读取配置信息
        } catch (Exception e) {
            System.out.println("Exception：" + e.getMessage());
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

        // 测试语句
        //System.out.println("获得数据库连接：" + conn + "剩余空闲连接数=" + dataSource.getNumIdleConnections());

        return conn;
    }
}
