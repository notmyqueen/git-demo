package org.example.spring6.service;

import org.example.spring6.dao.UserDao;

public class UserService {

    private UserDao userDao;

    //set注入的话，必须提供一个set方法。
    //Spring容器会调用这个set方法，来给userDao属性赋值
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void saveUser() {
        userDao.insert();
    }
}
