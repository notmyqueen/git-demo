package org.icbc.service;

import org.icbc.pojo.BankAccount;

import java.util.List;

public interface ICBCServiceDao {
    int add(String actno, Double initialBalance);

    int delete(String actno);

    int update(String actno, Double balance);

    BankAccount selectActByActno(String actno);

    int[] batchAdd(List<Object[]> list);

    void transfer(String fromAct, String toAct, Double balance);

    //为了测试事物新建的方法。保存账户信息。
    void save(BankAccount act);

}
