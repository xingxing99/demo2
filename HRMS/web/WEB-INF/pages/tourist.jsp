<%--
  Created by IntelliJ IDEA.
  User: 刘广兴1
  Date: 2018/1/26
  Time: 15:51
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
${sessionScope.t1}
${sessionScope.r8}
${sessionScope.r99}
<a href="selectResume">查看简历</a>
<a href="getAllRecruit">查看招聘信息</a>
<a href="selectInform">查看面试信息</a>
</body>
</html>
