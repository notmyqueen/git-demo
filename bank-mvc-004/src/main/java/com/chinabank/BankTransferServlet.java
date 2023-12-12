package com.chinabank;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet({"/transfer", "/delete", "/createaccount"})
public class BankTransferServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if("/transfer".equals(request.getServletPath())) {
            try {
                doTransfer(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    protected void doTransfer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        //从网页端获取参数
        String fromAccount = request.getParameter("fromActno");
        String toActno = request.getParameter("toActno");
        Long money = Long.parseLong(request.getParameter("money"));

        //新建一个service类
        BankService service = new BankService();

        //调用service类的具体方法，比如转账transfer
        int count = service.transfer(fromAccount, toActno, money);

        //根据return值判断转账是否成功
        if(count == 2) {
            System.out.println("转账成功");
        } else
            System.out.println("转账异常，请联系银行！");
    }
}
