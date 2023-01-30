<%--
  Created by IntelliJ IDEA.
  User: TANGJIAN
  Date: 2023/1/14
  Time: 21:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>login登录</title>
    <style>
      body{
        text-align: center;
      }
    </style>
  </head>
  <body>
    <form method="post" action="/JavaWeb/login">
      <h1>登录</h1>
      username：<input name="user" type="text"><br><br>
      password：<input name="pass" type="password"><br><br>
      <button type="submit">登录</button>
      <a href="register.jsp">无账号，去注册</a>
    </form>
  </body>
</html>
