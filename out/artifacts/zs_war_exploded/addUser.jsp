<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>添加用户</title>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="<%=basePath%>css/bootstrap.min.css" />
    <link rel="stylesheet" href="<%=basePath%>css/bootstrap-responsive.min.css" />
    <link rel="stylesheet" href="<%=basePath%>css/fullcalendar.css" />
    <link rel="stylesheet" href="<%=basePath%>css/matrix-style.css" />
    <link rel="stylesheet" href="<%=basePath%>css/matrix-media.css" />
    <link href="font-awesome/css/font-awesome.css" rel="stylesheet" />
    <link rel="stylesheet" href="<%=basePath%>css/jquery.gritter.css" />
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,800' rel='stylesheet' type='text/css'>
</head>
<body>

<!--Header-part-->
<div id="header">
    <h1><a href="dashboard.html">MatAdmin</a></h1>
</div>
<!--close-Header-part-->
<!--top-Header-menu-->
<div id="user-nav" class="navbar navbar-inverse">
    <ul class="nav">
        <li  class="dropdown" id="profile-messages" ><a title="" href="#" data-toggle="dropdown" data-target="#profile-messages" class="dropdown-toggle"><i class="icon icon-user"></i> <img src="img/${userses.uimg}"style="height: 20px;width:20px;"/> <span class="text">欢迎${userses.uname}</span><b class="caret"></b></a>
        </li>

        <li class=""><a title="" href="login.html"><i class="icon icon-share-alt"></i> <span class="text">退出</span></a></li>
    </ul>
</div>

<!--sidebar-menu-->
<div id="sidebar"><a href="#" class="visible-phone"><i class="icon icon-home" ></i> 控制台</a>

    <ul>
        <li class="active"><a href="home.jsp"><i class="icon icon-home"></i> <span>首页</span></a> </li>
        <li class="submenu"> <a href="#"><i class="icon icon-th-list"></i> <span>家庭表</span> </a>
            <ul>
                <li><a href="allFamlly?id=2">所有家庭信息</a></li>
            </ul>
        </li>
        <li class="submenu"> <a href="#"><i class="icon icon-th-list"></i> <span>大类表</span> </a>
            <ul>
                <li><a href="bigListPage">所有大类信息</a></li>
                <li><a href="addBig.jsp">添加大类</a></li>
            </ul>
        </li>
        <li class="submenu"> <a href="#"><i class="icon icon-th-list"></i> <span>小类表</span> </a>
            <ul>
                <li><a href="smallListPage">所有小类信息</a></li>
                <li><a href="allBi">添加小类</a></li>
            </ul>
        </li>
        <li class="submenu"> <a href="#"><i class="icon icon-th-list"></i> <span>记录表</span> </a>
            <ul>
                <li><a href="recordListPage">所有记录表信息</a></li>
                <li><a href="recordAdd">添加记录</a></li>
            </ul>
        </li>
        <li class="submenu"> <a href="#"><i class="icon icon-th-list"></i> <span>添加源文件</span> </a>
            <ul>
                <li><form action="importUser" method="post">
                    请选择用户文件:<input type="file" name="filename">
                    <input type="submit" value="导入">
                </form></li>
                <li><form action="importBig" method="post">
                    请选择大类文件:<input type="file" name="filename">
                    <input type="submit" value="导入">
                </form></li>
            </ul>
        </li>


    </ul>
</div>
<!--sidebar-menu-->

<!--main-container-part-->
<div id="content">
    <!--breadcrumbs-->
    <div id="content-header">
        <div id="breadcrumb"> <a href="home.jsp" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> 首页</a></div>
    </div>
    <!--End-breadcrumbs-->

    <!--Action boxes-->
    <form action="addUser" method="post" enctype="multipart/form-data">
    <div class="container-fluid">
        <div class="quick-actions_homepage">
            <ul>
                <li>
                          <h3>添加用户</h3>
                        注册用户名：<input type="text" name="uname"> <br/>
                        注册密码：<input type="text"  name="upwd"/><br/>
                        你的家庭：
                        注册头像：<input type="file" name="filename"/>
                        <input type="submit" value="注册">
                </li>
            </ul>
        </div></div>
    </form>
        <!--End-Action boxes-->
        <!--end-main-container-part-->
        <!--Footer-part-->
        <!--end-Footer-part-->

        <script src="js/excanvas.min.js"></script>
        <script src="js/jquery.min.js"></script>
        <script src="js/jquery.ui.custom.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.flot.min.js"></script>
        <script src="js/jquery.flot.resize.min.js"></script>
        <script src="js/jquery.peity.min.js"></script>
        <script src="js/fullcalendar.min.js"></script>
        <script src="js/matrix.js"></script>
        <script src="js/matrix.dashboard.js"></script>
        <script src="js/jquery.gritter.min.js"></script>
        <script src="js/matrix.interface.js"></script>
        <script src="js/matrix.chat.js"></script>
        <script src="js/jquery.validate.js"></script>
        <script src="js/matrix.form_validation.js"></script>
        <script src="js/jquery.wizard.js"></script>
        <script src="js/jquery.uniform.js"></script>
        <script src="js/select2.min.js"></script>
        <script src="js/matrix.popover.js"></script>
        <script src="js/jquery.dataTables.min.js"></script>
        <script src="js/matrix.tables.js"></script>

        <script type="text/javascript">
            // This function is called from the pop-up menus to transfer to
            // a different page. Ignore if the value returned is a null string:
            function goPage (newURL) {

                // if url is empty, skip the menu dividers and reset the menu selection to default
                if (newURL != "") {

                    // if url is "-", it is this page -- reset the menu:
                    if (newURL == "-" ) {
                        resetMenu();
                    }
                    // else, send page to designated URL
                    else {
                        document.location.href = newURL;
                    }
                }
            }

            // resets the menu selection upon entry to this page:
            function resetMenu() {
                document.gomenu.selector.selectedIndex = 2;
            }
        </script>
    </div>
</div>
</body>
</html>
