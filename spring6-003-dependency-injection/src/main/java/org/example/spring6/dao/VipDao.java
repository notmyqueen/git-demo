package org.example.spring6.dao;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class VipDao {

    private static final Logger logger =  LoggerFactory.getLogger(VipDao.class);

    public void insert() {
        logger.info("数据库正在保存vip用户信息。");
    }
}
