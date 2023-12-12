package org.icbc.service.isolation;

import jakarta.annotation.Resource;
import org.icbc.dao.ICBCAccountDao;
import org.icbc.pojo.BankAccount;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service("i1")
public class IsolationService1 {

    @Resource
    private ICBCAccountDao accountDao;

    //1号Service
    //负责查询
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)  //能读到别的线程未提交的数据
    public void getByActno(String actno) {
        BankAccount bankAccount = accountDao.selectAccountByActNo((actno));
        System.out.println("查询到的账户信息："+bankAccount);
    }


}
