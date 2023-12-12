package com.example.javaweb.servlet;

import jakarta.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;

public class ConfigTestServlet2 extends GenericServlet {
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        ServletConfig config = this.getServletConfig();

        out.println("ServletConfig对象是："+config);  //ServletConfig对象是：org.apache.catalina.core.StandardWrapperFacade@33c4f08f
    }
}
