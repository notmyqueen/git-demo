package com.example.proxy.service;

public class OrderServiceProxy implements OrderService { //代理对象

    //将目标对象作为代理对象的一个属性。这种关系叫做关联关系。比继承关系耦合度低

    private OrderService target;

    //别忘了构造方法
    public OrderServiceProxy(OrderService target) {
        this.target = target;
    }

    @Override
    public void generate() {
        //增强
        long start = System.currentTimeMillis();

        target.generate();
        long end = System.currentTimeMillis();
        System.out.println("共耗时"+(end - start)+"毫秒");
    }

    @Override
    public void modify() {
        long start = System.currentTimeMillis();
        target.modify();
        long end = System.currentTimeMillis();
        System.out.println("共耗时"+(end - start)+"毫秒");

    }

    @Override
    public void detail() {
        long start = System.currentTimeMillis();
        target.detail();
        long end = System.currentTimeMillis();
        System.out.println("共耗时"+(end - start)+"毫秒");

    }
}
