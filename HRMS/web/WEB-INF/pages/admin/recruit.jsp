<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 刘广兴1
  Date: 2018/1/29
  Time: 15:03
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
${sessionScope.r2}
<a href="addRecruit">添加招聘信息</a>
<table border="1" cellpadding="1" cellspacing="0">
    <tr>
        <th>招聘id</th>
        <th>招聘职位</th>
        <th>职位需求</th>
        <th>薪资待遇</th>
        <th>工作地址</th>
        <th>创建时间</th>
        <th>公司简介</th>
        <th>招聘状态</th>
    </tr>
    <c:forEach items="${sessionScope.recruits}" var="rei">
        <c:forEach items="${sessionScope.posts}" var="post">
            <c:if test="${post.id==rei.pid}">
                <tr>
                <td>${rei.id}</td>
                <td>${post.name}</td>
                <td>${rei.requirement}</td>
                <td>${rei.salaryRange}</td>
                <td>${rei.address}</td>
                <td>${rei.createTime}</td>
                <td>${rei.introduction}</td>
                <td>${rei.state}</td>
                <td>
                    <a href="updateRecruit?id=${rei.id}">发布招聘信息</a>
                </td>
                <td>
                    <a href="updateRecruit1?id=${rei.id}">撤销招聘信息</a>
                </td>
                </tr>
            </c:if>
        </c:forEach>
    </c:forEach>
</table>
</body>
</html>
