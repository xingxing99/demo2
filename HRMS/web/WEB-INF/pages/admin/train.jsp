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
    <style>
        .black_overlay{
            display: none;
            position: absolute;
            top: 0%;
            left: 0%;
            width: 100%;
            height: 100%;
            background-color: black;
            z-index:1001;
            -moz-opacity: 0.8;
            opacity:.80;
            filter: alpha(opacity=88);
        }
        .white_content {
            display: none;
            position: absolute;
            top: 25%;
            left: 25%;
            width: 55%;
            height: 55%;
            padding: 20px;
            border: 10px solid orange;
            background-color: white;
            z-index:1002;
            overflow: auto;
        }
    </style>
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
    <a href = "javascript:void(0)" onclick = "document.getElementById('light').style.display='block';document.getElementById('fade').style.display='block'">更改</a>
    <div id="light" class="white_content">
        <a href = "javascript:void(0)" onclick = "document.getElementById('light').style.display='none';document.getElementById('fade').style.display='none'">点击取消修改</a>
        <form action="updateTrain" method="post">
            <input type="hidden" name="id" value="${t.id}">
            <input type="hidden" name="state" value="${t.state}">
            培训名称: <input name="name" value="${t.name}"><br>
            培训内容:<input name="content" value="${t.content}"><br>
            起始时间: <input name="beginTime" value="${t.beginTime}"><br>
            结束时间:<input name="endTime" value="${t.endTime}"><br>
            <input type="submit" value="更改">
        </form>
    </div>
    <div id="fade" class="black_overlay"></div>
</c:forEach>
</body>
</html>
