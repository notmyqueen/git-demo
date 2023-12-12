package com.example.bank.service.impl;

import com.example.bank.dao.AccountDao;
import com.example.bank.pojo.Account;
import com.example.bank.service.AccountService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

//@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Resource(name = "accountDao")
    private AccountDao accountDao;

    //控制事物，因为在这个方法中要完成所有的转账业务
    @Override
    public void transfer(String fromActno, String toActno, double money) {
        //查询转出账户的余额是否充足
        Account fromAct = accountDao.selectByActno(fromActno);
        if (fromAct.getBalance() < money) {
            throw new RuntimeException("余额不足！！！");
        }
        //余额充足
        Account toAct = accountDao.selectByActno(toActno);

        //将内存中两个对象的余额先修改
        fromAct.setBalance(fromAct.getBalance() - money);
        toAct.setBalance(toAct.getBalance() + money);

        //数据库更新
        int count = accountDao.update(fromAct);
        count += accountDao.update(toAct);

        if (count != 2) {
            throw new RuntimeException("转账失败，联系银行！");
        }
    }
}
