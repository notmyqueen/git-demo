package org.example.service;

import org.example.dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    /*
        @Autowired甚至可以省略。要求：
            1、构造方法只有一个
            2、构造方法的形参和成员变量名能对上（都是orderDao）
        （为了可读性，不推荐这么做）
     */
    private OrderDao orderDao;

    public OrderService(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public void generate() {
        orderDao.insert();
    }
}
