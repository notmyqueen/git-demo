package com.example.javaweb.servlet2;

import jakarta.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class Test02 extends GenericServlet {
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        //输出application
        ServletContext application = this.getServletContext();
        out.print(application+"<br>");

        //输出context的标签+value
        Enumeration<String> initParameterNames = application.getInitParameterNames();
        while(initParameterNames.hasMoreElements()) {
            String initParameterName = initParameterNames.nextElement();
            out.print(initParameterName+": "+application.getInitParameter(initParameterName)+"<br>");
        }

        //记录日志
        application.log("这是日志！");
    }
}
