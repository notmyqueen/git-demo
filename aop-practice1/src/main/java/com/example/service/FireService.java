package com.example.service;

import org.springframework.stereotype.Service;

//目标类
@Service("fireService")
public class FireService {
    public void fire() {  //目标方法
        System.out.println("启动开火服务。。。");
        System.out.println("git test");
        System.out.println("git test");
    }
}
