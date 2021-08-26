<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%--
<html>
<body>
<h2>Hello World!</h2>
<form action="login" method="post">
    登录名字:<input type="text" name="uname"><br>
    登录密码:<input type="password" name="upwd"><br>
    <input type="submit" value="登录">
</form>
</body>
</html>
--%>
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
    <form id="login" class="form-vertical" action="addFamlly" method="post">
        <div class="control-group normal_text"> <h3><img src="img/logo.png" alt="Logo" /></h3></div>
        <div class="control-group">
            <div class="controls">
                <div class="main_input_box">
                    <span class="add-on bg_lg"><i class="icon-lock"></i></span><input type="text" name="fname" placeholder="创建家庭" />
                </div>
            </div>
        </div>
        <div class="control-group">
            <div class="controls">
                <div class="main_input_box">
                    <span class="add-on bg_ly"><i class="icon-lock"></i></span><input type="text" name="fpwd" placeholder="家庭密钥" />
                </div>
            </div>
        </div>
        <div class="form-actions">
            <span class="pull-right"><a href="index.jsp" class="btn btn-success" id="to-recover">返回登录</a></span>
        </div>
        <div class="form-actions">
            <span class="pull-right"><input type="submit" class="btn btn-success" value="注册"></span>
        </div>
    </form>
</div>

<script src="js/jquery.min.js"></script>
<script src="js/matrix.login.js"></script>
</body>

</html>
