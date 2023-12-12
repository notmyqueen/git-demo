package com.example.proxy.client;

import com.example.proxy.service.OrderService;
import com.example.proxy.service.OrderServiceImpl;
import com.example.proxy.service.TimerInvocationHandler;

import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        //创建目标对象
        OrderService target = new OrderServiceImpl();
        //创建代理对象
        OrderService o = (OrderService) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new TimerInvocationHandler(target)); //三个参数（类加载器，代理类要实现的接口，调用处理器）

        o.generate();
    }
}
