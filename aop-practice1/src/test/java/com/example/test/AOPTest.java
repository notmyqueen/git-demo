package com.example.test;

import com.example.service.FireService;
import com.example.service.Spring6Config;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPTest {

    @Test
    public void testNoXml() {
        //全注解开发用这个类：AnnotationConfigApplicationContext。参数别忘了config文件的.class
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Spring6Config.class);
        FireService fireService = applicationContext.getBean("fireService", FireService.class);
        fireService.fire();
    }


    @Test
    public void testAOPAnno() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        FireService fireService = applicationContext.getBean("fireService", FireService.class);
        fireService.fire();
    }
}
