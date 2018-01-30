<%--
  Created by IntelliJ IDEA.
  User: 刘广兴1
  Date: 2018/1/30
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>"/>
    <title></title>
</head>
<body>
<form action="addPost1" method="post">
    <input type="hidden" value="${sessionScope.did}" name="did">
    职位名称:<input type="text" name="name"><br>
    职位描述:<input type="text" name="description"><br>
    <input type="submit" value="添加">
</form>
</body>
</html>
