package com.example.biz;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    public void saveUser() {
        System.out.println("新增用户");
    }

    public void deleteUser() {
        System.out.println("删除用户");
    }

    public void modifyUser() {
        System.out.println("修改用户");
    }

    public void getUser() {
        System.out.println("查询用户");
    }
}
