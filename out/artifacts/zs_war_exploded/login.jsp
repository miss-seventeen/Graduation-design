<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2020/10/23
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <script src="js/a.js" type="text/javascript"></script>
    <script src="js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript">
        $(".custome_birthday").focus(function () {
            if ($(this).val() == this.defaultValue)
                $(this).val("");
            WdatePicker({
                el: this,
                readOnly: true,
                dateFmt: "yyyy/MM/dd"
            });
        });
    </script>
</head>

<body>
<input class="custome_birthday" type="date" placeholder="生日">
<input class="custome_birthday" type="date" placeholder="生日">
</body>
</html>
