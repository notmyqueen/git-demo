package com.chinabank;

import com.chinabank.Pojo.Bank;
import com.chinabank.utils.DBUtil;

import java.nio.channels.AcceptPendingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BankDao {
    /**
     * 根据账号获取bank pojo类
     *
     * @param actno
     * @return Bank
     */
    public Bank selectByActno(String actno) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "select id, balance from t_act where actno = ?";

        Bank bank = null;

        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, actno);
            rs = ps.executeQuery();
            if (rs.next()) {

                int id = rs.getInt("id");
                long balance = rs.getLong("balance");
                bank = new Bank(id, actno, balance);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn, ps, rs);
        }

        return bank;
    }

    /**
     * 获取所有账号信息
     *
     * @return List<Bank>
     */
    public List<Bank> selectAll() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT * from t_act";

        List<Bank> list = new ArrayList<>();

        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String actno = rs.getString("actno");
                long balance = rs.getLong("balance");

                Bank bank = new Bank(id, actno, balance);
                list.add(bank);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn, ps, rs);
        }
        return list;
    }

    /**
     * 根据账号和余额，插入数据
     *
     * @param actno
     * @param balance
     * @return int
     */
    public int insert(String actno, Long balance) {
        Connection conn = null;
        PreparedStatement ps = null;

        int count = 0;

        String sql = "INSERT INTO t_act VALUES(?, ?)";

        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, actno);
            ps.setLong(2, balance);
            count += ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn, ps, null);
        }

        return count;
    }

    /**
     * 根据账号删一条数据
     *
     * @param actno
     * @return int
     */
    public int deleteByActno(String actno) {
        Connection conn = null;
        PreparedStatement ps = null;

        int count = 0;

        String sql = "DELETE from t_act where actno = ?";

        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, actno);
            count += ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn, ps, null);
        }

        return count;
    }


//    /**
//     * 传入bank pojo来更新数据库
//     * @param bank
//     * @return int
//     */
//    public int update(Bank bank) {
//        Connection conn = null;
//        PreparedStatement ps = null;
//
//        int count = 0;
//
//        String sql = "UPDATE t_act SET balance = ? WHERE actno = ?";
//
//        try {
//            conn = DBUtil.getConnection();
//            ps = conn.prepareStatement(sql);
//            ps.setLong(1, bank.getBalance());
//            ps.setString(2, bank.getActno());
//            count += ps.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            DBUtil.close(conn, ps, null);
//        }
//
//        return count;
//    }

    public int update(String actno, Long money, Connection conn) {
//        Connection conn = null;



        System.out.println("update方法里的conn：" + conn);

        PreparedStatement ps = null;

        int count = 0;

        String sql = "UPDATE t_act SET balance = ? WHERE actno = ?";

        try {
//            conn = DBUtil.getConnection();

            ps = conn.prepareStatement(sql);
            //转账后的账户余额
            long newBalance = this.selectByActno(actno).getBalance() + money;

            ps.setLong(1, newBalance);
            ps.setString(2, actno);

            count += ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn, ps, null);
        }

        return count;
    }

}