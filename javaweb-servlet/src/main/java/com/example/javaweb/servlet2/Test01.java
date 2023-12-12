package com.example.javaweb.servlet2;

import jakarta.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;

public class Test01 extends GenericServlet {
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        ServletConfig config = this.getServletConfig();
        out.println("Test01的servletConfig：" + config);
        out.print("<br>");

        String name = config.getServletName();
        out.println("Test01的servlet名字：" + name);
        out.print("<br>");

        ServletContext context = this.getServletContext();
        out.println("整个context："+context);
    }
}
