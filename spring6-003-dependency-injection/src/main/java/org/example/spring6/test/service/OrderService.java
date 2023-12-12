package org.example.spring6.test.service;

import org.example.spring6.test.dao.OrderDao;

public class OrderService {

    private OrderDao orderdao;

    public void setOrderdao(OrderDao orderdao) {
        this.orderdao = orderdao;
    }

    public void generate() {
        orderdao.insert();
    }
}
