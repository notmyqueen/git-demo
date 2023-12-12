package net.bank.mvc;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.bank.execeptions.AppException;
import net.bank.execeptions.MoneyNotEnoughException;

import java.io.IOException;
import java.io.PrintWriter;

/*
    AccountServlet扮演MVC里的C角色，司令官。
    负责调度其它组件来完成任务
 */
@WebServlet("/transfer")
public class AccountServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        //接收数据
        String fromActno = request.getParameter("fromActno");
        String toActno = request.getParameter("toActno");
        double money = Double.parseDouble(request.getParameter("money"));
        //调用业务方法处理业务（调用model处理业务）
        AccountService service = new AccountService();
        try {
            service.transfer(fromActno, toActno, money);
            out.write("转账成功！");
        } catch (MoneyNotEnoughException | AppException e) {
            out.write(e.getMessage());
        }
        //展示处理结果（调度View做页面展示）
    }
}
