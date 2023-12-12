package com.example.servlet4;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

import java.io.IOException;

public class VipTest extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Jakarta.servlet.GenericServlet获取的Tomcat传入的ServletConfig："+this.getServletConfig());
    }

    @Override
    public void init() throws ServletException {
        System.out.println("子类重写的Jakarta.servlet.init无参方法");
    }
}
