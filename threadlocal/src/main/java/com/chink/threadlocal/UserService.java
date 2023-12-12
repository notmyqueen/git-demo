package com.chink.threadlocal;

public class UserService {
    private UserDao dao = new UserDao();
    public void save(Connection conn) {
        Thread thread = Thread.currentThread();
        System.out.println(thread);

        Connection connection = DBUtil.getConnection();
        System.out.println(connection);
        dao.insert();
    }
}
