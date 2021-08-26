<%@ page contentType="text/html; charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>注册页面</title>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="<%=basePath%>css/bootstrap.min.css" />
    <link rel="stylesheet" href="<%=basePath%>css/bootstrap-responsive.min.css" />
    <link rel="stylesheet" href="<%=basePath%>css/matrix-login.css" />
    <link href="font-awesome/css/font-awesome.css" rel="stylesheet" />
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,800' rel='stylesheet' type='text/css'>

</head>
<body>
<div id="loginbox">
    <form id="login" class="form-vertical" action="addUser" method="post" enctype="multipart/form-data">
        <div class="control-group normal_text"> <h3><img src="img/logo.png" alt="Logo" /></h3></div>
        <div class="control-group">
            <div class="controls">
                <div class="main_input_box">
                    <span class="add-on bg_lg"><i class="icon-user"></i></span><input type="text" name="uname" placeholder="用户名" id="uname"/>
                </div>
            </div>
        </div>
        <div class="control-group">
            <div class="controls">
                <div class="main_input_box">
                    <span class="add-on bg_ly"><i class="icon-lock"></i></span><input type="password" name="upwd" placeholder="密码" id="upwd"/>
                </div>
            </div>
        </div>
        <div class="control-group">
            <div class="controls">
                <div class="main_input_box">
                    <span class="pull-left"><input class="btn btn-success" value="请选择家庭"></span><select name="unum.fid" class="pull-left">
                    <c:forEach items="${allFamlly}" var="famlly">
                        <option value="${famlly.fid}">${famlly.fname}</option>
                    </c:forEach>
                </select>
                    <br/><input type="password" name="fpwd" placeholder="家庭密钥" id="fpwd"/>
                    </div>
            </div>
        </div>
        <div class="control-group">
            <div class="controls">
                <div class="main_input_box">

                    <input type="file" name="filename" placeholder="注册头像" id="filename"/>
                </div>
            </div>
        </div>
        <div class="form-actions">

            <span class="pull-right"><input type="submit" class="btn btn-success" value="注册" onclick="return bb()"></span>
            <span class="pull-right"><a href="index.jsp" class="btn btn-success">返回登录</a></span>
            <span class="pull-left"><a href="zhuce.jsp" class="btn btn-success" id="to-recover">创建家庭</a></span>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
        </div>

    </form>
</div>

<script src="js/jquery.min.js"></script>
<script src="js/matrix.login.js"></script>
<script type="text/javascript">
    function bb(){
        var uname=document.getElementById("uname").value;
        var upwd=document.getElementById("upwd").value;
        var fpwd=document.getElementById("fpwd").value;
        var filename=document.getElementById("filename").value;
        if(uname==''){
            alert("姓名不能为空");
            return false;
        }else if(upwd==''){
            alert("密码不能为空");
            return false;
        }else if(fpwd==''){
            alert("家庭密钥不能为空");
            return false;
        }else if(filename==''){
            alert("头像不能为空");
            return false;
        }else{
            alert("注册成功");
            return true;
        };
    };
</script>
</body>

</html>
