<%--这个文件是最初写的，对数据表格进行静态初始化，--%>
<%--但是发现这样在对表格进行重载时，操作无法进行下去--%>
<%--所以就采用了动态方法级渲染表格，此文件供参考静待表格的方法。--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>

<head>
    <meta charset="utf-8">
    <title>酒店管理系统</title>
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
    <div class="layui-inline ">
        <div class="layui-input-inline">
            <input class="layui-input" id="authID" placeholder="权限ID">
        </div>
        <button class="layui-btn fa fa-search" data-type="reload"> 搜索</button>
    </div>
    <div class="layui-inline">
        <div class="layui-input-inline">
            <input class="layui-input" placeholder="权限名称">
        </div>
        <button class="layui-btn fa fa-search"> 搜索</button>
    </div>
    <div class="layui-inline">
        <button class="layui-btn fa fa-refresh" id="refresh"> 刷新</button>
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
           lay-data="{height:500, url:'http://localhost:8080/QueryAuthInfoServlet', page:true, id:'tableAuth'}">
        <thead>
        <tr>
            <th lay-data="{field:'authId', width:80, sort: true, fixed: true}">ID</th>
            <th lay-data="{field:'authItem', width:190}">权限名称</th>
            <th lay-data="{field:'isRead', width:105}">可读</th>
            <th lay-data="{field:'isWrite', width:105}">可写</th>
            <th lay-data="{field:'isChange', width:105}">可改</th>
            <th lay-data="{field:'isDelete', width:105}">可删</th>
            <th lay-data="{fixed: 'right', width:200, align:'center', toolbar: '#barAuth'}">管理</th>
        </tr>
        </thead>
    </table>
</div>

<script type="text/html" id="barAuth">
    <a class="layui-btn layui-btn-primary layui-btn-mini" lay-event="detail">查看</a>
    <a class="layui-btn layui-btn-mini" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-mini" lay-event="del">删除</a>
</script>

<script src="../js/layui/layui.js"></script>
<script src="../js/jquery.js"></script>

<script>
    layui.use(['util', 'layer'], function () {
        $(document).ready(function () {

            var table = layui.table;

            //监听工具条
            table.on('tool', function (obj) { //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
                var data = obj.data //获得当前行数据
                    , layEvent = obj.event; //获得 lay-event 对应的值
                if (layEvent === 'detail') {
                    layer.msg('查看操作' + data.authItem);
                } else if (layEvent === 'del') {
                    layer.alert('本条目禁止删除！',
                        {
                            title: '警告',
                            icon: 4,
                            anim: 6

                        });
                } else if (layEvent === 'edit') {

                }
            });

            //刷新
            $('#refresh').click(function () {
                layer.msg('重载表格');
                table.reload('tableAuth');
            });


        });
    });
</script>

</body>

</html>