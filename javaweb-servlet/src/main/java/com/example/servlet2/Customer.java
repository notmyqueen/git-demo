package com.example.servlet2;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class Customer extends GenericServlet {
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        System.out.println("Customer servlet service execute!");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.print("<h2>Hello customer! (on web page)</h2>");

        System.out.println(this.getServletConfig());
    }


    @Override
    public void init() {
        System.out.println("无参init执行！without this");
    }
}
