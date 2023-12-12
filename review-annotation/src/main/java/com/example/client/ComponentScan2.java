package com.example.client;

import com.example.annotation.Component;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

public class ComponentScan2 {
    public static void main(String[] args) {

        Map<String, Object> beanMap= new HashMap<>();

        String packageName = "com.example.bean";
        String packagePath = packageName.replaceAll("\\.", "/");
        URI uri = null;
        try {
            uri = ClassLoader.getSystemClassLoader().getResource(packagePath).toURI();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        String path = uri.getPath();
        File file = new File(path);
        File[] files = file.listFiles();
        for(File f:files) {
            String beanNameSuffix = f.getName().split("\\.")[0];
            String beanName = packageName+"."+beanNameSuffix;
            Class<?> aClass=null;
            try {
                aClass = Class.forName(beanName);
                if (aClass.isAnnotationPresent(Component.class)) {
                    String id = aClass.getAnnotation(Component.class).value();
                    Object bean = aClass.newInstance();
                    beanMap.put(id, bean);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println(beanMap);
    }
}
