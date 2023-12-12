package test;

import com.example.mybatis2.pojo.Player;
import com.example.mybatis2.utils.OpenSession;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyBatisTest2 {

    @Test
    public void testSelectAll() {
        SqlSession session = OpenSession.getOpenSession();
        List<Object> players = session.selectList("selectAll");
        players.forEach(player -> System.out.println(player));
        session.close();
    }

    @Test
    public void testSelectById() {
        SqlSession session = OpenSession.getOpenSession();
        Object obj = session.selectOne("selectById2", 1);
        System.out.println(obj);
        session.commit();
        session.close();
    }

    @Test
    public void testDelete() {
        SqlSession session = OpenSession.getOpenSession();
        session.delete("development.deleteById", 3);
        session.commit();
        session.close();
    }

    @Test
    public void testInsert() {
        SqlSession openSession = OpenSession.getOpenSession();
        Player player = new Player(null, "James", "Lakers");
        int count = openSession.insert("insert", player);
        System.out.println("inserted row: " + count);
        openSession.commit();
        openSession.close();
    }

    @Test
    public void testUpdate() {
        SqlSession session = OpenSession.getOpenSession();
        Player player = new Player(2, "Shaq", "Heats");
        session.update("update", player);
        session.commit();
        session.close();
    }
}
