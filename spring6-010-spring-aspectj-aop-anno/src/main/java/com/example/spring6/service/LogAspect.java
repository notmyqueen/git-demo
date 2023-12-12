package com.example.spring6.service;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component("logAspect")
@Aspect  //切面类是需要使用@Aspect注解进行标注的
public class LogAspect {  //切面
    //切面=通知+切点
    @Before("execution(* com.example.spring6.service.UserService.*(..))")  //切点表达式
    public void enhance() {
        System.out.println("我是一个通知，我是一段增强代码。。。");
    }
}
