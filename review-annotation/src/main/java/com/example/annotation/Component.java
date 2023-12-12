package com.example.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
    自定义注解
 */

@Target(ElementType.TYPE)  //标注注解的注解，叫做元注解
@Retention(RetentionPolicy.RUNTIME)
public @interface Component {
    String value();
}
