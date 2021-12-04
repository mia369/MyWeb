package com.ht.web.servletdemo;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/req1")
public class ReqDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        String method = req.getMethod();
        System.out.println(method);

        String path = req.getContextPath();
        System.out.println(path);

        StringBuffer url = req.getRequestURL();
        System.out.println(url.toString());

        String uri = req.getRequestURI();
        System.out.println(uri);

        String query = req.getQueryString();
        System.out.println(query);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        BufferedReader br = req.getReader();
        String line = br.readLine();
        System.out.println(line);
    }
}
