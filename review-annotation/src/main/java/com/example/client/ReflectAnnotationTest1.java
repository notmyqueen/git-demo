package com.example.client;

import com.example.annotation.Component;

import java.io.File;
import java.net.URL;

public class ReflectAnnotationTest1 {
    public static void main(String[] args) throws Exception {
        //通过反射机制怎么读取注解
        //获取User类
        Class<?> aClass = Class.forName("com.example.bean.User");
        //判断类上面有没有这个注解
        if (aClass.isAnnotationPresent(Component.class)) {
            //获取类上的注解
            Component annotation = aClass.getAnnotation(Component.class);
            //访问注解属性（这里写value是因为注解里的属性名是value，如果是name之类的，就写name）
            System.out.println(annotation.value());
        }

        String pName="com.example.annotation";
        String pPath = pName.replaceAll("\\.", "/");
        URL url = ClassLoader.getSystemClassLoader().getResource(pPath);
        String path = url.getPath();
        File file = new File(path);
        System.out.println(file);
        File[] files = file.listFiles();
        System.out.println(files);
        boolean exists = file.exists();
        System.out.println(exists);
    }
}
