package test;

import com.example.mybatis.pojo.Car;
import com.example.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.util.HashMap;

public class MyBatisTest {

    @Test
    public void testSelectById() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        Object car = sqlSession.selectOne("selectById", 1);
        System.out.println(car);
        sqlSession.close();
    }

    @Test
    public void testUpdateById() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        Car car = new Car(37L, "1004", "Audi A4", 25.0, "2022-03-12", "汽油车");
        int count = sqlSession.update("updateById", car);
        System.out.println("修改的行数：" + count);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testDeleteById() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        int count = sqlSession.delete("deleteById", "36");
        System.out.println("删除的行数：" + count);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testInsertCarByPojo() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        Car car = new Car(null, "222", "Lexus ES200", 20.0, "2020-12-11", "燃油车");
        int count = sqlSession.insert("insertCar3", car);
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testInsertCar() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();

        HashMap<String, Object> map = new HashMap<>();
        map.put("k1", "1111");
        map.put("k2", "宝马ix3");
        map.put("k3", 10.0);
        map.put("k4", "2020-11-11");
        map.put("k5", "电车");

        int count = sqlSession.insert("insertCar2", map);
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testUtils() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        int count = sqlSession.insert("insertCar");
        System.out.println("插入的行数：" + count);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testMyBatisComplete() {
        SqlSession sqlSession = null;
        try {
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("mybatis-config.xml"));
            sqlSession = factory.openSession();
            int count = sqlSession.insert("insertCar");
            System.out.println("插入行数：" + count);
            sqlSession.commit();
        } catch (Exception e) {
            if (sqlSession != null) {
                sqlSession.rollback();
            }
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}
