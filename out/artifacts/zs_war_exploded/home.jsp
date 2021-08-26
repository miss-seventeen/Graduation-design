<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2020/10/24
  Time: 18:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>home</title>
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
        <li  class="dropdown" id="profile-messages" ><a title="" href="#" data-toggle="dropdown" data-target="#profile-messages" class="dropdown-toggle"><i class="icon icon-user"></i> <img src="img/${userses.uimg}" style="height: 20px;width:20px;"/> <span class="text">欢迎${userses.uname}</span><b class="caret"></b></a>

        </li>

        <li class=""><a title="" href="login.html"><i class="icon icon-share-alt"></i> <span class="text">退出</span></a></li>
    </ul>
</div>
<!--close-top-Header-menu-->
<!--start-top-serch-->
<%--<div id="search">
    <input type="text" placeholder="输入搜索内容..."/>
    <button type="submit" class="tip-bottom" title="Search"><i class="icon-search icon-white"></i></button>
</div>--%>
<!--close-top-serch-->
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
                <li><form action="importFamlly" method="post">
                    请选择家庭文件:<input type="file" name="filename">
                    <input type="submit" style="background-color: #0e90d2" value="导入">
                </form></li>
                <li><form action="importBig" method="post">
                    请选择大类文件:<input type="file" name="filename">
                    <input type="submit"  style="background-color: #0e90d2" value="导入">
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
    <div class="container-fluid">
        <div class="quick-actions_homepage" >
            <ul class="quick-actions">
                <li>

                    <h1>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp欢迎来到家庭财务管理系统!&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</h1>

                </li>

                    <li class="bg_lo span3"> <a href="allFamlly?id=2"><i class="icon-th-list"></i>家庭表</a> </li>
                    <li class="bg_ly"> <a href="bigListPage"> <i class="icon-th-list"></i> 大类表</a> </li>

                    <li class="bg_lg span3"> <a href="smallListPage"> <i class="icon-th-list"></i> 小类表</a> </li>
                    <li class="bg_lb"> <a href="recordListPage"> <i class="icon-th-list"></i> 记录表</a> </li>

            </ul>
        </div>
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
