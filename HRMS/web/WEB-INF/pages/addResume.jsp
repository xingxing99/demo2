<%--
  Created by IntelliJ IDEA.
  User: 刘广兴1
  Date: 2018/1/29
  Time: 9:56
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
<form action="" method="post">
    毕业院校：<input name="school">
    学历：<input name="education">
    专业：<input name="major">
    学位：<input name="degree">
    地址：<input name="address">
    能力：<input name="skill">
    自我评价：<input name="evaluate">
    工作经历：<input name="experience">
    <input type="submit" value="提交">
</form>
</body>
</html>
