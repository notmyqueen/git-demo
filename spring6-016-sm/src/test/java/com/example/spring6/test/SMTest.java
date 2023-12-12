package com.example.spring6.test;

import com.example.bank.pojo.Account;
import com.example.bank.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SMTest {
    @Test
    public void testSM() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
//        accountService.save(new Account("act-003", 1000.0));
        accountService.transfer("act-001", "act-002", 100);
    }
}
