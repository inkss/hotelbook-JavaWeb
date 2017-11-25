<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <title>新增房间类型</title>
    <link rel="stylesheet" href="../js/layui/css/layui.css" media="all">
    <script src="../js/layui/layui.js"></script>
    <script src="../js/jquery.js"></script>
    <script src="../js/global.js"></script>
</head>
<body>


<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>新增房间类型</legend>
</fieldset>

<form class="layui-form" action="">
    <div class="layui-form-item">
        <label class="layui-form-label">类型名称</label>
        <div class="layui-input-block">
            <input type="text" name="typeName" lay-verify="required|typeName" autocomplete="off" placeholder="请输入类型名称"
                   class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">价格</label>
            <div class="layui-input-inline">
                <input type="text" name="price" lay-verify="number" autocomplete="off" placeholder="￥"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">拼房价格</label>
            <div class="layui-input-inline">
                <input type="text" name="splicPrice" lay-verify="number" autocomplete="off" placeholder="￥"
                       class="layui-input">
            </div>
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">可超预定数</label>
            <div class="layui-input-inline">
                <input type="text" name="exceedance" lay-verify="number" autocomplete="off" class="layui-input">
            </div>
        </div>
    </div>

    <%--<div class="layui-form-item">--%>
        <%--<label class="layui-form-label">是否可拼房</label>--%>
        <%--<div class="layui-input-block">--%>
            <%--<input type="checkbox" name="isSplice" lay-skin="switch" value="Y" lay-text="是|否">--%>
        <%--</div>--%>
    <%--</div>--%>

    <div class="layui-form-item">
        <label class="layui-form-label">是否可拼房</label>
        <div class="layui-input-block">
            <input type="radio" name="isSplice" value="Y" title="是" checked="">
            <input type="radio" name="isSplice" value="N" title="否">
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="demo1">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>


<script>
    layui.use(['form', 'layedit', 'laydate'], function () {
        var form = layui.form
            ,layedit = layui.layedit
            , layer = layui.layer;


        //自定义验证规则
        form.verify({
            typeName: function (value) {
                if (value.length < 5) {
                    return '房间类型至少5个字符';
                }

                if (value.length > 10) {
                    return '房间类型至多10个字符'
                }
            }
        });

        //监听提交
        form.on('submit(demo1)', function (data) {
            layer.alert(JSON.stringify(data.field), {
                title: '最终的提交信息'
            });
            return false;
        });


    });
</script>

</body>
</html>
