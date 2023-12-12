package com.example.bank.practice.service;

import com.example.bank.practice.dao.AccountDao;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

@Component("actService")
public class ActServiceImpl implements ActService {

    @Resource(name="accountDaoImpl")
    private AccountDao accountDao;

    @Override
    public int addAccount(String actno, Double balance) {
        int count = accountDao.addAccount(actno, balance);
        return count;
    }
}
