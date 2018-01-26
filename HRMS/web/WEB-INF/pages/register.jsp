<%--
  Created by IntelliJ IDEA.
  User: 刘广兴1
  Date: 2018/1/26
  Time: 13:19
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
        #d1{
            margin-top:150px;
            margin-left: 500px;
            color: red;
            font-size: 20px;
            font-weight: bold;
        }
        body {
            width: 100%;
            height:100%;
            font-family: 'Open Sans', sans-serif;
            background-image: url('../../image/demo-1-bg.jpg');
            background-size:cover ;
        }
    </style>
    <script src="js/jquery-3.1.0.js"></script>
    <script>
        $(function () {
            $("#name").blur(function () {
                var uname = $("#name").val();
                if (uname==null||""==uname){
                    $("#sp1").html("×");
                    $("#sp1").css("color","red");
                }else{
                    $.ajax({
                        type:"post",
                        url:"checkName",
                        data:"name="+$(this).val(),
                        success:function (data) {
                            $("#sp1").html(data);
                            $("#sp1").css("color","red");
                            if (data=="ok"){
                                $("#rs").attr("type","submit");
                            }else{
                                $("#rs").attr("type","button");
                            }
                        }
                    })
                }
            })
        })
    </script>
    <script>
        function check_name() {
            var name=$("#name").val();
            var sp2=$("#sp2");
            var reg=new RegExp(/^[a-z0-9_-]{3,16}$/);
            if(reg.test(name)){
                sp2.html("格式正确");
                return true;
            }
            sp2.html(",但输入格式不正确");
            return false;
        }
        function check_password() {
            var reg=/^[a-z0-9_-]{6,18}$/;
            var password=$("#password").val();
            var reg1=new RegExp("[a-z0-9_-]{6,18}");
            var flag=reg1.test(password);
            if(flag){
                $("#sp3").html("√");
                return true;
            }
            $("#sp3").html("密码格式不正确");
            return false;
        }
        function check_next_password(){
            var password=$("#password").val();
            var next_password=$("#password1").val();
            if (password!=next_password){
                $("#sp4").html("两次输入密码不一致");
                return false;
            }else{
                $("#sp4").html("√");
                return true;
            }
        }
        function check_phone() {
            var phone= $("#phone").val();
            var sp5= $("#sp5");
            var reg=new RegExp(/^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\d{8}$/);
            if(reg.test(phone)){
                sp5.html("√");
                return true;
            }
            sp5.html("手机号码输入不正确");
            return false;
        }
        function check_email() {
            var email= $("#email").val();
            var sp6=$("#sp6");
            var reg=new RegExp(/^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/);
            if(reg.test(email)){
                sp6.html("√");
                return true;
            }
            sp6.html("邮箱输入不正确");
            return false;
        }
        function check_age() {
            var age= $("#age").val();
            var sp7=$("#sp7");
            if(age>0&&age<99){
                sp7.html("√");
                return true;
            }
            sp7.html("请不要瞎输年龄");
            return false;
        }
        function check() {
            if(check_name()&&check_phone()&&check_age()&&check_email()&&check_password()&&check_next_password()){
                return true;
            }
            alert("请输入正确")
            return false;
        }
    </script>
</head>
<body>
<a href="#">退出</a>
    <div id="d1">
        <form action="registerUser" method="post" onsubmit="return check()">
            姓名:<br>
            <input name="name" id="name" onblur="check_name()"><span id="sp1"></span>&nbsp;&nbsp;<span id="sp2"></span><br>
            密码:<br>
            <input name="password"id="password" onblur="check_password()"><span id="sp3"></span><br>
            确认密码:<br>
            <input name="password1" id="password1" onblur="check_next_password()"><span id="sp4"></span><br>
            性别:<br>
            <select name="sex">
                <option value="man">男</option>
                <option value="woman">女</option>
            </select><br>
            年龄:<br>
            <input name="age" id="age" onblur="check_age()"><span id="sp7"></span><br>
            电话号码:<br>
            <input name="phone" id="phone" onblur="check_phone()"><span id="sp5"></span><br>
            邮箱:<br>
            <input type="email" name="email" id="email" onblur="check_email()"><span id="sp6"></span><br>
            <input type="submit" value="注册" id="rs">
        </form>
    </div>
</body>
</html>
