package com.example.proxy.client;

import com.example.proxy.service.OrderService;
import com.example.proxy.service.OrderServiceImpl;
import com.example.proxy.service.OrderServiceProxy;

public class Test {
    public static void main(String[] args) {
        OrderService target = new OrderServiceImpl();

        OrderService proxy = new OrderServiceProxy(target);

        proxy.generate();
        proxy.modify();
        proxy.detail();

    }
}
