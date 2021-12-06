package com.ht.web;

import com.alibaba.fastjson.JSON;
import com.ht.pojo.Brand;
import com.ht.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/selectAllServlet01")
public class SelectAllServlet01 extends HttpServlet {
    private BrandService brandService = new BrandService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用service的方法
        List<Brand> brands = brandService.selectAll();
        System.out.println(brands);

        //返回的list序列化为json
        String jsonStr = JSON.toJSONString(brands);
        System.out.println(jsonStr);

        //发送响应
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonStr);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
