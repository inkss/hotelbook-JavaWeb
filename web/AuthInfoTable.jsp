<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <title>酒店管理系统</title>
    <link rel="stylesheet Icon" href="img/windows.ico">
    <link rel="stylesheet" href="./layui/css/layui.css" media="all">
    <style>
        body {
            margin: 10px;
        }
    </style>
</head>
<body>

    <table class="layui-table" lay-data="{height:332, url:'http://localhost:8080/QueryAuthInfoServlet', page:true, id:'idTest'}" lay-filter="demo">
        <thead>
        <tr>
            <th lay-data="{field:'authId', width:80, sort: true, fixed: true}">ID</th>
            <th lay-data="{field:'authItem', width:120}">权限名称</th>
            <th lay-data="{field:'isRead', width:80}">可读</th>
            <th lay-data="{field:'isWrite', width:80}">可写</th>
            <th lay-data="{field:'isChange', width:80}">可改</th>
            <th lay-data="{field:'isDelete', width:80}">可删</th>
        </tr>
        </thead>
    </table>


    <script src="./layui/layui.js"></script>

    <script>
        layui.use('table', function(){
            var table = layui.table;

        });
    </script>

</body>
</html>
