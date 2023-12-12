package net.bank.utils;

import java.sql.*;
import java.util.ResourceBundle;

public class DBUtil {

    private DBUtil() {
    }

    private final static ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
    private final static String driver = bundle.getString("driver");
    private final static String url = bundle.getString("url");
    private final static String user = bundle.getString("username");
    private final static String password = bundle.getString("password");

    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public static void close(Connection conn, Statement ps, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        if(conn!=null) {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
