<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>家庭表单</title>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="<%=basePath%>css/bootstrap.min.css" />
    <link rel="stylesheet" href="<%=basePath%>css/bootstrap-responsive.min.css" />
    <link rel="stylesheet" href="<%=basePath%>css/fullcalendar.css" />
    <link rel="stylesheet" href="<%=basePath%>css/matrix-style.css" />
    <link rel="stylesheet" href="<%=basePath%>css/matrix-media.css" />
    <link rel="stylesheet" href="<%=basePath%>css/button.css>" />
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
        <li  class="dropdown" id="profile-messages" ><a title="" href="#" data-toggle="dropdown" data-target="#profile-messages" class="dropdown-toggle"><i class="icon icon-user"></i> <img src="img/${userses.uimg}"style="height: 20px;width:20px;"/> <span class="text">欢迎${userses.uname}</span><b class="caret"></b></a>        </li>
        <%--   <li class=""><a title="" href="#"><i class="icon icon-cog"></i> <span class="text">设置</span></a></li>--%>
        <li class=""><a title="" href="login.html"><i class="icon icon-share-alt"></i> <span class="text">退出</span></a></li>
    </ul>
</div>
<!--close-top-Header-menu-->
<!--start-top-serch-->
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
        <div class="quick-actions_homepage" style="width: 80%;overflow-x: scroll;margin: 40px 0 0 30px;">
            <ul>
       <h3>家庭表单</h3>
                <table id="table" cellspacing="0" cellpadding="2" width="100%" border="1">
                    <tr>
                        <td>&nbsp;家庭编号&nbsp;</td>
                        <td>&nbsp;家庭姓名&nbsp;</td>
                        <%--<td>&nbsp;家庭人数&nbsp;</td>--%>
                        <td colspan="2">&nbsp;&nbsp;用户操作&nbsp;&nbsp;</td>
                    </tr>

                    <!-- for(UserInfo users:listUser) users.getUname() -->
                    <%--<c:forEach items="${allFamlly1}" var="famlly1">--%>
                    <c:forEach items="${allFamlly}" var="famlly">
                        <tr>
                            <td id="f">${famlly.fid}</td>
                            <td><a href="ByName" onclick="return pp()">${famlly.fname}</a></td>
                            <%--<td>${famlly1.uname}</td>--%>
                            <td>
                                <c:if test="${(famlly.fid == user.unum.fid)&&(user.uflag==1)}">
                                    <button><a href="delFamlly?fid=${famlly.fid}"class="button button2">删除</a></button>
                                </c:if></td>

                            <td><c:if test="${(famlly.fid == user.unum.fid)&&(user.uflag==1)}">
                                <button><a href="byIdFamlly?fid=${famlly.fid}">修改</a></button></c:if></td>
                        </tr>
                    </c:forEach><%-- </c:forEach>--%>
                </table>
                <%--<a href="exportUser">导出用户</a><br/>--%>
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
       <script src="js/jquery-3.4.1.min.js"></script>

        <script type="text/javascript">

            function goPage (newURL) {
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
            function pp(){

                alert("您没有权限");
            }
            function ywqx(){
                var a=${user.unum.fid};
                var b=${f};
                alert("HHHHHHHHHHH");
                alert(${f});
                if(a!=b){
                    alert("您没有权限");
                    return false;
                }
                return true;
            }
        </script>
    </div>
</div>
</body>
<script type="text/javascript">

    var tTD; //用来存储当前更改宽度的Table Cell,避免快速移动鼠标的问题

    var table = document.getElementById("table");

    var down = false;

    for (i = 0; i < table.rows[0].cells.length; i++) {

        table.rows[0].cells[i].onmousedown = function () {

            //记录单元格

            tTD = this;

            if (event.offsetX > tTD.offsetWidth - 10) {

                down = true;

                tTD.oldX = event.x;

                tTD.oldWidth = tTD.offsetWidth;

            }

            //记录Table宽度

            table = tTD; while (table.tagName != 'TABLE') table = table.parentElement;

            tTD.tableWidth = table.offsetWidth;

        };

        table.rows[0].cells[i].onmousemove = function () {

            //更改鼠标样式

            if (event.offsetX > this.offsetWidth - 10)

                this.style.cursor = 'col-resize';

            else

                this.style.cursor = 'default';

            //取出暂存的Table Cell

            if (tTD == undefined) tTD = this;

        }

    }



    document.onmouseup = function () {

        if (down) {

            //结束宽度调整

            if (tTD == undefined) tTD = this;

            down = false;

            tTD.style.cursor = 'default';

        }

    };



    document.onmousemove = function () {

        if (down) {

            //调整宽度

            if (down) {

                tTD.style.cursor = 'default';

                if (tTD.oldWidth + (event.x - tTD.oldX) > 0)

                    tTD.width = tTD.oldWidth + (event.x - tTD.oldX);

                //调整列宽

                tTD.style.width = tTD.width;

                tTD.style.cursor = 'col-resize';

                //调整该列中的每个Cell

                table = tTD;

                while (table.tagName != 'TABLE') table = table.parentElement;

                for (i = 0; i < table.rows.length; i++) {

                    table.rows[i].cells[tTD.cellIndex].width = tTD.width;

                }

                //调整整个表

                table.width = tTD.tableWidth + (tTD.offsetWidth - tTD.oldWidth);

                table.style.width = table.width;

            }

        }

    };

</script>
</html>
