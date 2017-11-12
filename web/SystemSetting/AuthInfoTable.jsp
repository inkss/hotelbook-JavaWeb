<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <title>酒店管理系统</title>
    <link rel="stylesheet Icon" href="../img/windows.ico">
    <link rel="stylesheet" href="../js/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="../MAIN/component/font-awesome-4.7.0/css/font-awesome.min.css">
    <style>
        body {
            margin: 10px;
        }
    </style>
</head>
<body>
<div>
    <div class="layui-inline">
        <div class="layui-input-inline">
            <input class="layui-input" placeholder="权限ID">
        </div>
        <button class="layui-btn fa fa-search"> 搜索</button>
    </div>
    <div class="layui-inline">
        <div class="layui-input-inline">
            <input class="layui-input" placeholder="权限名称">
        </div>
        <button class="layui-btn fa fa-search"> 搜索</button>
    </div>
    <div class="layui-inline">
        <button class="layui-btn fa fa-refresh"> 刷新</button>
    </div>
    <div class="layui-inline">
        <button class="layui-btn fa fa-pencil-square-o"> 新增</button>
    </div>
    <div class="layui-inline">
        <button class="layui-btn fa fa-save"> 导出</button>
    </div>
</div>
<div class="layui-row">
    <table class="layui-table"
           lay-data="{height:500, url:'http://localhost:8080/QueryAuthInfoServlet', page:true, id:'idTest'}">
        <thead>
        <tr>
            <th lay-data="{field:'authId', width:80, sort: true, fixed: true}">ID</th>
            <th lay-data="{field:'authItem', width:200}">权限名称</th>
            <th lay-data="{field:'isRead', width:105}">可读</th>
            <th lay-data="{field:'isWrite', width:105}">可写</th>
            <th lay-data="{field:'isChange', width:105}">可改</th>
            <th lay-data="{field:'isDelete', width:105}">可删</th>
            <th lay-data="{fixed: 'right', width:200, align:'center', toolbar: '#barDemo'}">管理</th>
        </tr>
        </thead>
    </table>
</div>

<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-primary layui-btn-mini" lay-event="detail">查看</a>
    <a class="layui-btn layui-btn-mini" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-mini" lay-event="del">删除</a>
</script>

<script src="../js/layui/layui.js"></script>

<script>
    layui.use('table', function () {

        //自动初始化表格
        var table = layui.table;

    });
</script>

</body>
</html>
