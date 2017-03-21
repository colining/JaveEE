<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2017/3/7
  Time: 11:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
    <form method="post" action="CookieLoginServlet">


        <table>

            <tr>
                <td>请输入用户名：</td>
                <td><input type="text" name="user"></td>
            </tr>
            <tr>
                <td>请输入密码</td>
                <td><input type="password" name="password"> </td>
            </tr>
            <tr>
                <td><input type="reset" value="重填"></td>
                <td><input type="submit" value="登录"></td>
            </tr>
        </table>
    </form>
</body>
</html>
