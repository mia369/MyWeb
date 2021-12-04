package com.ht.service;

import com.ht.mapper.BrandMapper01;
import com.ht.pojo.Brand;
import com.ht.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class BrandService {

    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();

    public List<Brand> selectAll() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper01 brandMapper01 = sqlSession.getMapper(BrandMapper01.class);
        List<Brand> brands = brandMapper01.selectAll();
        sqlSession.close();
        return brands;
    }

    public void add(Brand brand) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper01 brandMapper01 = sqlSession.getMapper(BrandMapper01.class);
        brandMapper01.add(brand);
        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    public Brand selectById(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper01 brandMapper01 = sqlSession.getMapper(BrandMapper01.class);
        Brand brand = brandMapper01.selectById(id);
        //提交事务
        sqlSession.commit();
        sqlSession.close();
        return brand;
    }

    public void update(Brand brand) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper01 brandMapper01 = sqlSession.getMapper(BrandMapper01.class);
        brandMapper01.update(brand);
        sqlSession.commit();
        sqlSession.close();
    }

    public void delete(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper01 brandMapper01 = sqlSession.getMapper(BrandMapper01.class);
        brandMapper01.delete(id);
        sqlSession.commit();
        sqlSession.close();
    }
}
