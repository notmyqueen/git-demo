package org.icbc.service.isolation;

import jakarta.annotation.Resource;
import org.icbc.dao.ICBCAccountDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

//测试不可重复读
@Service("i3")
public class IsolationService3 {
    @Resource
    ICBCAccountDao icbcAccountDao;

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public void read(String actno) {
        System.out.println(icbcAccountDao.selectAccountByActNo(actno));
        try {
            Thread.sleep(1000*20);
            System.out.println(icbcAccountDao.selectAccountByActNo(actno));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
