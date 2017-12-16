<%@ page contentType="text/html;charset=UTF-8" %>
<html>

<head>
    <meta charset="utf-8">
    <title>入住单</title>
    <link rel="stylesheet" href="../js/layui/css/layui.css" media="all">
    <script src="../js/layui/layui.js"></script>
    <script src="../js/jquery.js"></script>
    <script src="../js/global.js"></script>
    <script src="../js/Cookie.js"></script>
</head>

<body>
<fieldset class="layui-elem-field layui-field-title " style="margin-top: 20px;">
    <legend>酒店管理 - 账单结算</legend>
</fieldset>

<form class="layui-form">

    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">入住单号</label>
            <div class="layui-input-inline">
                <input type="text" class="layui-input" id="checkId" name="checkId" placeholder="入住单号" readonly>
            </div>
            <div class="layui-input-inline">
                <button class="layui-btn layui-btn-primary" id="selectCheckId">选择入住单</button>
            </div>
        </div>
    </div>


    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">客房价格</label>
            <div class="layui-input-inline">
                <input type="text" id="price" name="price" lay-verify="required|number" autocomplete="off"
                       placeholder="￥" class="layui-input" readonly>
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">折扣</label>
            <div class="layui-input-inline">
                <input type="text" id="discount" name="discount" lay-verify="required|number" autocomplete="off"
                       placeholder="折扣" class="layui-input" readonly>
            </div>
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">预收款</label>
            <div class="layui-input-inline">
                <input type="text" id="orderMoney" name="orderMoney" lay-verify="required|number" autocomplete="off"
                       placeholder="￥" class="layui-input" readonly>
            </div>
        </div>
        <div class="layui-inline ">
            <label class="layui-form-label">应收款</label>
            <div class="layui-input-inline">
                <input type="text" id="money" name="money" lay-verify="number" autocomplete="off"
                       placeholder="￥" class="layui-input" readonly>
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">单据状态</label>
            <div class="layui-input-inline">
                <select name="checkState" class="layui-input-inline" id="checkState" lay-verify="required">
                    <option value="结算">结算</option>
                    <option value="入住">入住</option>
                    <option value="延期">延期</option>
                </select>
            </div>
        </div>
    </div>

    <div class="layui-form-item ">
        <div class="layui-inline">
            <label class="layui-form-label">是否结账</label>
            <div class="layui-input-inline">
                <input type="checkbox" name="isCheck" checked="" disabled="" id="isCheck" lay-skin="switch"
                       lay-text="是|否" lay-verify="required">
            </div>
        </div>

        <div class="layui-inline">
            <label class="layui-form-label">结账金额</label>
            <div class="layui-input-inline">
                <input type="text" id="checkMoney" name="checkMoney" lay-verify="required|number" autocomplete="off"
                       placeholder="￥" class="layui-input">
            </div>
        </div>

        <div class="layui-inline">
            <label class="layui-form-label">结账日期</label>
            <div class="layui-input-inline">
                <input type="text" id="checkoutDate" name="checkoutDate" lay-verify="required|date"
                       placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input" readonly>
            </div>
        </div>
    </div>

    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">备注</label>
        <div class="layui-input-block">
            <textarea id="remark" name="remark" placeholder="请输入内容" class="layui-textarea"></textarea>
        </div>
    </div>


    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="insertRome">结算</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>


</form>

<script>

    layui.use(['form', 'layedit', 'laydate'], function () {
        var form = layui.form,
            layer = layui.layer,
            layedit = layui.layedit,
            laydate = layui.laydate;

        laydate.render({
            elem: '#checkoutDate'
        });

        //选择
        $('#selectCheckId').on('click', function() {
            layer.open({
                type: 2,
                title: '请选择房间类型',
                btn: ['确定', '取消'],
                area: ['1200px', '600px'],
                fixed: form,
                content: './selectCheckin.jsp',
                yes: function(index, layero) {
                    checkId.value = $(layero).find('iframe')[0].contentWindow.checkId.value;
                    price.value = $(layero).find('iframe')[0].contentWindow.price.value;
                    discount.value = $(layero).find('iframe')[0].contentWindow.discount.value;
                    orderMoney.value = $(layero).find('iframe')[0].contentWindow.orderMoney.value;
                    money.value = $(layero).find('iframe')[0].contentWindow.money.value;
                    layer.close(index); //关闭弹窗
                },
                btn2: function(index) {
                    layer.close(index);
                },
                success: function(layero, index) {
                    var obj = $(layero).find('iframe')[0].contentWindow;
                }
            });
            return false;
        });

        //监听提交
        form.on('submit(insertRome)', function (data) {
            $.post(baseUrl + '/InsertBillInfoServlet', JSON.stringify(data.field), function (data) {
                if (data === 1) {
                    layer.alert('结算成功！', {
                        title: '成功',
                        icon: 6,
                        shade: 0.6,
                        anim: 3,
                        offset: '220px'
                    });
                } else {
                    layer.alert('结算失败！', {
                        title: '失败',
                        icon: 2,
                        shade: 0.6,
                        anim: 6,
                        offset: '220px'
                    });
                }
            });

            return false;
        });

    });
</script>
</body>

</html>
