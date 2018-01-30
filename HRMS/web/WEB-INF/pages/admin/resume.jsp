<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 刘广兴1
  Date: 2018/1/29
  Time: 18:39
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
    <script src="js/jquery-3.1.0.js"></script>
    <script>
        function time() {
            var r = prompt("请输入面试时间","日期");
            if (r!=null&&r!=""){
                $("#interview").val(r);
                return true;
            }else{
                return false;
            }
        }
    </script>

    <style>
        #i1{
            margin-left: 400px;
        }
        #i2{
            margin-left: 400px;
        }
    </style>
</head>
<body>
<table border="1" cellspacing="0"  align="center" width="550" >
    <tr align="center">
        <td align="center" colspan="6">个人简历</td>
    </tr>
    <c:forEach items="${sessionScope.resumes}" var="resumes">
    <c:forEach items="${sessionScope.recruit}" var="recruit">
    <c:if test="${resumes.rid==recruit.id}">
    <tr align="center">
        <c:forEach items="${sessionScope.posts}" var="post">
            <c:if test="${recruit.pid==post.id}">
                <td align="center" colspan="6">申请职位:${post.name}</td>
            </c:if>
        </c:forEach>
    </tr>
    <tr align="center">
        <td rowspan="4">个人信息</td>
        <td>姓名</td>
        <td>${resumes.name}</td>
        <td>性别</td>
        <td>${resumes.sex}</td>
        <td rowspan="4" width="100"></td>
    </tr>
    <tr align="center">
        <td>年龄</td>
        <td>${resumes.age}</td>
        <td>地址</td>
        <td>${resumes.address}</td>
    </tr>
    <tr align="center">
        <td>毕业院校</td>
        <td>${resumes.school}</td>
        <td>学历</td>
        <td>${resumes.education}</td>
    </tr>
    <tr align="center">
        <td>专业</td>
        <td>${resumes.major}</td>
        <td>学位</td>
        <td>${resumes.degree}</td>
    </tr>
    <tr align="center">
        <td rowspan="2">联系方式</td>
        <td>联系电话</td>
        <td colspan="4">${resumes.phone}</td>
    </tr>
    <tr align="center">
        <td>E-mail</td>
        <td colspan="4">${resumes.email}</td>
    </tr>
    <tr align="center" height="100">
        <td rowspan="1">个人能力</td>
        <td colspan="5">${resumes.skill}</td>
    </tr>
    <tr align="center" height="100">
        <td>自我评价</td>
        <td colspan="5">${resumes.evaluate}</td>
    </tr>
    <tr align="center" height="100">
        <td>工作经历</td>
        <td colspan="5">${resumes.experience}</td>
    </tr>
        <c:if test="${resumes.state==1}">
            <form action="inform" method="post" onsubmit="return time()">
                <input type="hidden" name="uid" value="${resumes.uid}">
                <input type="hidden" id="interview" name="interview">
                <input type="submit" value="通知面试" id="i1">
            </form>
        </c:if>
        <c:if test="${resumes.state==3}">
            <form action="addEmployee" method="post">
                <input type="hidden" name="uid" value="${resumes.uid}">
                <input type="hidden" name="pid" value="${recruit.pid}">
                <input type="submit" value="录用" id="i2">
            </form>
        </c:if>
    </c:if>
    </c:forEach>
    </c:forEach>
</table>
</body>
</html>
