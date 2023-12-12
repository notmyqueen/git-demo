package com.chink.threadlocal;

import java.util.HashMap;
import java.util.Map;

public class DBUtil {
    private static MyThreadLocal local = new MyThreadLocal();

    public static Connection getConnection() {
        Connection conn = (Connection) local.get();

        if (conn == null) {
            //第一次调用：getConnection()方法的时候，connection一定是空的
            conn = new Connection();
            local.set(conn);
        }

        return conn;
    }
}

