<%--
  Created by IntelliJ IDEA.
  User: TANGJIAN
  Date: 2023/1/14
  Time: 22:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>main</title>
    </head>
    <body>
        <h1>标题</h1>
        <%
            String user = request.getParameter("user");
            //HttpSession session = request.getSession();
            //String username = (String) session.getAttribute("username");
        %>
        请求转发forward<%=user%>
        <!--重定向redirect<%//=username%>-->

    </body>
</html>
