package com.ht.service;

import com.ht.mapper.UserMapper01;
import com.ht.pojo.User;
import com.ht.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserService {
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();

    public User login(String username, String password) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper01 userMapper01 = sqlSession.getMapper(UserMapper01.class);
        User user = userMapper01.login(username, password);
        sqlSession.close();
        return user;
    }

    public boolean register(User user) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper01 userMapper01 = sqlSession.getMapper(UserMapper01.class);
        //判断用户名是否存在
        User user01 = userMapper01.selectByUsername(user.getUsername());
        if (user01 == null) {
            userMapper01.add(user);
            sqlSession.commit();
        }
        sqlSession.close();
        return user01 == null;
    }


}
