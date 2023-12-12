package org.example.dao.impl;

import org.example.dao.OrderDao;
import org.springframework.stereotype.Repository;

//@Repository
public class OrderDaoImplForMySQL implements OrderDao {
    @Override
    public void insert() {
        System.out.println("MySQL DB生成订单");
    }
}
