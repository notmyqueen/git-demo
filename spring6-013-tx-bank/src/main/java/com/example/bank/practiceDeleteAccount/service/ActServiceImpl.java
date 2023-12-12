package com.example.bank.practiceDeleteAccount.service;

import com.example.bank.practice.pojo.BankAccount;
import com.example.bank.practiceDeleteAccount.dao.ActDao;
import com.example.bank.practiceDeleteAccount.dao.ActDaoImpl;
import org.springframework.stereotype.Service;

@Service
public class ActServiceImpl implements ActService{
    @Override
    public void transferToAct001(BankAccount actno) {
        //第一步：delete account
        ActDao actDao = new ActDaoImpl();
        actDao.delete(actno);
        //第二步：transfer money
        //2.1 get act-001's balance
//        String sql =
//        actno.getBalance();
    }
}
