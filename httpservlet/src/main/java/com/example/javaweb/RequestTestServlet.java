package com.example.javaweb;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Set;

public class RequestTestServlet extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html");
//        PrintWriter out = response.getWriter();
//        out.print(request);
//
//    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Map<String, String[]> map = request.getParameterMap();
//        String aihao = request.getParameter("aihao");
//        System.out.println(map);
//        System.out.println(aihao);
//
//        String protocol = request.getProtocol();
//        System.out.println(protocol);

        //username=zhangsan&userpassword=WWE&aihao=s&aihao=d&aihao=tt
        Map<String, String[]> map = request.getParameterMap();
        //遍历Map集合(获取Map集合中所有的key)
        Set<String> keys = map.keySet();
        for (String key : keys) {
            String[] values = map.get(key);
            for (String value : values) {
                System.out.println(value);
            }
        }

        ServletContext application = this.getServletContext();
        String serverInfo = application.getServerInfo();
        System.out.println(serverInfo);

        application.setAttribute("UserName", "ROOT");
        Object userName = application.getAttribute("UserName");
        System.out.println(userName);
    }


}
