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
<div class="layui-row">
    <div class="layui-form-item">
        <%--用于将标签设为内联块状元素--%>
        <div class="layui-inline">
            <%--<label class="layui-form-label">验证手机</label>--%>
            <div class="layui-input-inline">
                <input type="tel" name="phone" lay-verify="phone" autocomplete="off" class="layui-input">
            </div>
            <button class="layui-btn" data-type="reload">搜索</button>
        </div>

        <div class="layui-inline">
            <%--<label class="layui-form-label">验证邮箱</label>--%>
            <div class="layui-input-inline">
                <input type="text" name="email" lay-verify="email" autocomplete="off" class="layui-input">
            </div>
            <button class="layui-btn" data-type="reload">搜索</button>
        </div>

        <div class="layui-inline">
            <table class="layui-table"
                   lay-data="{height:332,width:762, url:'http://localhost:8080/QueryAuthInfoServlet', page:true, id:'idTest'}"
                   lay-filter="demo">
                <thead>
                <tr>
                    <th lay-data="{field:'authId', width:60, sort: true, fixed: true}">ID</th>
                    <th lay-data="{field:'authItem', width:160}">权限名称</th>
                    <th lay-data="{field:'isRead', width:65}">可读</th>
                    <th lay-data="{field:'isWrite', width:65}">可写</th>
                    <th lay-data="{field:'isChange', width:65}">可改</th>
                    <th lay-data="{field:'isDelete', width:65}">可删</th>
                </tr>
                </thead>
            </table>

        </div>

    </div>
</div>

<script src="./layui/layui.js"></script>

<script>
    layui.use('table', function () {
        var table = layui.table;

    });
</script>

</body>
</html>
