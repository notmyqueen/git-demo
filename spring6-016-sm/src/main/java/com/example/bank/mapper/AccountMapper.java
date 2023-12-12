package com.example.bank.mapper;

import com.example.bank.pojo.Account;

import java.util.List;

//该接口的实现类不需要写，是mybatis通过动态代理机制生成的实现类。（need to review 动态代理）
public interface AccountMapper {
    int insert(Account account);
    int deleteByActno(String actno);
    int update(Account account);
    Account selectByActno(String actno);

    //查询所有账户
    List<Account> selectAll();
}
