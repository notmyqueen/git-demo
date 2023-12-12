package net.bank.mvc;

import net.bank.execeptions.AppException;
import net.bank.execeptions.MoneyNotEnoughException;
import net.bank.utils.DBUtil;

import java.sql.Connection;
import java.sql.SQLException;

/*
    专门处理Account业务的类
    应该编写纯业务代码
 */
public class AccountService {

    private AccountDao accountDao = new AccountDao();

    //方法起名一定要体现需要做的业务

    public void transfer(String fromActno, String toActno, double money) throws MoneyNotEnoughException, AppException {
        Thread thread = Thread.currentThread();

        //查询余额是否充足
        Account fromAct = accountDao.selectByActno(fromActno);

        //开启事务
        Connection conn = null;

        try {
            conn = DBUtil.getConnection();

            System.out.println(conn);

            if (fromAct.getBalance() < money) {
                throw new MoneyNotEnoughException("对不起，余额不足！");
            }
            //程序到这里，说明余额充足
            Account toAct = accountDao.selectByActno(toActno);

            //修改余额(只是修改了内存中Java对象中的余额, 还没更新数据库)
            fromAct.setBalance(fromAct.getBalance() - money);
            toAct.setBalance(toAct.getBalance() + money);

            //*从这里开始开启事务
            conn.setAutoCommit(false);

            //更新数据库中的余额
            int count = accountDao.update(fromAct, conn);

            //模拟空指针异常
//            String s2=null;
//            s2.toString();

            count += accountDao.update(toAct, conn);
            if (count != 2) {
                throw new AppException("账户转账异常！");
            }

            //*提交事务
            conn.commit();

        } catch (SQLException e) {
            throw new AppException("账户转账异常！");
        } finally {
            DBUtil.close(conn, null, null);
        }

    }
}
