package com.ht.web;


import com.ht.pojo.User;
import com.ht.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;


@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接收用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //获取复选框数据
        String remember = request.getParameter("remember");

        //2.调用mybatis完成查询
        User user = userService.login(username, password);

        //3.判断
        if (user != null) {
            //判断用户是否勾选记住我
            if ("1".equals(remember)) {
                //勾选了 创建cookie
                Cookie cUsername = new Cookie("username", username);
                Cookie cPassword = new Cookie("password", password);
                //设置cookie存活时间
                cUsername.setMaxAge(60 * 60 * 24 * 7);
                cPassword.setMaxAge(60 * 60 * 24 * 7);
                //发送
                response.addCookie(cUsername);
                response.addCookie(cPassword);
            }

            //用session存储用户信息
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("user", user);

            //重定向 查询所有brand
//            request.getRequestDispatcher("/selectAllServlet").forward(request, response);
            String contextPath = request.getContextPath();
            response.sendRedirect(contextPath + "/selectAllServlet");
        } else {
            //登陆失败 跳转到login.jsp 携带错误提示信息
            request.setAttribute("login_msg", "用户名或密码错误");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
