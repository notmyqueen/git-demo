package net.bank.mvc;

import net.bank.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
    负责Account数据的增删改查
    DAO: Data Access Object（数据访问对象）
    DAO层和任何业务没有关系，单纯对表进行增删改查
 */
public class AccountDao {

    //insert返回插入的行数，所以返回类型是int
    public int insert(Account act) {
        //DB part
        Connection conn = null;
        PreparedStatement ps = null;

        int count = 0;

        try {
            conn = DBUtil.getConnection();
            String sql = "insert into t_act(actno, balance) VALUES(?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, act.getActno());
            ps.setDouble(2, act.getBalance());
            count = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.close(conn, ps, null);
        }
        return count;
    }

    //根据账号删，也可以根据id删，这里选id
    public int deleteById(Long id) {
        Connection conn = null;
        PreparedStatement ps = null;
        int count = 0;

        try {
            conn = DBUtil.getConnection();
            String sql = "DELETE from t_act where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setLong(1, id);
            count = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.close(conn, ps, null);
        }
        return count;
    }

    public int update(Account act, Connection conn) {

        System.out.println(conn);

//        Connection conn = null;
        PreparedStatement ps = null;
        int count = 0;

        try {
//            conn = DBUtil.getConnection();
            String sql = "UPDATE t_act SET balance = ?, actno = ? WHERE id = ?";
            ps = conn.prepareStatement(sql);
            ps.setDouble(1, act.getBalance());
            ps.setString(2, act.getActno());
            ps.setLong(3, act.getId());
            count = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.close(null, ps, null);
            System.out.println("update里关闭后的conn："+conn);
        }
        return count;
    }

    public Account selectByActno(String actno) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        Account act = null;

        try {
            conn = DBUtil.getConnection();

//            System.out.println("conn in selectByActno(): " + conn);

            String sql = "SELECT id, balance from t_act WHERE actno = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, actno);
            rs = ps.executeQuery();
            if (rs.next()) {
                Long id = rs.getLong("id");
                Double balance = rs.getDouble("balance");
                //将结果集封装对象
                act = new Account(id, actno, balance);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.close(conn, ps, rs);
        }
        return act;

    }

    public List<Account> selectAll() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<Account> list = new ArrayList<>();

        try {
            conn = DBUtil.getConnection();
            String sql = "SELECT id, actno, balance from t_act";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                //取出数据
                Long id = rs.getLong("id");
                String actno = rs.getString("actno");
                Double balance = rs.getDouble("balance");
                //将结果集封装对象
                Account act = new Account(id, actno, balance);
                //添加进List集合
                list.add(act);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.close(conn, ps, rs);
        }
        return list;
    }
}
