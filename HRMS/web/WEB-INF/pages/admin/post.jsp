<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 刘广兴1
  Date: 2018/1/29
  Time: 14:35
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
<table border="1" cellpadding="1" cellspacing="0">
    <tr>
        <th>职位id</th>
        <th>职位名称</th>
        <th>部门</th>
        <th>职位介绍</th>
    </tr>
    <c:forEach items="${sessionScope.post}" var="post">
        <c:forEach items="${sessionScope.depts}" var="depts">
            <c:if test="${post.did==depts.did}">
                <td>${post.id}</td>
                <td>${post.name}</td>
                <td>${depts.dname}</td>
                <td>${post.describe}</td>
            </c:if>
        </c:forEach>
    </c:forEach>
</table>
</body>
</html>
