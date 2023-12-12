package org.icbc.service.propagation;

import jakarta.annotation.Resource;
import org.icbc.dao.ICBCAccountDao;
import org.icbc.pojo.BankAccount;
import org.icbc.service.ICBCServiceDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("s2")
public class ICBCService2 implements ICBCServiceDao {

    @Resource
    private ICBCAccountDao icbcAccountDao;

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
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void save(BankAccount act) {
        icbcAccountDao.add(act.getActno(), act.getBalance());
        //模拟异常
        String s = null;
        s.toString();
    }
}
