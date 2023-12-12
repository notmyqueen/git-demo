package com.chinabank.threadlocal2;

import com.chinabank.threadlocal.Connection;
import com.chinabank.threadlocal.DBUtil;

public class UserDao {
    public void insert() {
        Connection connection = DBUtil.getConnection();
        System.out.println(connection);
        System.out.println("insert executed!");
    }
}
