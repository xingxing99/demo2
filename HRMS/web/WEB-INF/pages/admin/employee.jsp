<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 刘广兴1
  Date: 2018/1/30
  Time: 16:16
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
        <th>姓名</th>
        <th>年龄</th>
        <th>性别</th>
        <th>职位</th>
        <th>状态</th>
        <th>录取时间</th>
    </tr>
    <c:forEach items="${sessionScope.employee}" var="e">
        <c:forEach items="${sessionScope.post}" var="p">
            <c:if test="${e.pid==p.id}">
                <tr>
                    <td>${e.name}</td>
                    <td>${e.age}</td>
                    <td>${e.sex}</td>
                    <td>${p.name}</td>
                    <c:if test="${e.state==0}">
                        <td>离职</td>
                    </c:if>
                    <c:if test="${e.state==1}">
                        <td>在职</td>
                    </c:if>
                    <td>${e.createTime}</td>
                </tr>
            </c:if>
        </c:forEach>
    </c:forEach>
</table>
</body>
</html>
