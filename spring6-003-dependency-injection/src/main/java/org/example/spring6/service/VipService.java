package org.example.spring6.service;

import org.example.spring6.dao.UserDao;
import org.example.spring6.dao.VipDao;

public class VipService {
    private VipDao vip;
    private UserDao user;

    public VipService() {
        System.out.println("VipService无参构造正在执行。。。");
    }

    public void setVip(VipDao vip) {
        this.vip = vip;
    }

    public void setUser(UserDao user) {
        this.user = user;
    }

    public void save() {
        vip.insert();
        user.insert();
    }
}
