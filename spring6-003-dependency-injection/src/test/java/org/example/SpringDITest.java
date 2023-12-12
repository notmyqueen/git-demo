package org.example;

import org.example.spring6.bean__JianDanLeiXing.*;
import org.example.spring6.jdbc.MyDataSource;
import org.example.spring6.jdbc.MyDataSource1;
import org.example.spring6.jdbc.MyDataSource2;
import org.example.spring6.service.CustomerService;
import org.example.spring6.service.OrderService;
import org.example.spring6.service.UserService;
import org.example.spring6.service.VipService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDITest {

    @Test
    public void testProperties() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-properties.xml");
        MyDataSource ds = applicationContext.getBean("ds", MyDataSource.class);
        System.out.println(ds);
    }

    @Test
    public void testUtilDI() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-util.xml");
        MyDataSource1 ds1 = applicationContext.getBean("ds1", MyDataSource1.class);
        MyDataSource2 ds2 = applicationContext.getBean("ds2", MyDataSource2.class);
        System.out.println(ds1);
        System.out.println(ds2);
    }

    @Test
    public void testByTypeDI() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-autowire.xml");
        VipService vipServiceBean = applicationContext.getBean("vipServiceBean", VipService.class);
        vipServiceBean.save();
    }

    @Test
    public void testByNameDI() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-autowire.xml");
        OrderService os = applicationContext.getBean("orderServiceBean", OrderService.class);
        os.generate();
    }

    @Test
    public void testC() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-c.xml");
        People peopleBeanP = applicationContext.getBean("peopleBean", People.class);
        System.out.println(peopleBeanP);
    }

    @Test
    public void testP() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-p.xml");
        Dog dogBean = applicationContext.getBean("dogBeanP", Dog.class);
        System.out.println(dogBean);
    }

    @Test
    public void testPreP() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-p.xml");
        Dog dogBean = applicationContext.getBean("dogBean", Dog.class);
        System.out.println(dogBean);
    }

    @Test
    public void testSpecial() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-collection.xml");
        User userBean = applicationContext.getBean("userBean", User.class);
        System.out.println(userBean);
    }

    @Test
    public void testNullDI() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-collection.xml");
        Student studentBean = applicationContext.getBean("studentBean", Student.class);
        System.out.println(studentBean);
    }

    @Test
    public void testArrayConstructorDI() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-collection.xml");
        Zhangsan zsBean = applicationContext.getBean("zsBean", Zhangsan.class);
        System.out.println(zsBean);
    }

    @Test
    public void testListSetDI() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-collection.xml");
        Person person = applicationContext.getBean("personBean", Person.class);
        System.out.println(person);
    }

    @Test
    public void testArraySetDI() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        Zhangsan zsBean = applicationContext.getBean("zhangsanBean", Zhangsan.class);
        System.out.println(zsBean);
    }

    @Test
    public void testCascadeDI() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        Student student = applicationContext.getBean("stuBean", Student.class);
        System.out.println(student);
    }

    @Test
    public void testSimpleTypeSet() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        User userBean = applicationContext.getBean("userBean", User.class);
        System.out.println(userBean);
    }

    @Test
    public void testConstructorDI() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        CustomerService csBean = applicationContext.getBean("customerServiceBean", CustomerService.class);
        csBean.insertCustomer();

        CustomerService csBean2 = applicationContext.getBean("customerServiceBean2", CustomerService.class);
        csBean2.insertCustomer();

        CustomerService csBean3 = applicationContext.getBean("customerServiceBean3", CustomerService.class);
        csBean2.insertCustomer();
    }

    @Test
    public void testSetDI2() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        VipService vs = applicationContext.getBean("vipServiceBean", VipService.class);
        vs.save();
    }

    @Test
    public void testSetDI() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        UserService userService = applicationContext.getBean("userServiceBean", UserService.class);
        userService.saveUser();
    }
}
