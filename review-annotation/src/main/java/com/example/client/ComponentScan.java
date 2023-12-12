package com.example.client;

import com.example.annotation.Component;

import java.io.File;
import java.net.URI;
import java.util.*;

public class ComponentScan {
    public static void main(String[] args) {
        Map<String, Object> beanMap = new HashMap<>();
        //目前只知道一个包的名字，扫描这个包下所有的类，当这个类上有@Component注解的时候，实例化该对象，然后放到Map集合中
        String packageName = "com.example.bean";  //这是包名。和路径是不同的。
        //开始写扫描程序
        // . 这个正则表达式代表任意字符。这里的“.”必须是是一个普通的“.”字符。不能是正则表达式中的“.”
        // 在正则表达式当中怎么表示一个普通的“.”字符呢？使用\.

        String packagePath = packageName.replaceAll("\\.", "/");
        System.out.println("包在类路径下的path：" + packagePath);
        URI uri = null;
        try {
            uri = ClassLoader.getSystemClassLoader().getResource(packagePath).toURI();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String path = uri.getPath();
        System.out.println("这个包的据对路径：" + path);
        File file = new File(path);
        File[] files = file.listFiles();
        for (File f : files) {
            try {
                String fileNameWithoutClass = f.getName().split("\\.")[0];
                String className = packageName + "." + fileNameWithoutClass;
                System.out.println(className);
                Class<?> aClass = Class.forName(className);
                if (aClass.isAnnotationPresent(Component.class)) {
                    Component annotation = aClass.getAnnotation(Component.class);
                    String id = annotation.value();
                    //有这个注解的都要创建对象
                    Object obj = aClass.newInstance();
                    beanMap.put(id, obj);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println(beanMap);
    }
}
