package com.chinabank.threadlocal;

public class UserDao {
    public void update() {
        Connection connection = DBUtil.getConnection();
        System.out.println("dao里的connection："+connection);

        System.out.println("Dao的update方法执行");
    }
}
