package com.example.spring6.bean2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Product {

    private String name;
    private int age;

    //方法三：放在构造方法的参数前
    public Product(@Value("佟湘玉") String name, @Value("15") int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
