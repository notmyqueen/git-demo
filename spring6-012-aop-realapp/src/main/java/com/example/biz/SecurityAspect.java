package com.example.biz;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Aspect
public class SecurityAspect {

    //注意这个通用切点，作用于所有save方法
    @Pointcut("execution(* com.example.biz..save*(..))")
    public void savePointcut() {

    }

    @Pointcut("execution(* com.example.biz..modify*(..))")
    public void modifyPointcut() {

    }

    @Pointcut("execution(* com.example.biz..delete*(..))")
    public void deletePointcut() {

    }

    @Before("savePointcut() || deletePointcut() || modifyPointcut()")
    public void beforeAdvice(JoinPoint joinPoint) {
        //系统时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        String nowTime = sdf.format(new Date());

        System.out.println(nowTime+" 张三哥哥："+joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
    }

}
