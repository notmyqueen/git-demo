package org.icbc.service;

import jakarta.annotation.Resource;
import org.icbc.pojo.BankAccount;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value="service2")
public class ICBCServiceImpl2 implements ICBCServiceDao {
    @Override
    public int add(String actno, Double initialBalance) {
        return 0;
    }

    @Override
    public int delete(String actno) {
        return 0;
    }

    @Override
    public int update(String actno, Double balance) {
        return 0;
    }

    @Override
    public BankAccount selectActByActno(String actno) {
        return null;
    }

    @Override
    public int[] batchAdd(List<Object[]> list) {
        return new int[0];
    }

    @Override
    public void transfer(String fromAct, String toAct, Double balance) {

    }



    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void save(BankAccount act) {

    }
}
