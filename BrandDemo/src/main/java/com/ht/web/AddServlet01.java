package com.ht.web;

import com.alibaba.fastjson.JSON;
import com.ht.pojo.Brand;
import com.ht.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/addServlet01")
public class AddServlet01 extends HttpServlet {
    private BrandService brandService = new BrandService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //接收数据
        BufferedReader br = request.getReader();
        String json = br.readLine();

        //将接收的json数据转换为brand对象
        Brand brand = JSON.parseObject(json,Brand.class);

        //执行add方法
        brandService.add(brand);

        //响应数据
        response.getWriter().write("success");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
