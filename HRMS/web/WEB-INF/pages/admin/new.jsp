<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 刘广兴1
  Date: 2018/2/2
  Time: 14:40
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
            $("#dept").change(function () {
                var did=$(this).val()
                $.ajax({
                    url:"listPostByDeptId",
                    data:{"did":did},
                    javaType:"json",
                    success:function (positions) {
                        $("#post").empty()
                        var p=eval(positions)
                        var str="";
                        $.each(positions,function (index,value) {
                            str+="<option value="+value.id +">"+value.name +"</option>"
                        })
                        $("#post").append(str)
                    }
                })
            })
        })
    </script>
</head>
<body>
<form action="updateEmployee" method="post">
    部门：<select id="dept">
            <option value="0">请选择</option>
            <c:forEach items="${depts}" var="dp">
                <option value="${dp.did}">${dp.dname}</option>
            </c:forEach>
        </select><br>
    职位：<select id="post" name="pid">
                <option value="0">请选择</option>
            </select>
    <input type="hidden" value="${sessionScope.eid}" name="eid">
    <input type="submit" value="更改">
</form>
</body>
</html>
