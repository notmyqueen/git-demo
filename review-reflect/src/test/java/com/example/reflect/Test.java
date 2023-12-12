package com.example.reflect;

import java.lang.reflect.Method;
/*
    要求通过反射机制给User类的实例对象的name属性赋值。
 */
public class Test {
    public static void main(String[] args) throws Exception {
        //获取类，Class.forName();
        Class<?> clazz = Class.forName("com.example.reflect.User");
        //得到了类，根据方法名获取方法（通过getDeclaredMethod()）。第二个参数为要获取的这个方法的参数类型
        Method setStringMethod=clazz.getDeclaredMethod("setName", String.class);
        //通过newInstance()方法获取对象
        Object user = clazz.newInstance();
        //调用方法，给name属性赋值
        setStringMethod.invoke(user, "张三");
        System.out.println(user);
    }
}
