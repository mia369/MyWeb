package com.ht.web;

import com.ht.pojo.Brand;
import com.ht.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/selectByIdServlet")
public class SelectByIdServlet extends HttpServlet {
    BrandService brandService = new BrandService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接收id
        String id = request.getParameter("id");

        //调用service查询
        Brand brand = brandService.selectById(Integer.parseInt(id));

        //把查询到的对象存储到request中
        request.setAttribute("brand", brand);

        //转发到update.jsp中
        request.getRequestDispatcher("/update.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
