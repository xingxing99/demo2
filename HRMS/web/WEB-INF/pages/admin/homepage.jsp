<%--
  Created by IntelliJ IDEA.
  User: 刘广兴1
  Date: 2018/1/29
  Time: 10:42
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
${sessionScope.r10}
${sessionScope.r1}
<a href="selectDept">部门管理</a>
<a href="selectRecruit">招聘管理</a>
<a href="selectResumeByState">查看职位申请</a>
<a href="#">培训管理</a>
</body>
</html>
