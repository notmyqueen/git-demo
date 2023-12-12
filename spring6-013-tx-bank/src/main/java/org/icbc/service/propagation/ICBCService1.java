package org.icbc.service.propagation;

import jakarta.annotation.Resource;
import org.icbc.dao.ICBCAccountDao;
import org.icbc.pojo.BankAccount;
import org.icbc.service.ICBCServiceDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("s1")
public class ICBCService1 implements ICBCServiceDao {

    @Resource
    private ICBCAccountDao icbcAccountDao;

    @Resource(name="s2")
    private ICBCServiceDao service2;


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
        icbcAccountDao.add(act.getActno(), act.getBalance());

        //以下try...catch...很重要。如果没有try catch，即便service2.save()方法是Propagation.REQUIRES_NEW，也是连带这个s1统统回滚，即一个账户都不会建立。
        try {
            service2.save(new BankAccount("act-004", 1000.0));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
