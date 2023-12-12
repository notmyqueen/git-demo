package org.icbc.dao;

import org.icbc.pojo.BankAccount;

import java.util.List;

public interface ICBCAccountDao {

    //增
    int add(String actno, Double initialBalance);

    //删
    int delete(String actno);

    //改
    int update(String act, Double balance);

    //查
    BankAccount selectAccountByActNo(String actno);

    //批量添加
    int[] batchAdd(List<Object[]> list);
}
