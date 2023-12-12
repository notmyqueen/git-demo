package com.example.mybatis.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

public class MyBatisCompleteTest {
    public static void main(String[] args) {

        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = null;
        SqlSession sqlSession = null;
        try {
            factory = builder.build(Resources.getResourceAsStream("mybatis-config.xml"));
            sqlSession = factory.openSession();
            int count = sqlSession.insert("insertCar");
            sqlSession.commit();
        } catch (IOException e) {
            if(sqlSession !=null) {
                sqlSession.rollback();
            }
            e.printStackTrace();
        } finally {
            if (sqlSession!=null) {
                sqlSession.close();
            }
        }

    }
}
