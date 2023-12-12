package com.example.javaweb.servlet;

import jakarta.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;

public class ConfigTestServlet extends GenericServlet {
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        ServletConfig config = this.getServletConfig();

        out.println("ServletConfig对象是：" + config);  //ServletConfig对象是：org.apache.catalina.core.StandardWrapperFacade@7c583dfe

        //获取config中的servletName
        String name = config.getServletName();
        out.print("<br><h3>config中的servletName："+name+"</h3>");
    }
}
