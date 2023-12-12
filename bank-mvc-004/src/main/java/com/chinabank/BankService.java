package com.chinabank;

import com.chinabank.Pojo.Bank;
import com.chinabank.utils.DBUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class BankService {
    BankDao dao = new BankDao();
    public Long checkBalance(String actno) {
        Bank bank = dao.selectByActno(actno);
        return bank.getBalance();
    }



    public int transfer(String fromActno, String toActno, Long money) throws SQLException {

        //*为了实现事务，收到在Service层创建一个conn
        Connection conn = DBUtil.getConnection();

        //关闭自动提交
        try {
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        int count = 0;

        //1、获取扣款账号pojo，转入账号pojo
//        Bank fromBank = dao.selectByActno(fromActno);
//        Bank toBank = dao.selectByActno(toActno);

        //update方法只要账号和数目这两个参数，然后就可以直接调用。
        count += dao.update(fromActno, -money, conn);

        //模拟空指针异常
        String s = null;
        s.toString();

        count += dao.update(toActno, money, conn);

        //程序走到这里说明没问题，可以提交事务
        conn.commit();

        return count;
    }
}
