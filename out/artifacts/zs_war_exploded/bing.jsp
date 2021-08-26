<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

</head>
<body style="height: 100%; margin: 0">

<div id="container" style="height: 100%"></div>

<script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/echarts.min.js"></script>

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

                    value: 310,

                    name: '收入'

                },





                {

                    value: 1548,

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
</html>
