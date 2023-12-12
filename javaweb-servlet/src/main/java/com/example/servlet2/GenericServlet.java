package com.example.servlet2;

import jakarta.servlet.*;
import java.io.IOException;

public abstract class GenericServlet implements Servlet {

    public String a="AAA";

    private ServletConfig config;

    @Override
    public final void init(ServletConfig config) throws ServletException {
        this.config = config;
        System.out.println("Tomcat自动调用的有参init方法");
        init();
    }

    public void init() {

    }

    @Override
    public ServletConfig getServletConfig() {
        return config;
    }

    @Override
    public abstract void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException;

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
