/*
package com.ht.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        //如果访问的路径为登录或注册,则放行
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String url = httpServletRequest.getRequestURL().toString();
        String[] urls = {"/login.jsp", "/loginServlet", "/register.jsp", "/registerServlet"};
        for(String u : urls) {
            if(url.contains(u)) {
                chain.doFilter(request, response);
                return;
            }
        }

        //1.获取request中的session,因为是httpServletRequest特有的方法,所以要强转
        HttpSession httpSession = httpServletRequest.getSession();
        //2.从session中获取user对象,判断对象是否为空
        Object user = httpSession.getAttribute("user");
        if (user != null) {
            chain.doFilter(request, response);

        } else {
            //转发到login.jsp
            request.setAttribute("login_msg", "您尚未登录");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }

    }

    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }


}
*/
