<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 刘广兴1
  Date: 2018/1/29
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
    <style>
        #i1{
            margin-left: 400px;
        }
        table input{
            border: none;
        }
        textarea{
            border: none;
        }
    </style>
</head>
<body>
<form action="updateResume1" method="post">
    <table border="1" cellspacing="0"  align="center" width="550" >

        <tr align="center">
            <td align="center" colspan="6">个人简历</td>
        </tr>
        <tr align="center">
            <td rowspan="4">个人信息</td>
            <td>姓名</td>
            <td><input name="name" value="${sessionScope.resumes.name}"></td>
            <td>性别</td>
            <td><input name="sex" value="${sessionScope.resumes.sex}"></td>
            <td rowspan="4" width="100"></td>
        </tr>
        <tr align="center">
            <td>年龄</td>
            <td><input name="age" value="${sessionScope.resumes.age}"></td>
            <td>地址</td>
            <td><input name="address" value="${sessionScope.resumes.address}"></td>
        </tr>
        <tr align="center">
            <td>毕业院校</td>
            <td><input name="school" value="${sessionScope.resumes.school}"></td>
            <td>学历</td>
            <td><input name="education" value="${sessionScope.resumes.education}"></td>
        </tr>
        <tr align="center">
            <td>专业</td>
            <td><input name="major" value="${sessionScope.resumes.major}"></td>
            <td>学位</td>
            <td><input name="degree" value="${sessionScope.resumes.degree}"></td>
        </tr>
        <tr align="center">
            <td rowspan="2">联系方式</td>
            <td>联系电话</td>
            <td colspan="4"><input name="phone" value="${sessionScope.resumes.phone}"></td>
        </tr>
        <tr align="center">
            <td>E-mail</td>
            <td colspan="4"><input name="email" value="${sessionScope.resumes.email}"></td>
        </tr>
        <tr align="center" height="100">
            <td rowspan="1">个人能力</td>
            <td colspan="5"><textarea name="skill">${sessionScope.resumes.skill}</textarea></td>
        </tr>
        <tr align="center" height="100">
            <td>自我评价</td>
            <td colspan="5"><textarea name="evaluate">${sessionScope.resumes.evaluate}</textarea></td>
        </tr>
        <tr align="center" height="100">
            <td>工作经历</td>
            <td colspan="5"><textarea name="experience">${sessionScope.resumes.experience}</textarea></td>
        </tr>

    </table>
    <input type="submit" value="修改" id="i1">
</form>
</body>
</html>
