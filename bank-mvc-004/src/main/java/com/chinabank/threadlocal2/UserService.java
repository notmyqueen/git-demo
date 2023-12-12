package com.chinabank.threadlocal2;

import com.chinabank.threadlocal.DBUtil;

public class UserService {

    private UserDao dao = new UserDao();

    public void transfer() {
        System.out.println(DBUtil.getConnection());
        dao.insert();
        System.out.println("transfer executed");
    }

}
