package com.ht.web.servletdemo;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

//配置访问路径 初始化参数(负整数为访问servlet时初始化,0或正整数为服务器启动时初始化)
@WebServlet(urlPatterns = "/demo1", loadOnStartup = 1)
public class ServletDemo01 implements Servlet {
    private ServletConfig servletConfig;

    //初始化
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.servletConfig = servletConfig;
//        System.out.println(servletConfig);
        System.out.println("initiating...");
    }

    @Override
    public ServletConfig getServletConfig() {
        return servletConfig;
    }

    //Servlet被访问时service方法被自动执行
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("servlet hello world!");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    //释放资源或关闭服务器时 调用一次 用于销毁servlet对象
    @Override
    public void destroy() {
        System.out.println("destroyed");
    }
}
