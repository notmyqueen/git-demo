package com.example.service;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//切面二
@Component
@Aspect
@Order(2)
public class Aspect2 {
    //跨类也能用。加上包名。
    @Before("com.example.service.Aspect1.通用切点()")
    public void aim() {
        System.out.println("开炮前的瞄准");
    }

}
