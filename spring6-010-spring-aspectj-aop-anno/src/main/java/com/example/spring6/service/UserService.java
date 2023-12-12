package com.example.spring6.service;

import org.springframework.stereotype.Service;

@Service("userService")
public class UserService {  //目标类
    //目标方法
    public void login() {
        System.out.println("系统正在进行身份认证。。。。。。");
    }
}
