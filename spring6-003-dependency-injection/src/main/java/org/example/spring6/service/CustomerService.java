package org.example.spring6.service;

import org.example.spring6.dao.UserDao;
import org.example.spring6.dao.VipDao;

public class CustomerService {
    private UserDao ud;
    private VipDao vip;

    public CustomerService(UserDao ud, VipDao vip) {
        this.ud = ud;
        this.vip = vip;
    }

    public void insertCustomer() {
        ud.insert();
        vip.insert();
    }
}
