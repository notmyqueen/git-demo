package com.example.javaweb;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class BServlet extends AServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        Object sysTime = request.getAttribute("时间");
        out.print("BServlet, 系统当前时间："+sysTime+"<br>");
        Object username = request.getAttribute("username");
        out.print("提交的用户名："+username);
    }
}
