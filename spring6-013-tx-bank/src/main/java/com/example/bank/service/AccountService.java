package com.example.bank.service;

//业务接口
//事物就是在这个接口下控制的
public interface AccountService {

    void transfer(String fromActno, String toActno, double money);

}
