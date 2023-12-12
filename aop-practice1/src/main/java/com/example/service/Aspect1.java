package com.example.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//切面一
@Component
@Aspect
@Order(1)
public class Aspect1 {

    //定义通用的切点表达式
    @Pointcut("execution(public * com.example.service..* (..))")
    public void 通用切点() {
        //这个方法只是一个标记，方法名随意，方法体中也不需要任何代码。

    }

    //@Before("execution(public * com.example.service..* (..))")
    @Before("通用切点()")
    public void loadAmmunition(JoinPoint joinPoint) {
        System.out.println("装填爱国者导弹");

        //连接点的常用用法：获取目标方法的签名。什么叫签名，打印出来就是目标方法的修饰符+完整包名：void com.example.service.FireService.fire()
        Signature signature = joinPoint.getSignature();
        System.out.println(signature);
        //签名有很多方法，比如getName()
        System.out.println(signature.getName());
    }

    //@AfterReturning("execution(public * com.example.service..* (..))")
    @AfterReturning("通用切点()")
    public void unloadAmmunition() {
        System.out.println("卸下炮弹壳");
    }

    //@After("execution(public * com.example.service..* (..))")
    @After("通用切点()")
    public void rest() {
        System.out.println("炮兵休息");
    }
}
