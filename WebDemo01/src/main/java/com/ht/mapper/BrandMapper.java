package com.ht.mapper;

import com.ht.pojo.Brand;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BrandMapper {

    List<Brand> selectAll();
}
