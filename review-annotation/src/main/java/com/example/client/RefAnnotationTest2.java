package com.example.client;

import com.example.annotation.Component;

public class RefAnnotationTest2 {

    public static void main(String[] args) {
        try {
            Class<?> aClass = Class.forName("com.example.bean.User");
            if (aClass.isAnnotationPresent(Component.class)) {
                Component annotation = aClass.getAnnotation(Component.class);
                System.out.println(annotation.value());
            }
        } catch (ClassNotFoundException e) {
            System.out.println("没这个类哦");
        }

    }
}
