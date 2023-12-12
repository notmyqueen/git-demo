package com.example.bank.practice.dao;

import com.example.bank.practice.pojo.BankAccount;

public interface AccountDao {
    //增加账户
    int addAccount(String actno, Double balance);
}
