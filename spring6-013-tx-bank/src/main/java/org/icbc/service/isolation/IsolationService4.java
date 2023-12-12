package org.icbc.service.isolation;

import jakarta.annotation.Resource;
import org.icbc.dao.ICBCAccountDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("i4")
public class IsolationService4 {
    @Resource
    ICBCAccountDao icbcAccountDao;

    @Transactional
    public void update(String actno, double balance) {
//        icbcAccountDao.update(actno, balance);
        try {
            Thread.sleep(1000*6);
            icbcAccountDao.update(actno, 10.0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
