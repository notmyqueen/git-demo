package com.example.servlet;

import jakarta.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("HelloServlet的初始化方法执行");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        System.out.println("My First Servlet, hello servlet");
        PrintWriter out = response.getWriter();

        out.print("<h2>Hello Servlet! (on web page)</h2>");

        /*
            out.flush();
            out.close();
         */

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("HelloServlet的销毁方法执行！");
    }
}
