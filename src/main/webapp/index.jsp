<%--
  Created by IntelliJ IDEA.
  User: 乔同良
  Date: 2020/6/17
  Time: 22:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h4><%=path%></h4>
<h4><%=basePath%></h4>
<a href="<%=path%>/views/hello.jsp">跳转</a>
</body>
</html>
