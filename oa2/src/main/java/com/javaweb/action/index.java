package com.javaweb.action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class index extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rootPath = request.getContextPath();
        System.out.println("应用根路径："+request.getContextPath());

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.print("<a href=/"+rootPath+"/list.jsp"+">欢迎来到OA主页，点击跳转部门列表页面</a>");
    }
}
