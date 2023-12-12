package org.example;

import org.example.spring6.test.service.OrderService;
import org.example.spring6.test.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDITest2 {

    @Test
    public void testAutoWireByType() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-autowire2.xml");
        UserService usBean = applicationContext.getBean("userServiceBean", UserService.class);
        usBean.generate();
    }

    @Test
    public void testAutoWireByName() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-autowire2.xml");
        OrderService osBean = applicationContext.getBean("orderServiceBean", OrderService.class);
        osBean.generate();
    }
}
