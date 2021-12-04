<%@ page import="com.ht.utils.SqlSessionFactoryUtil" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactory" %>
<%@ page import="org.apache.ibatis.session.SqlSession" %>
<%@ page import="com.ht.mapper.BrandMapper" %>
<%@ page import="com.ht.pojo.Brand" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: admin2
  Date: 2021/12/2
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>数据展示</title>
</head>
<body>
<input type="button" value="新增"><br>
<hr>
<table border="1" cellspacing="0" width="800">
    <tr>
        <th>序号</th>
        <th>品牌名称</th>
        <th>企业名称</th>
        <th>排序</th>
        <th>品牌介绍</th>
        <th>状态</th>
        <th>操作</th>
    </tr>

    <%
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = brandMapper.selectAll();
        for (int i = 0; i < brands.size(); i++) {
            Brand brand = brands.get(i);
    %>

    <tr align="center">
        <td><%=brand.getId()%></td>
        <td><%=brand.getBrandName()%></td>
        <td><%=brand.getCompanyName()%></td>
        <td><%=brand.getOrdered()%></td>
        <td><%=brand.getDescription()%></td>

    <%
        if (brand.getStatus() == 1){
            //启用
    %>
        <td><%="启用"%></td>
    <%
        } else {
            //禁用
    %>
        <td><%="禁用"%></td>
    <%
        }
    %>
        <td><a href="#">修改</a><a href="#">删除</a></td>
    </tr>

    <%
        }
    %>

</table>
</body>
</html>
