package com.example.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Aspect1 {

    @Pointcut("execution(public * com.example.service..*(..))")
    public void general() {
    }

    @Around("general()")
    public void clean(ProceedingJoinPoint joinPoint) {
        try {
            System.out.println("擦拭炮管");
            joinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        System.out.println("开火后清洗炮管");
        System.out.println("---------Fire Completed-----------");
    }

    @Before("general()")
    @Order(2)
    public void aim() {
        System.out.println("瞄准");
    }

    @Before("general()")
    @Order(1)
    public void load() {
        System.out.println("装填炮弹");
    }

}
