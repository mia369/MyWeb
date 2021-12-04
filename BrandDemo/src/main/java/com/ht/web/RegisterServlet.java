package com.ht.web;

import com.ht.mapper.UserMapper01;
import com.ht.pojo.User;
import com.ht.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接收用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //封装对象
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        //2.调用mybatis完成查询
        //2.1 获取sqlSessionFactory对象
//        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();

        //2.2 获取sqlsession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //2.3 获取mapper对象
        UserMapper01 userMapper = sqlSession.getMapper(UserMapper01.class);

        //2.4 调用查询方法, 判断用户是否存在, 存在则返回msg, 不存在则继续调用add方法

        response.setContentType("text/html;charset=utf-8");
        PrintWriter printWriter = response.getWriter();
        User u = userMapper.selectByUsername(username);
        if (null == u) {
            userMapper.add(user);
            sqlSession.commit();
            printWriter.write("注册成功");
            sqlSession.close();
        } else {
            printWriter.write("用户名已存在");
        }

        //2.5 关闭sqlsession资源


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
