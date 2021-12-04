<%--
  Created by IntelliJ IDEA.
  User: admin2
  Date: 2021/12/4
  Time: 10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>欢迎注册</title>
</head>
<body>
<h1>欢迎注册</h1>
<span>已有账号?点击登录</span><a href="login.jsp">登录</a>
<form action="/BrandDemo/registerServlet" method="post">
    <table>
        <tr>
            <td>用户名</td>
            <td>
                <input id="username" name="username" type="text" >
                        <br>
                        <span id="username_err" style="color: brown">${register_msg}</span>
            </td>
        </tr>

        <tr>
            <td>密码</td>
            <td>
                <input id="password" name="password" type="password">
                <!--        <br>-->
                <!--        <span id="password_err">密码格式有误</span>-->
            </td>
        </tr>

<%--        <tr>
            <td>验证码</td>
            <td>
                <input name="checkCode" type="text" id="checkCode">
                <img>
                <a href="#" id="changeImg">看不清?</a>
            </td>
        </tr>--%>
    </table>

    <input value="注  册" type="submit">
    <br>
</form>
</body>
</html>