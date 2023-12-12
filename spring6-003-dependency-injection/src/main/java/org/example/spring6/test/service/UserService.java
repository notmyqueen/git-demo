package org.example.spring6.test.service;

import org.example.spring6.test.dao.UserDao;

public class UserService {
    private UserDao userdao;

    public void setUserdao(UserDao userdao) {
        this.userdao = userdao;
    }

    public void generate() {
        System.out.println("User生成中！");
    }
}
