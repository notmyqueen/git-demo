package com.example.javaweb;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class AServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Date nowTime = new Date();

        request.setAttribute("时间", nowTime);

        String username = request.getParameter("username");

        request.setAttribute("username", username);

        out.print("hi<br>");

        out.print("提交上来的用户名：" + username + "<br>");
        out.print("System Time now is: " + nowTime);

//        RequestDispatcher dispatcher = request.getRequestDispatcher("/b");
//        dispatcher.forward(request, response);

        String remoteAddr = request.getRemoteAddr();
        out.print("<br>"+"当前客户端IP地址："+remoteAddr);

        out.print("<br>"+"当前客户端主机名："+request.getRemoteHost());

    }
}
