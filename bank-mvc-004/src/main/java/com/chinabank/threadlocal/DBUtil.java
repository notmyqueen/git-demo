package com.chinabank.threadlocal;

import java.util.HashMap;
import java.util.Map;

public class DBUtil {
    private final static MyThreadLocal<Connection> local = new MyThreadLocal<>();

    public static Connection getConnection() {
        Connection conn = local.get();
        if(conn == null) {
            conn = new Connection();
            local.set(conn);
        }
        return conn;
    }

}
