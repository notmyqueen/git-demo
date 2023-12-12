package com.oa.web.action;

import com.oa.utils.DBUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class DeptListServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取应用的根路径
        String contextPath = request.getContextPath();  //根路径就是"/oa"
        System.out.println("应用的根路径: " + contextPath);

        //获取请求参数
        Map<String, String[]> map = request.getParameterMap();


        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.print("<!DOCTYPE html>");
        out.print("<html>");
        out.print("    <head>");
        out.print("        <meta charset='utf-8'>");
        out.print("        <title>部门列表页面</title>");
        out.print("    </head>");

        out.print("    <body>");
        out.print("        <h1 align='center'>部门列表</h1>");
        out.print("        <hr>");
        out.print("        <table border='1px' align='center'>");
        out.print("            <tr>");
        out.print("                <th>序号</th>");
        out.print("                <th>部门编号</th>");
        out.print("                <th>部门名称</th>");
        out.print("                <th>操作</th>");
        out.print("            </tr>");
//上面这部分是死的

        //连接数据库，查询所有部门
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DBUtil.getConnection();
            String sql = "select deptno as a, dname, loc from servlet_dept";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            int i = 0;

            while (rs.next()) {
                String deptno = rs.getString("a");
                String dname = rs.getString("dname");
                String loc = rs.getString("loc");

                out.print("            <tr>");
                out.print("                <td>" + (++i) + "</td>");
                out.print("                <td>" + deptno + "</td>");
                out.print("                <td>" + dname + "</td>");
                out.print("                <td>");
                out.print("                    <a href='" + contextPath + "/dept/delete?deptno=" + deptno + "'>删除</a>");
                out.print("                    <a href='" + contextPath + "/edit.html?deptno='" + deptno + ">修改</a>");
                out.print("                    <a href='" + contextPath + "/dept/detail?deptno=" + deptno + "'>详情</a>");
                out.print("                </td>");
                out.print("            </tr>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn, ps, rs);
        }


        out.print("        </table>");
        out.print("        <hr>");
        out.print("        <a href='" + contextPath + "/dept/addmore" + "'>新增部门</a>");
        out.print("    </body>");

        out.print("</html>");


    }
}
