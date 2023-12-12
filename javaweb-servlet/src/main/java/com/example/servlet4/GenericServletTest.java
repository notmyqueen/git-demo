package com.example.servlet4;

import jakarta.servlet.*;

import java.io.IOException;

public abstract class GenericServletTest implements Servlet {

    private ServletConfig config;

    @Override
    public final void init(ServletConfig config) throws ServletException {
        this.config = config;
        this.init();
    }

    public void init() {
    }

    @Override
    public ServletConfig getServletConfig() {
        return this.config;
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
