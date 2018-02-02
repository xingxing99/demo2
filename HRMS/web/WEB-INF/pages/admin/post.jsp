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
${sessionScope.p1}
<table border="1" cellpadding="1" cellspacing="0">
    <tr>
        <th>职位id</th>
        <th>职位名称</th>
        <th>部门</th>
        <th>职位介绍</th>
    </tr>
    <c:forEach items="${sessionScope.depts}" var="depts">
        <c:forEach items="${sessionScope.post}" var="post">
            <c:if test="${post.did==depts.did}">
                <tr>
                    <td>${post.id}</td>
                    <td>${post.name}</td>
                    <td>${depts.dname}</td>
                    <td>${post.description}</td>
                    <td>
                        <a href="selectPostByPid?pid=${post.id}">查看该职位下员工</a>
                    </td>
                    <td>
                        <form action="deletePost" method="post">
                            <input type="hidden" value="${post.id}" name="id">
                            <input type="hidden" value="${post.did}" name="did">
                            <input type="submit" value="删除">
                        </form>
                    </td>
                </tr>
            </c:if>
        </c:forEach>
    </c:forEach>
    <a href="addPost?did=${sessionScope.did}">添加职位</a>
</table>
</body>
</html>
