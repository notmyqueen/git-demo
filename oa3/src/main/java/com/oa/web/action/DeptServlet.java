package com.oa.web.action;

import com.oa.bean.Dept;
import com.oa.utils.DBUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet({"/dept/list", "/dept/detail", "/dept/update", "/dept/remove", "/dept/save"})
public class DeptServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String servletPath = request.getServletPath();
        System.out.println(servletPath);

        //这里的session不一定非要创建。如果没登陆直接hit列表link，就没有session，自然是拒之门外。
        HttpSession session = request.getSession(false);

        //但是如果有cookie，自然也可以访问具体的链接。将cookie的username给到session的username，就可以访问了。
        Cookie[] cookies = request.getCookies();

        //如果有cookie：
        HttpSession session1 = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                //如果cookies数组里有username：
                if ("username".equals(cookie.getName())) {
                    //有cookie没session的情况，强制创建一个session，将这个session的username设置为cookie里的username。
                    System.out.println("没session，但是有cookie。在cookie里找到你cookie里的username了: " + cookie.getValue());
                    session1 = request.getSession();
                    session1.setAttribute("username", cookie.getValue());
                } else
                    System.out.println("你访问链接的时候，cookie里也没有username这个cookie名。或者遍历的时候这个cookie没有username。（不代表别的cookie没有username哦）");
            }
        }

        if (session != null && session.getAttribute("username") != null) {
//            System.out.println("本来不带session哦");

            System.out.println("这时候是有session的，session username：" + session.getAttribute("username"));
            if ("/dept/list".equals(servletPath)) {
                doList(request, response);
            } else if ("/dept/detail".equals(servletPath)) {
                doDetail(request, response);
            } else if ("/dept/update".equals(servletPath)) {
                doUpdate(request, response);
            } else if ("/dept/remove".equals(servletPath)) {
                doRemove(request, response);
            } else if ("/dept/save".equals(servletPath)) {
                doSave(request, response);
            }

        } else if (session1 != null && session1.getAttribute("username") != null) {

            System.out.println("这种情况是没session，有cookie，然后强制生成了一个session1");
            //这段代码是冗余了，但是就这么着吧，可读性还可以，看得懂
            if ("/dept/list".equals(servletPath)) {
                doList(request, response);
            } else if ("/dept/detail".equals(servletPath)) {
                doDetail(request, response);
            } else if ("/dept/update".equals(servletPath)) {
                doUpdate(request, response);
            } else if ("/dept/remove".equals(servletPath)) {
                doRemove(request, response);
            } else if ("/dept/save".equals(servletPath)) {
                doSave(request, response);
            }

        } else {
            try {
                System.out.println("登陆失败！缺失session。目前session: " + session + " session的username：" + session.getAttribute("username"));
            } catch (Exception e) {
                e.printStackTrace();
            }

            //这种情况就是session没有，cookie也没有，跳转到欢迎页。由于没有cookie，进入欢迎页后也只会继续跳转到登陆页，自然也就不需要那种所谓的牛逼写法了。
            response.sendRedirect(request.getContextPath() + "/welcome");
        }

    }

    private void doSave(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取新增页面上传的部门参数
        String dno = request.getParameter("deptno");
        String dname = request.getParameter("dname");
        String loc = request.getParameter("loc");

        Connection conn = null;
        PreparedStatement ps = null;
        int count = 0;

        try {
            conn = DBUtil.getConnection();
            String sql = "INSERT INTO servlet_dept (deptno, dname, loc) VALUES (?, ?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, dno);
            ps.setString(2, dname);
            ps.setString(3, loc);
            count = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn, ps, null);
        }

        if (count == 1) {
            System.out.println("插入成功");
            response.sendRedirect(request.getContextPath() + "/dept/list");
        } else {
            System.out.println("插入失败");
        }
    }

    private void doRemove(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String dno = request.getParameter("dno");

        //DB part
        Connection conn = null;
        PreparedStatement ps = null;

        int count = 0;

        try {
            conn = DBUtil.getConnection();
            String sql = "DELETE FROM servlet_dept WHERE deptno = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, dno);
            count = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn, ps, null);
        }

        if (count == 1) {
            System.out.println("删除成功！");
            response.sendRedirect(request.getContextPath() + "/dept/list");
        }


    }

    private void doUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取modify页面传上来的部门参数
        String dno = request.getParameter("dno");
        String dname = request.getParameter("dname");
        String loc = request.getParameter("loc");

        //DB part
        Connection conn = null;
        PreparedStatement ps = null;
        int count = 0;

        try {
            conn = DBUtil.getConnection();
            String sql = "update servlet_dept SET dname = ?, loc = ? WHERE deptno = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, dname);
            ps.setString(2, loc);
            ps.setString(3, dno);
            count = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn, ps, null);
        }

        if (count == 1) {
            System.out.println("插入成功！");
            response.sendRedirect(request.getContextPath() + "/dept/list");
        } else {
            System.out.println("插入失败!");
        }
    }

    private void doDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取List页面点击详情获取的部门编号参数
        String deptno = request.getParameter("dno");


        //DB part
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        Dept dept = new Dept();

        try {
            conn = DBUtil.getConnection();
            String sql = "select dname, loc from servlet_dept where deptno = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, deptno);
            rs = ps.executeQuery();

            if (rs.next()) {
                String dname = rs.getString("dname");
                String loc = rs.getString("loc");

                dept.setDeptno(deptno);
                dept.setDname(dname);
                dept.setLoc(loc);

            } else {
                response.sendRedirect(request.getContextPath() + "/nodept.jsp");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn, ps, rs);
        }

        request.setAttribute("dept", dept);

        String flag = request.getParameter("f");

        if ("d".equals(flag)) {
            request.getRequestDispatcher("/detail.jsp").forward(request, response);
        } else if ("m".equals(flag)) {
            request.getRequestDispatcher("/modify.jsp").forward(request, response);
        }


    }

    //连接数据库，查询所有的信息
    private void doList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<Dept> depts = new ArrayList<>();

        try {
            //获取连接
            conn = DBUtil.getConnection();
            //执行查询语句
            String sql = "select deptno, dname, loc from servlet_dept";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                //从结果集中取出
                String deptno = rs.getString("deptno");
                String dname = rs.getString("dname");
                String loc = rs.getString("loc");

                //将数据封装成java对象
                Dept dept = new Dept();
                dept.setDeptno(deptno);
                dept.setDname(dname);
                dept.setLoc(loc);

                //将部门对象放到list集合中
                depts.add(dept);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn, ps, rs);
        }

        //将一个集合放到请求域中
        request.setAttribute("deptList", depts);

        //转发（不要重定向）
        //这里可能比较难理解，为什么要用一个转发，转发到list.jsp呢？
        //因为servlet只是处理数据、逻辑，展示的话还是要交给jsp。因此需要转发给前台展示用的jsp。
        request.getRequestDispatcher("/list.jsp").forward(request, response);

    }
}
