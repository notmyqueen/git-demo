package com.review.contructorTest;

public class Computer {
    private String model;

    public Computer(String model) {
        this.model = model;
        System.out.println(model+"型号的计算机生产完毕");
    }
}
