package com.example.service;

import org.aspectj.lang.ProceedingJoinPoint;

public class TimerAspect {
    //通知
    public void aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        long begin = System.currentTimeMillis();

        joinPoint.proceed();

        long end = System.currentTimeMillis();
        System.out.println("Time used " + (end - begin) + "ms");
    }
}
