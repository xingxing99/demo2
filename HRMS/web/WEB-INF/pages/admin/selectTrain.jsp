<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 刘广兴1
  Date: 2018/2/3
  Time: 13:38
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
    <table>
        <tr>
            <th>培训名称</th>
            <th>培训内容</th>
            <th>开始时间</th>
            <th>结束时间</th>
        </tr>
        <c:forEach items="${sessionScope.trains}" var="t">
                <tr>
                    <td>${t.name}</td>
                    <td>${t.content}</td>
                    <td>${t.beginTime}</td>
                    <td>${t.endTime}</td>
                    <td>
                        <a href="arrangeTrain1?did=${sessionScope.did}&id=${t.id}&beginTime=${t.beginTime}">选择培训</a>
                    </td>
                </tr>
        </c:forEach>
    </table>
</body>
</html>
