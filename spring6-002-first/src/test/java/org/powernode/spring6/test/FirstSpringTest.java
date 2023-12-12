package org.powernode.spring6.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FirstSpringTest {
    @Test
    public void testFirstSpringCode() {
        //第一步：获取Spring容器对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml", "xml/beans.xml");  //这行代码只要执行，相当于启动了Spring容器，解析spring.xml，并实例化所有bean对象，放到spring容器当中
        //第二步：根据bean的id从Spring容器中获取这个对象
        Object userBean = applicationContext.getBean("userBean");
        System.out.println(userBean);

        Object user2 = applicationContext.getBean("user2");
        System.out.println(user2);
    }

    @Test
    public void testBeginInitBean() {
        //注意：不是在调用getBean()方法的时候创建对象，执行以下代码的时候，就会实例化对象。
        new ClassPathXmlApplicationContext("spring.xml");
    }
}
