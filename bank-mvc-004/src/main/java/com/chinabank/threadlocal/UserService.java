package com.chinabank.threadlocal;

public class UserService {
    public void transfer() {
        Connection connection = DBUtil.getConnection();
        System.out.println("service里的connection："+connection);

        UserDao userDao = new UserDao();
        userDao.update();

        System.out.println("Service的transfer方法执行");
    }
}
