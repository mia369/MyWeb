<%--
  Created by IntelliJ IDEA.
  User: admin2
  Date: 2021/12/3
  Time: 21:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>login</title>
</head>
<body>
<form action="/BrandDemo/loginServlet" method="post" id="form">
    <h1>LOG IN</h1>

    <p>Username:<input id="username" name="username" value="${cookie.username.value}" type="text"></p>

    <p>Password:<input id="password" name="password" value="${cookie.password.value}" type="password"></p>

    <p>Remember:<input id="remember" name="remember" value="1" type="checkbox"></p>

    <input type="submit" class="button" value="submit">
    <input type="reset" class="button" value="reset">
    <a href="register.html">没有账号? 点击注册</a>
</form>
</body>
</html>