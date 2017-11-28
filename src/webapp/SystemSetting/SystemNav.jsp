<%@ page contentType="text/html;charset=UTF-8" %>
<html>

<head>
    <meta charset="utf-8">
    <title>酒店管理系统</title>
    <link rel="stylesheet" href="../js/bootstrap/css/bootstrap.css"/>
    <script src="../js/jquery.js"></script>
    <script src="../js/bootstrap/js/bootstrap.js"></script>

    <style>
        * {
            margin: 0;
            padding: 0;
        }

        body {
            background: #333333;
        }

        .nav-left .list-group-item {
            background: transparent;
            border: none;
            text-align: center;
            font-size: 16px;
            color: #eeeeee;
            letter-spacing: 1px;
            line-height: 35px;
            border-bottom: 1px solid #444444;
        }
    </style>

</head>

<body>

<div class="container-fluid">
    <!--导航菜单-->
    <div class="row">
        <div class="list-group nav-left">
            <a href="AuthTable.jsp" target="content" class="list-group-item">权限管理</a>
            <a href="FloorTable.jsp" target="content" class="list-group-item">楼层设置</a>
            <a href="RoomTypeTable.jsp" target="content" class="list-group-item">房间类型</a>
        </div>
    </div>
</div>

</body>

</html>