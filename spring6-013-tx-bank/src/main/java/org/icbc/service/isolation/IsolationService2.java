package org.icbc.service.isolation;

import jakarta.annotation.Resource;
import org.icbc.dao.ICBCAccountDao;
import org.icbc.pojo.BankAccount;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("i2")
public class IsolationService2 {

    @Resource
    private ICBCAccountDao icbcAccountDao;

    //2号Service
    //负责insert
    @Transactional
    public void save(BankAccount act) {
        icbcAccountDao.add(act.getActno(), act.getBalance());
        try {
            Thread.sleep(1000 * 20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String s = null;
        s.toString();
    }
}
