package com.oa.web.action;

import com.oa.utils.DBUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.*;

/*
    不论是否携带cookie，一开始都来到这个登陆的servlet
 */
@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取cookie。如果没有cookie，cookies数组是null。有cookie，数组长度大于等于1。不存在长度是0的cookies数组
        Cookie[] cookies = request.getCookies();
        try {
            System.out.println("当前cookie个数：" + cookies.length);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("It's probably due to 0 of cookies.length");
        }

        String username = null;
        String password = null;

        boolean succeed = false;

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                //获取cookie的名字
                String name = cookie.getName();
                //如果cookie的名字是“username”，则把其对应的value（用户名）赋值给username
                if ("username".equals(name)) {
                    username = cookie.getValue();
                    System.out.println("当前cookie的username：" + username);
                    //如果cookie的名字是“password”，则把其对应的value（密码）赋值给password
                } else if ("password".equals(name)) {
                    password = cookie.getValue();
                    System.out.println("当前cookie的password：" + password);
                }
            }
        }

        //判断cookie中是否有用户名密码
        if (username != null && password != null) {
            //如果有，验证用户名密码是否正确
            //DB part
            Connection conn = null;
            PreparedStatement ps = null;
            ResultSet rs = null;

            try {
                conn = DBUtil.getConnection();
                String sql = "SELECT * from t_user WHERE username = ? AND password = ?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, username);
                ps.setString(2, password);
                rs = ps.executeQuery();
                if (rs.next()) {
                    System.out.println("cookie验证成功");
                    succeed = true;
                    //配上session
//                    HttpSession session = request.getSession();
//                    session.setAttribute("username", username);
//                    response.sendRedirect(request.getContextPath()+request.getServletPath());   ***

//                    response.sendRedirect(request.getContextPath()+"/dept/list");
                }

                if (succeed) {
                    HttpSession session = request.getSession();
                    session.setAttribute("username", username);
                    Object username1 = session.getAttribute("username");
                    System.out.println("这里应该是toString自动调用了："+username1);
//                    System.out.println(aaa);
//                if ("/welcome".equals(request.getServletPath())) {
//                    System.out.println("进入/welcome就是跳转到/dept/list");
                    response.sendRedirect(request.getContextPath() + "/dept/list");  //*
//                } else {
//                    System.out.println("无敌写法在这里起作用，就有了cookie后，hit哪个link就直接进那个link，不用先跳转到/dept/list");
//                    response.sendRedirect(request.getContextPath() + request.getServletPath());  //***
//                }
                } else {
                    response.sendRedirect(request.getContextPath() + "/login.jsp");  //*
                    System.out.println("hi");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DBUtil.close(conn, ps, rs);
            }

        } else {
            //cookie中没有用户名和密码，则跳转到登陆页
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        }




    }
}
