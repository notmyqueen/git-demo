package org.example.spring6.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomerDao {

    public CustomerDao() {
        System.out.println("CustomerDao无参构造方法正在执行！！！");
        delete();
    }

    private static final Logger logger = LoggerFactory.getLogger(CustomerDao.class);

    public static void delete() {
        logger.info("数据库正在删除客户信息。。。");
    }
}
