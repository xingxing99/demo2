<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 刘广兴1
  Date: 2018/1/26
  Time: 17:25
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
    <style>
        #i1{
            margin-left: 400px;
        }
    </style>
</head>
<body>
${sessionScope.r1}
${sessionScope.r2}
<a href="addResume">添加</a>
<form action="updateResume" method="post">
<table border="1" cellspacing="0"  align="center" width="550" >
    <tr align="center">
        <td align="center" colspan="6">个人简历</td>
    </tr>
    <tr align="center">
        <td rowspan="4">个人信息</td>
        <td>姓名</td>
        <td>${sessionScope.resumes.name}</td>
        <td>性别</td>
        <td>${sessionScope.resumes.sex}</td>
        <td rowspan="4" width="100"></td>
    </tr>
    <tr align="center">
        <td>年龄</td>
        <td>${sessionScope.resumes.age}</td>
        <td>地址</td>
        <td>${sessionScope.resumes.address}</td>
    </tr>
    <tr align="center">
        <td>毕业院校</td>
        <td>${sessionScope.resumes.school}</td>
        <td>学历</td>
        <td>${sessionScope.resumes.education}</td>
    </tr>
    <tr align="center">
        <td>专业</td>
        <td>${sessionScope.resumes.major}</td>
        <td>学位</td>
        <td>${sessionScope.resumes.degree}</td>
    </tr>
    <tr align="center">
        <td rowspan="2">联系方式</td>
        <td>联系电话</td>
        <td colspan="4">${sessionScope.resumes.phone}</td>
    </tr>
    <tr align="center">
        <td>E-mail</td>
        <td colspan="4">${sessionScope.resumes.email}</td>
    </tr>
    <tr align="center" height="100">
        <td rowspan="1">个人能力</td>
        <td colspan="5">${sessionScope.resumes.skill}</td>
    </tr>
    <tr align="center" height="100">
        <td>自我评价</td>
        <td colspan="5">${sessionScope.resumes.evaluate}</td>
    </tr>
    <tr align="center" height="100">
        <td>工作经历</td>
        <td colspan="5">${sessionScope.resumes.experience}</td>
    </tr>
</table>
    <input type="submit" value="修改简历" id="i1">
</form>
</body>
</html>
