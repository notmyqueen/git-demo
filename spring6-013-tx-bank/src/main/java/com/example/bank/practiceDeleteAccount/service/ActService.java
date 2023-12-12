package com.example.bank.practiceDeleteAccount.service;

import com.example.bank.practice.pojo.BankAccount;

public interface ActService {
    //此service的内容是将删除账户的余额转至act-001
    void transferToAct001(BankAccount actno);
}
