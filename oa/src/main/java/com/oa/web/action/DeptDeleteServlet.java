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

public class DeptDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String deptno = request.getParameter("deptno");

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        //连接数据库，根据部门编号查询部门信息
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DBUtil.getConnection();
            String sql = "DELETE FROM servlet_dept WHERE deptno = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, deptno);
            int count = ps.executeUpdate();
            if (count != 1) {
                System.out.println("删除失败！");
            } else {
                System.out.println("删除第" + deptno + "部门成功");
                //转发！（应该用重定向，但是还没学）
                request.getRequestDispatcher("/dept/list").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn, ps, rs);
        }

    }
}
