package com.example.test;

import com.example.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SimpleBeanTest {
    @Test
    public void testBeanDI() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        User userBean = applicationContext.getBean("userBean", User.class);
//        userBean.setName("John");
//        userBean.setAge(100);
        System.out.println(userBean);
    }
}
