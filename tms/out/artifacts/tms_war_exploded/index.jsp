<%--
  Created by IntelliJ IDEA.
  User: XHW
  Date: 2020/6/4
  Time: 21:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>首页</title>
  </head>
  <%String contextPath = request.getContextPath();%>
  <body>
  <h1>欢迎来到管理系统</h1>
  <a href="<%=contextPath%>/api/courseServlet?method=findAllByPage">课程列表</a><hr>
  <a href="<%=contextPath%>/api/loginServlet?method=loginOut">退出登录</a>
  </body>
</html>
