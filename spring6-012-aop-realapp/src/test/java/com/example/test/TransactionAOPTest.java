package com.example.test;

import com.example.biz.UserService;
import com.example.biz.VipService;
import com.example.service.AccountService;
import com.example.service.OrderService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TransactionAOPTest {

    @Test
    public void testSecurityLog() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        UserService us = applicationContext.getBean("userService", UserService.class);
        VipService vs = applicationContext.getBean("vipService", VipService.class);

        us.saveUser();
        us.deleteUser();
        us.modifyUser();
        us.getUser();

        vs.saveVip();
        vs.deleteVip();
        vs.modifyVip();
        vs.getVip();

    }

    //编程式事务解决方案
    @Test
    public void testTransaction() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        accountService.transfer();
        accountService.withdraw();
        orderService.generate();
        orderService.cancel();
    }
}
