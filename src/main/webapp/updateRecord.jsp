<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2020/10/27
  Time: 22:09
  To change this template use File | Settings | File Templates.
--%>

<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2020/10/25
  Time: 18:58
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="updateBig" method="post">
    <input type="hidden" name="bid" value="${bigById.bid }">
    修改类名：<input type="text" name="bname" value="${bigById.bname }"> <br/>
    修改类型：<input type="radio"  name="btype" value="0" ${bigById.btype==0?'checked="checked"':''}/>支出
    <input type="radio"  name="btype" value="1" ${bigById.btype==1?'checked="checked"':''}/>收入<br/>
    <input type="submit" value="修改">
</form>
</body>
</html>--%>
<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2020/10/24
  Time: 19:12
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="update" method="post">
    <input type="hidden" name="uid" value="${userById.uid }">
    <input type="hidden" name="uflag" value="${userById.uflag }">
    修改用户名：<input type="text" name="uname" value="${userById.uname }"> <br/>
    修改密码：<input type="text"  name="upwd" value="${userById.upwd }"/><br/>
    修改头像：<input type="text" name="uimg" value="${userById.uimg }"/>
    <input type="submit" value="修改">
</form>
</body>
</html>--%>
<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2020/10/24
  Time: 18:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>修改记录表</title>
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
    <div class="container-fluid">
        <div class="quick-actions_homepage">
            <ul class="quick-actions">
                <form action="updateRecord" method="post">
                    <h3>修改记录单</h3>

                    <input type="hidden" name="rid" value="${byIdRecord.rid}">
                    收支日期：<input type="text" name="rtime" value="${byIdRecord.rtime}"/><br/>
                    金额：&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" name="money" value="${byIdRecord.money}"><br/>
                    谁的收支：<input type="text" name="runame" value="${byIdRecord.runame}"><br/>
                    备注：&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" name="beizhu" value="${byIdRecord.beizhu}"><br/>
                    请选择收支大类：<select id="bigInfo">
                    <option>请选择大类</option>
                    <c:forEach items="${listBig}" var="big">
                        <option value="${big.bid}" ${big.bid==byId.bsid.bid?"selected='selected'":""}>${big.bname}</option>
                    </c:forEach>
                </select>
                    请选择小类：      <select id="smallInfo" name="tt">
                    <c:forEach items="${listSmall}" var="small">
                        <option value="${small.sid}" ${small.sid==byIdRecord.rsid.sid?"selected='selected'":""}>${small.sname}</option>
                    </c:forEach>
                </select>
                    <input type="submit" value="修改">
                </form>
            </ul>
        </div>
    </div>
</div>
</body>
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

        <script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>

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

            $(function(){
                $("#bigInfo").change(function(){
                    var val=$(this).val();
                    $("#smallInfo").html();
                    var str="";
                    $.get("recorddy",{value:val},function(data){
                        var obj = eval("("+data+")");
                        $.each(obj,function(key,value){
                            str+="<option value='"+value.sid+"'>"+value.sname+"</option>";
                        });
                        $("#smallInfo").html(str);

                    });

                });
            });
        </script>


</html>
