<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 刘广兴1
  Date: 2018/2/2
  Time: 16:15
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
${sessionScope.info}
<a href="jumpAddTrain">新增培训内容</a>
<c:forEach items="${sessionScope.trains}" var="t">
    <p>培训名称:${t.name}</p>
    <p>培训内容:${t.content}</p>
    <p>起始时间:${t.beginTime}</p>
    <p>结束时间:${t.endTime}</p>
    <a href="deleteTrain?id=${t.id}&state=${t.state}">删除</a>
</c:forEach>
</body>
</html>
