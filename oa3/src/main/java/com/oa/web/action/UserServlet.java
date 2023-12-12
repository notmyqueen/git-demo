package com.oa.web.action;

import com.oa.utils.DBUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet({"/login", "/exit"})
public class UserServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String servletPath = request.getServletPath();
        if ("/login".equals(servletPath)) {
            doLogin(request, response);
        } else doExit(request, response);

    }

    private void doExit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        session.invalidate();

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                System.out.println("已清除当前cookie："+cookie.getValue());
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
        }

        //退出后重定向到exit.jsp
        response.sendRedirect(request.getContextPath() + "/exit.jsp");
    }


    protected void doLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取登录页面提交的用户名密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //标记
        boolean succeed = false;

        //DB part
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DBUtil.getConnection();
            String sql = "select * from t_user where username = ? AND password = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("登陆成功");
                succeed = true;
            } else System.out.println("登陆失败");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn, ps, rs);
        }

        if (succeed) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);

            //cookie一定是登陆成功后，才起作用的。所以放在登陆成功的if语句内。
            //登陆成功，并且用户选择了需要十天免登录
            String f = request.getParameter("flag");
            System.out.println("f的value：" + f);
            if ("cookieOn".equals(f)) {
                Cookie cookie1 = new Cookie("username", username);
                Cookie cookie2 = new Cookie("password", password);

                //设置cookie的有效期是十天
                cookie1.setMaxAge(60 * 60 * 24 * 10);
                cookie2.setMaxAge(60 * 60 * 24 * 10);

                //设置cookie的path，只要是访问这个path，浏览器就一定要携带这两个cookie
                cookie1.setPath(request.getContextPath());
                cookie2.setPath(request.getContextPath());

                //响应cookie给浏览器
                response.addCookie(cookie1);
                response.addCookie(cookie2);
            }


            //登陆成功，重定向至列表页。这里为什么用重定向，因为是session携带用户名信息，不是request。重定向还是同一个session。
            response.sendRedirect(request.getContextPath() + "/dept/list");

            //登陆失败，重定向至登陆失败页
        } else response.sendRedirect(request.getContextPath() + "/loginfailed.jsp");

    }
}
