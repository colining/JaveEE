<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2017/3/28
  Time: 19:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="Upload" enctype="multipart/form-data">
    请选择上传文件：<input type="file" name="file1" size="40"><br>
    <input type="submit" value="上传">
    <input
            type="reset" value="重置">
</form>
</body>
</html>
