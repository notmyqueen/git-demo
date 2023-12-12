package com.example.bank.service;

import com.example.bank.pojo.Account;

import java.util.List;

public interface AccountService {

    //mapper叫insert，在service里叫save，行规
    int save(Account act);
    int deleteByActno(String actno);
    int modify(Account account);
    Account getByActno(String actno);
    List<Account> getAll();
    void transfer(String fromActno, String toActno, double money);

}
