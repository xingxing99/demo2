<%--
  Created by IntelliJ IDEA.
  User: 刘广兴1
  Date: 2018/2/2
  Time: 16:11
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
<form action="addTrain" method="post">
    培训名称:<input name="name"><br>
    培训内容:<input name="content"><br>
    开始时间:<input type="date" name="beginTime"><br>
    结束时间:<input type="date" name="endTime">
    <input type="submit" value="添加">
</form>
</body>
</html>
