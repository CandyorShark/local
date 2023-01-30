<%--
  Created by IntelliJ IDEA.
  User: TANGJIAN
  Date: 2023/1/30
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>register注册</title>
        <style>
            body{
                text-align: center;
            }
        </style>
    </head>
    <body>

        <form method="post" action="/JavaWeb/Register">
            <h1>注册</h1>
            username：<input name="user" type="text"><br><br>
            password：<input name="pass" type="password"><br><br>
            towpassword：<input name="tpass" type="password"><br><br>
            <button type="submit">注册</button>
            <a href="index.jsp">已有账号，去登陆</a>
        </form>

    </body>
</html>
