package com.bank.web.action;

import com.bank.utils.DBUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/transfer")
public class TransferServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取网站传进来的参数
        String fromActno = request.getParameter("fromActno");
        String toActno = request.getParameter("toActno");
        //网页提交上来的金额是String格式，由于需要和balance（double类型）作对比，故将money转换成double类型
        double money = Double.parseDouble(request.getParameter("money"));

        //连接数据库进行转账
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;


        try {
            conn = DBUtil.getConnection();

            //设置自动提交为false
            conn.setAutoCommit(false);

            String checkBalanceSql = "SELECT balance from t_act WHERE actno = ?";
            ps = conn.prepareStatement(checkBalanceSql);
            ps.setString(1, fromActno);
            rs = ps.executeQuery();

            //若查询语句成功，就比对余额
            if (rs.next()) {
                //获取fromAccount的余额
                double balance = rs.getDouble("balance");
                System.out.println("甲方余额：" + balance);
                System.out.println("转账金额：" + money);
                //余额不足，跳转至报错页面。暂时先不做Exception处理。
                if (balance < money) {
                    response.sendRedirect(request.getContextPath() + "/notenoughbalance.jsp");
                }

                //余额足够，开始转账
                //1. 从转账方扣钱
                double balanceLeft = balance - money;
                String updateSql = "UPDATE t_act SET balance = ? WHERE actno = ?";
                PreparedStatement ps2 = conn.prepareStatement(updateSql);
                ps2.setDouble(1, balanceLeft);
                ps2.setString(2, fromActno);
                int count = ps2.executeUpdate();
                //2. 给入帐户加钱
                //获取toAccount的余额
                PreparedStatement ps3 = conn.prepareStatement(checkBalanceSql);
                ps3.setString(1, toActno);
                ResultSet rs2 = ps3.executeQuery();
                if (rs2.next()) {
                    double balance2 = rs2.getDouble("balance");
                    //toAccount余额加上转账的钱
                    double balanceAdded = balance2 + money;
                    PreparedStatement ps4 = conn.prepareStatement(updateSql);
                    ps4.setDouble(1, balanceAdded);
                    ps4.setString(2, toActno);
                    count += ps4.executeUpdate();

                    String s = null;
                    s.toString();

                    conn.commit();

                    //一扣一加，总数是2的话，就是转账成功
                    if (count == 2) {
                        if (ps2 != null) {
                            ps2.close();
                        }

                        if (ps3 != null) {
                            ps3.close();
                        }

                        if (ps4 != null) {
                            ps4.close();
                        }
                        response.sendRedirect(request.getContextPath() + "/transfersucceed.jsp");
                    } else {
                        response.sendRedirect(request.getContextPath() + "/failedToTransfer.jsp");
                    }
                }
            }
        } catch (SQLException | NullPointerException e) {
            e.printStackTrace();
            if (conn != null) {
                try {
                    System.out.println("It's rolling back...");
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }

        } finally {
            DBUtil.close(conn, ps, rs);
        }

    }

}
