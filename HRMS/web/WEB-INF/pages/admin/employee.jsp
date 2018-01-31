<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 刘广兴1
  Date: 2018/1/30
  Time: 16:16
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
        $(function () {
            $("#d1").click(function () {
                $("#d2").css("display","block")
            })
        })
    </script>
</head>
<body>
<table border="1" cellpadding="1" cellspacing="0">
    <tr>
        <th>姓名</th>
        <th>年龄</th>
        <th>性别</th>
        <th>部门</th>
        <th>职位</th>
        <th>状态</th>
        <th>录取时间</th>
    </tr>
    <c:forEach items="${sessionScope.employee}" var="e">
        <c:forEach items="${sessionScope.post}" var="p">
            <c:forEach items="${sessionScope.depts}" var="d">
                <c:if test="${e.pid==p.id&&d.did==p.did}">
                    <tr>
                        <td>${e.name}</td>
                        <td>${e.age}</td>
                        <td>${e.sex}</td>
                        <td>${d.dname}</td>
                        <td>${p.name}</td>
                        <c:if test="${e.state==0}">
                            <td>离职</td>
                        </c:if>
                        <c:if test="${e.state==1}">
                            <td>在职</td>
                        </c:if>
                        <td>${e.createTime}</td>
                        <td>
                            <div id="d1">
                                <input value="换岗" type="submit">
                            </div>
                        </td>
                    </tr>
                    <div id="d2" style="display: none">
                        <form action="changePost" method="post">
                            <input type="hidden" name="id" value="${e.id}"></br>
                            选择部门：
                            <select name="dept" id="dept">
                                <option value="-1">--请选择--</option>
                            </select>
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            选择岗位：
                            <select name="id" id="job">
                                <option value="-1">--请选择--</option>
                            </select>
                            <input type="submit" value="换岗"></br>
                        </form>
                    </div>
                </c:if>
            </c:forEach>
        </c:forEach>
    </c:forEach>
</table>
</body>
</html>
