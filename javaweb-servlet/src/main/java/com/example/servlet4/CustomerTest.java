package com.example.servlet4;

import com.example.servlet2.GenericServlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

import java.io.IOException;

public class CustomerTest extends GenericServlet {

    @Override
    public void init() {
        System.out.println("子类重写的init无参方法");
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        ServletConfig config = this.getServletConfig();
        System.out.println(config);
    }
}
