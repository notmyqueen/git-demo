package com.example.spring6.bean;

import org.springframework.stereotype.Component;

@Component("userBean")
public class User {

}
//相当于： <bean id="userBean" class="com.example.spring6.bean.User"/>
//如果把注解的value去掉，就一个@Component，那就相当于<bean id="user" class="com.example.spring6.bean.User"/> (就是类名首字母小写)

