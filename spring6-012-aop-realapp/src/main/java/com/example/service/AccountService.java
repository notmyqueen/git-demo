package com.example.service;

import org.springframework.stereotype.Service;

@Service
public class AccountService {
    public void transfer() {
        System.out.println("银行账户正在完成转账操作。。。");
        String s = null;
        s.toString();
    }

    public void withdraw() {
        System.out.println("银行账户正在取款，请稍后");
    }
}
