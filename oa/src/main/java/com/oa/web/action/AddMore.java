package com.oa.web.action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class AddMore extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.print("            <!DOCTYPE html>");
        out.print("         <html>");
        out.print("         <head>");
        out.print("             <meta charset='utf-8'>");
        out.print("             <title>新增部门</title>");
        out.print("         </head>");
        out.print("         <body>");
        out.print("             <h1>新增部门</h1>");
        out.print("             <hr>");
        out.print("             <form action='/oa/dept/add' method='post'>");
        out.print("                     部门编号<input type='number' name='deptno'/><br>");
        out.print("                     部门名称<input type='text' name='dname'/><br>");
        out.print("                     部门位置<input type='text' name='loc'/><br>");
        out.print("                 <input type='submit' value='保存'><br>");
        out.print("             </form>");
        out.print("         </body>");
        out.print("     </html>");

    }
}
