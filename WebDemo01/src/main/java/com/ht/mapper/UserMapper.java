package com.ht.mapper;

import com.ht.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserMapper {

    //登录查找用户
    @Select("select * from tb_user where username = #{username} and password = #{password}")
    User login(@Param("username") String username, @Param("password") String password);

    //根据用户名查找用户
    @Select("select * from tb_user where username=#{username};")
    User selectByUsername(String username);

    //添加用户
    @Insert("insert into tb_user values (null, #{username}, #{password}) ;")
    void add(User user);
}
