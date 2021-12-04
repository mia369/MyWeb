package com.ht.mapper;

import com.ht.pojo.Brand;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BrandMapper01 {

    @Select("select * from tb_brand")
    @ResultMap("brandResultMap")
    List<Brand> selectAll();

    @Insert("insert into tb_brand values (null, #{brandName}, #{companyName}, #{ordered}, #{description}, #{status});")
    @ResultMap("brandResultMap")
    void add(Brand brand);

    @Select("select * from tb_brand where id = #{id};")
    @ResultMap("brandResultMap")
    Brand selectById(int id);

//    @ResultMap("brandResultMap")
    void update(Brand brand);

    @Delete("delete from tb_brand where id = #{id};")
    void delete(int id);
}
