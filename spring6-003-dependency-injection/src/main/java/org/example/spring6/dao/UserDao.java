package org.example.spring6.dao;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class UserDao {

    private static final Logger logger = LoggerFactory.getLogger(UserDao.class);

    public void insert() {
//        System.out.println();   直接打印到控制台，太low了。要利用log4j的日志功能
        logger.info("数据库正在保存用户信息。");
    }
}
