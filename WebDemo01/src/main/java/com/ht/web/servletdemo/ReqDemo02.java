package com.ht.web.servletdemo;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@WebServlet("/req2")
public class ReqDemo02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        //解决post方法中出现的中文乱码问题
        req.setCharacterEncoding("utf-8");
        //解决tomcat 8 版本前get方法中出现的中文乱码问题
        //username = new String(username.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);

        Map<String, String[]> map = req.getParameterMap();
        for (String key : map.keySet()) {
            System.out.print(key + ":");
            String[] values = map.get(key);
            for(String value : values){
                System.out.print(value + " ");
            }
            System.out.println();
        }

        String[] hobbies = req.getParameterValues("hobby");
        for(String hobby : hobbies){
            System.out.println(hobby);
        }

        System.out.println("-------------");

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username);
        System.out.println(password);

    }

    @Override
    protected void doPost(HttpServletRequest res, HttpServletResponse resp) throws UnsupportedEncodingException {
        this.doGet(res, resp);
    }

}
