package net.lolm;

public class DBUtil {
    private static MyThreadLocal<Connection> local = new MyThreadLocal<>();

    public static Connection getConnection() {

        Connection conn = local.get();
        if (conn == null) {
            //使用了泛型后，connection永远都是在这里new的！！！只有这一个connection，因此实现了事务！
            conn = new Connection();
            local.set(conn);
        }
        return conn;
    }
}
