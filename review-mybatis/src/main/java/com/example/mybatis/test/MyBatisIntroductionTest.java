package com.example.mybatis.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.FileInputStream;
import java.io.InputStream;

public class MyBatisIntroductionTest {
    public static void main(String[] args) throws Exception {
        //获取SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        //获取SqlSessionFactory对象
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);

        //获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //执行SQL语句
        int count = sqlSession.insert("insertCar");

        System.out.println("inserted rows: " + count);

        //手动提交
        sqlSession.commit();
    }
}
