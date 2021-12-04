package com.ht.web;

import com.ht.mapper.UserMapper;
import com.ht.pojo.User;
import com.ht.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接收用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //2.调用mybatis完成查询
        //2.1 获取sqlsessionfactory对象
//        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();

        //2.2 获取sqlsession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //2.3 获取mapper对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //2.4 调用方法
        User user = userMapper.login(username, password);

        //2.5 关闭sqlsession
        sqlSession.close();

        //3.判断user是否为null
        response.setContentType("text/html;charset=utf-8");
        PrintWriter printWriter = response.getWriter();

        if (null != user) {
            //登录成功
            printWriter.write("登录成功");
        } else {
            //登录失败
            printWriter.write("登录失败");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
