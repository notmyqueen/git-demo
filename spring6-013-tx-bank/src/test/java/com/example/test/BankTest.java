package com.example.test;

import com.example.bank.practice.service.ActService;
import com.example.bank.practice.service.ActServiceImpl;
import org.icbc.pojo.BankAccount;
import org.icbc.service.ICBCServiceDao;
import org.icbc.service.ICBCServiceDaoImpl;
import org.icbc.service.isolation.IsolationService1;
import org.icbc.service.isolation.IsolationService2;
import org.icbc.service.isolation.IsolationService3;
import org.icbc.service.isolation.IsolationService4;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.Arrays;

public class BankTest {

    @Test
    public void testIsolationRepeatableRead() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springICBC.xml");
        IsolationService3 i3 = applicationContext.getBean("i3", IsolationService3.class);
        i3.read("act-001");
    }

    @Test
    public void testIsolationRepeatableRead2() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springICBC.xml");
        IsolationService4 i4 = applicationContext.getBean("i4", IsolationService4.class);
        i4.update("act-001", 2500);
    }

    @Test
    public void testIsolation1() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springICBC.xml");
        IsolationService1 i1 = applicationContext.getBean("i1", IsolationService1.class);
        i1.getByActno("act-004");
    }

    @Test
    public void testIsolation2() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springICBC.xml");
        IsolationService2 i2 = applicationContext.getBean("i2", IsolationService2.class);
        i2.save(new BankAccount("act-004", 1000.0));
    }

    @Test
    public void testPropagation() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springICBC.xml");
        ICBCServiceDao s1 = applicationContext.getBean("s1", ICBCServiceDao.class);
        BankAccount ba = new BankAccount("act-003", 500.0);
        s1.save(ba);
    }

    @Test
    public void testTransfer() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springICBC.xml");
        ICBCServiceDao iCBCServiceDao = applicationContext.getBean("iCBCServiceDaoImpl", ICBCServiceDao.class);
        iCBCServiceDao.transfer("act-001", "act-002", 100.0);
    }

    @Test
    public void testBatchAdd() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springICBC.xml");
        ICBCServiceDao iCBCServiceDao = applicationContext.getBean("iCBCServiceDaoImpl", ICBCServiceDao.class);
        Object[] obj1={"act-1122", 20};
        Object[] obj2={"act-2232", 30};
        Object[] obj3={"act-3342", 10};
        ArrayList<Object[]> list = new ArrayList<>();
        list.add(obj1);
        list.add(obj2);
        list.add(obj3);
        int[] count = iCBCServiceDao.batchAdd(list);
//        System.out.println(count);
        System.out.println(Arrays.toString(count));
    }

    @Test
    public void testICBC_CRUD() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springICBC.xml");
        ICBCServiceDao iCBCServiceDao = applicationContext.getBean("iCBCServiceDaoImpl", ICBCServiceDao.class);
        //增
        iCBCServiceDao.add("act-010", 5800.00);
        //删
        iCBCServiceDao.delete("act-004");
        //改
        iCBCServiceDao.update("act-001", 300.00);
        //查
        BankAccount bankAccount = iCBCServiceDao.selectActByActno("act-001");
        System.out.println(bankAccount);
    }

    @Test
    public void testMyDataSourceToAddAccount() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        ActService actServiceImpl = applicationContext.getBean("actService", ActService.class);
        int count = actServiceImpl.addAccount("act-006", 3000.00);
        if (count == 1) {
            System.out.println("Account added: " + count);
        } else System.out.println("Account has NOT been created!!!");
    }

    @Test
    public void testMyDataSource() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        System.out.println(jdbcTemplate);
    }
}
