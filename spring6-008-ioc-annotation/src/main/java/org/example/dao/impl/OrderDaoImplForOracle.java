package org.example.dao.impl;

import org.example.dao.OrderDao;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDaoImplForOracle implements OrderDao {
    @Override
    public void insert() {
        System.out.println("Oracle数据库正在生成订单");
    }
}
