<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 刘广兴1
  Date: 2018/1/29
  Time: 16:19
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
        <th>招聘职位</th>
        <th>职位介绍</th>
        <th>职位需求</th>
        <th>薪资待遇</th>
        <th>工作地址</th>
        <th>创建时间</th>
        <th>公司简介</th>
    </tr>
    <c:forEach items="${sessionScope.recruits}" var="rei">
    <c:forEach items="${sessionScope.posts}" var="post">
    <c:if test="${post.id==rei.pid}">
    <tr>
        <td>${post.name}</td>
        <td>${post.description}</td>
        <td>${rei.requirement}</td>
        <td>${rei.salaryRange}</td>
        <td>${rei.address}</td>
        <td>${rei.createTime}</td>
        <td>${rei.introduction}</td>
        <td>
            <a href="updateResumeState?rid=${rei.id}">申请职位</a>
        </td>
    </tr>
    </c:if>
    </c:forEach>
    </c:forEach>
</body>
</html>
