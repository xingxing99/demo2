<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 刘广兴1
  Date: 2018/1/29
  Time: 15:25
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
<form action="addRecruit1" method="post">
    职位:<select name="pid">
    <c:forEach items="${sessionScope.posts}" var="post">
        <option value="${post.id}">${post.name}</option>
    </c:forEach>
    </select><br>
    职位需求:<input name="requirement"><br>
    薪资待遇:<input name="salaryRange"><br>
    工作地点:<input name="address"><br>
    公司简介:<input name="introduction"><br>
    <input type="submit" value="添加">
</form>
</body>
</html>
