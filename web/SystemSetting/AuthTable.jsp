<%@ page contentType="text/html;charset=UTF-8" %>
<html>

<head>
    <meta charset="utf-8">
    <title>酒店管理系统</title>
    <link rel="stylesheet" href="../js/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="../MAIN/component/font-awesome-4.7.0/css/font-awesome.min.css">
    <script src="../js/layui/layui.js"></script>
    <script src="../js/jquery.js"></script>
    <script src="../js/global.js"></script>
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
            <input class="layui-input" id="AuthITEM" placeholder="权限名称">
        </div>
        <button class="layui-btn fa fa-search" id="searchAuthITEM"> 搜索</button>
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

<%--方法级渲染表格--%>
<table id="tableAuth"></table>


<script type="text/html" id="barAuth">
    <a class="layui-btn layui-btn-primary layui-btn-mini" lay-event="detail">查看</a>
    <a class="layui-btn layui-btn-mini" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-mini" lay-event="del">删除</a>
</script>

<script>
    layui.use('table', function () {
        $(document).ready(function () {
            //自动初始化表格
            var table = layui.table;

            //方法级渲染
            var tableIns = table.render({
                elem: '#tableAuth'  //绑定元素
                , id: 'tableAuth'  //表格容器索引
                , url: baseUrl + '/QueryAuthInfoServlet' //数据接口
                , cols: [[  //表头
                    //field字段名、title标题名、width列宽、sort排序、fixed固定列、toolbar绑定工具条
                    {field: 'authId', title: 'ID', width: 80, sort: true, fixed: true}
                    , {field: 'authItem', title: '权限名称', width: 190}
                    , {field: 'isRead', title: '可读', width: 105}
                    , {field: 'isWrite', title: '可写', width: 105}
                    , {field: 'isChange', title: '可改', width: 105}
                    , {field: 'isDelete', title: '可删', width: 105}
                    , {field: 'right', title: '管理', align: 'center', toolbar: '#barAuth', width: 200}

                ]]
                , page: true  //是否开启分页
                , where: {
                    make: 1 //make,此值将传入到servlet，根据值判断当前需要从后端获取的内容
                }
            });

            //监听工具条
            table.on('tool', function (obj) { //tool是工具条事件名
                var data = obj.data //获得当前行数据
                    , layEvent = obj.event; //获得 lay-event 对应的值
                if (layEvent === 'detail') {
                    layer.msg('查看操作' + data.authItem);
                } else if (layEvent === 'del') {
                    layer.alert('本条目禁止删除！',
                        {
                            title: '警告',
                            icon: 4,
                            anim: 6,
                            offset: '250px'  //保持水平，自顶部向下偏移250像素
                        });
                } else if (layEvent === 'edit') {

                }
            });

            //刷新
            $('#refresh').click(function () {
                layer.msg('重载表格', {offset: '250px'});
                tableIns.reload({where: {make: 1}});
            });

            //搜索权限项目
            $('#searchAuthITEM').click(function () {
                var authItem = $('#AuthITEM').val();
                if (authItem == "")
                    layer.msg('您必须输入值', {offset: '250px'});
                else if (authItem.length > 10)
                    layer.msg('您所输入的值长度不合法', {offset: '250px'});
                else {
                    layer.msg('搜索结果', {offset: '250px'});
                    //与tableIns.reload方法类似，这种方法是取表格容器索引值
                    table.reload('tableAuth', {
                        where: {
                            make: 2,
                            authItem: authItem
                        }
                    })
                }

            });
        });
    });
</script>


</body>

</html>