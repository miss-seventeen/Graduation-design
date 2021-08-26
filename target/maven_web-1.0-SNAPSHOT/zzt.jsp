﻿<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%

    String path = request.getContextPath();

    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>



<!DOCTYPE html>



<head>



    <meta charset="utf-8">



    <title>ECharts</title>

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

<>

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

        <li class=""><a title="" href="home.jsp"><i class="icon icon-share-alt"></i> <span class="text">退出</span></a></li>

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

            </ul

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

    <!-- 为ECharts准备一个具备大小（宽高）的Dom -->



    <div id="main" style="height:400px"></div>

    <div id="container" style="height: 500px"></div>

</div>

<!-- ECharts单文件引入 -->



<script src="http://echarts.baidu.com/build/dist/echarts-all.js"></script>

<script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/echarts.min.js"></script>
</div>

<script type="text/javascript">
    // 基于准备好的dom，初始化echarts图表
    var myChart = echarts.init(document.getElementById('main'));
    var option = {

        title : {
            text: '家庭收支记录图',
        },

        tooltip : {
            trigger: 'axis'
        },

        legend: {
            data:['收入','支出']
        },

        toolbox: {
            show : true,
            feature : {
                mark : {show: true},
                dataView : {show: true, readOnly: false},
                magicType : {show: true, type: ['line', 'bar']},
                restore : {show: true},
                saveAsImage : {show: true}
            }
        },

        calculable : true,
        xAxis : [
            {
                type : 'category',
                data : [
                    <%
                      String tian [] = (String[])request.getAttribute("tian1");
                      int lasts1 = Integer.parseInt(request.getAttribute("tianlength")+"");
                      for(int i = 0 ; i <lasts1 ; i ++){
                          %>
                    '<%=tian[i]%>',
                    <%
                    }
                 %>

                ]   //.....多少天
            }
        ],
        yAxis : [
            {
                type : 'value'
            }
        ],
        series : [
            {
                name:'收入',
                type:'bar',
                data:[
                   <%
                      Double shouru [] = (Double[])request.getAttribute("shouru");
                      int lasts = Integer.parseInt(request.getAttribute("shouruleng")+"")  ;
                      for(int i = 0 ; i <lasts ; i ++){
                          %>
                          <%=shouru[i]%>,
                      <%
                      }
                   %>
                ],  //.....  收入的所有数据
                markPoint : {
                    data : [
                        {type : 'max', name: '最大值'},
                        {type : 'min', name: '最小值'}
                    ]
                },
                markLine : {
                    data : [
                        {type : 'average', name: '平均值'}
                    ]
                }
            },
            {
                name:'支出',
                type:'bar',
                data:[
                    <%
                       Double zhichu [] = (Double[])request.getAttribute("zhichu");
                       int last = Integer.parseInt(request.getAttribute("zhichuleng")+"");
                       for(int i = 0 ; i <last ; i ++){
                           %>
                    <%=zhichu[i]%>,
                    <%
                    }
                 %>
                ], ///...... 支出的所有数据
                markPoint : {
                    data : [
                        {name : '最高', value : "max", xAxis: 7, yAxis: 183, symbolSize:18},
                        {name : '最低', value : "min", xAxis: 11, yAxis: 3}
                    ]
                },
                markLine : {
                    data : [
                        {type : 'average', name : '平均值'}
                    ]
                }
            }
        ]
    };
    myChart.setOption(option);

</script>


<script type="text/javascript">



    var dom = document.getElementById("container");



    var myChart = echarts.init(dom);



    var app = {};







    app.title = '环形图';







    var option = {



        tooltip: {



            trigger: 'item',



            formatter: "{a} <br/>{b}: {c} ({d}%)"



        },



        color:['#5C93D8','#D86570'],



        legend: {



            orient: 'horizontal',



            x: 'left',



            data: ['收入', '支出']



        },



        series: [{



            name: '访问来源',



            type: 'pie',



            radius: ['30%', '70%'],



            avoidLabelOverlap: false,



            label: {



                normal: {



                    show: false,



                    position: 'center'



                },



                emphasis: {



                    show: true,



                    textStyle: {



                        fontSize: '30',



                        fontWeight: 'bold'



                    }



                }



            },



            labelLine: {



                normal: {



                    show: false



                }



            },



            data: [



                {



                    value: ${ab},



                    name: '收入'



                },











                {



                    value: ${abb},



                    name: '支出'



                }



            ]



        }]



    };



    if(option && typeof option === "object") {



        myChart.setOption(option, true);



    }




</script>





</body>
