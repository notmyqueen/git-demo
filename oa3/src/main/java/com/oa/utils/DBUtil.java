package com.oa.utils;

import jakarta.servlet.annotation.WebServlet;

import java.sql.*;
import java.util.ResourceBundle;

/*
    JDBC的工具类
 */
public class DBUtil {

    //静态变量：在类加载时执行。并且是有顺序的。
    private static ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
    private static String driver = bundle.getString("driver");
    private static String url = bundle.getString("url");
    private static String user = bundle.getString("user");
    private static String password = bundle.getString("password");

    static {
        //注册驱动(注册驱动只需要注册一次，放在静态代码块中。DBUtil类加载的时候执行。)
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //获取连接对象
    public static Connection getConnection() throws SQLException {
        //获取连接
        return DriverManager.getConnection(url, user, password);
    }

    //释放资源
    public static void close(Connection conn, Statement ps, ResultSet rs) {
        if(rs!=null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(ps!=null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(conn!=null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
