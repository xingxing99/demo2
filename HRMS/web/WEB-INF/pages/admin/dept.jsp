<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%--
  Created by IntelliJ IDEA.
  User: 刘广兴1
  Date: 2018/1/29
  Time: 14:14
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
        function dept() {
            var r = prompt("请输入部门名称","name");
            if (r!=null&&r!=""){
                $("#dname").val(r);
                return true;
            }else{
                return false;
            }
        }

    </script>
</head>
<body>
${sessionScope.d1}
<form action="addDept" method="post" onsubmit="return dept()">
    <input type="hidden" id="dname" name="dname">
    <input type="submit" value="添加部门">
</form>
<table border="1" cellpadding="1" cellspacing="0">
    <tr>
        <th>部门ID</th>
        <th>部门名称</th>
        <th>部门创建时间</th>
    </tr>
<c:forEach items="${sessionScope.depts}" var="depts">
    <tr>
        <td>${depts.did}</td>
        <td>${depts.dname}</td>
        <td> <fmt:formatDate value="${depts.createTime}"  type="both" dateStyle="full"/></td>
        <td>
            <a href="selectPost?did=${depts.did}">查看部门职位</a>
        </td>
        <td>
            <a href="deleteDept?did=${depts.did}">删除</a>
        </td>
    </tr>
</c:forEach>
</table>
</body>
</html>
