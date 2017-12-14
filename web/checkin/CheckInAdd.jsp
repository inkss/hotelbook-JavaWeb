<%--
  Created by IntelliJ IDEA.
  User: julys
  Date: 17-11-30
  Time: 上午11:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>

<head>
    <meta charset="utf-8">
    <title>入住单</title>
    <link rel="stylesheet" href="../js/layui/css/layui.css" media="all">
    <script src="../js/layui/layui.js"></script>
    <script src="../js/jquery.js"></script>
    <script src="../js/global.js"></script>
    <script src="../js/getTime.js"></script>
    <script src="../js/Cookie.js"></script>
</head>

<body>
<fieldset class="layui-elem-field layui-field-title " style="margin-top: 20px;">
    <legend>酒店管理 - 入住单</legend>
</fieldset>

<form class="layui-form" action="">

    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">入住单号</label>
            <div class="layui-input-block">
                <input type="text"  class="layui-input" id="checkID" placeholder="入住单号">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">入住人</label>
            <div class="layui-input-inline">
                <input type="text" id="checkName" lay-verify="required" autocomplete="off" placeholder="入住人姓名" class="layui-input">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">入住人电话</label>
            <div class="layui-input-inline">
                <input type="tel" id="checkPhone" lay-verify="required|phone" autocomplete="off" placeholder="入住人电话" class="layui-input">
            </div>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">身份证</label>
        <div class="layui-input-block">
            <input type="text" id="checkIDcard" lay-verify="identity" placeholder="入住人身份证号" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">抵店时间</label>
            <div class="layui-input-inline">
                <input type="text" id="arrireDate" lay-verify="date" placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-inline">
            <label class="layui-form-label">离店时间</label>
            <div class="layui-input-inline">
                <input type="text" id="leaveDate" lay-verify="date" placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
            </div>
        </div>

    </div>

    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">房间类型</label>
            <div class="layui-input-inline">
                <select  class="layui-input-inline" id="typeId"  lay-verify="required" autocomplete="off" placeholder="房间类型" class="layui-input">
                    <option value="单人间">单人间</option>
                    <option value="标准间">标准间</option>
                    <option value="大床房">大床房</option>
                    <option value="家庭房">家庭房</option>
                </select>
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">客房价格</label>
            <div class="layui-input-inline">
                <input type="text" id="price" lay-verify="number" autocomplete="off" placeholder="￥" class="layui-input">
            </div>
        </div>

    </div>


    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">预收账款</label>
            <div class="layui-input-inline">
                <input type="text" id="orderMoney" lay-verify="required|number" autocomplete="off" placeholder="￥" class="layui-input">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">应收账款</label>
            <div class="layui-input-inline">
                <input type="text" id="ifCheckout" lay-verify="required|number" autocomplete="off" placeholder="￥" class="layui-input">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">结账金额</label>
            <div class="layui-input-inline">
                <input type="text" id="checkMoney" lay-verify="required|number" autocomplete="off" placeholder="￥" class="layui-input">
            </div>
        </div>

    </div>

    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="insertRome">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>

<script>
    //layui的form表单默认的submit提交是真的不会用。
    //以JSON对象传递给后台的话，在传递前无法对数据二次修改。
    //所以就变成了整体传递过去，后端再解析JSON，但是解析时字段为空就又出错。
    //具体起来就是类似房间类型-新增房间那部分，全部字段强制要求全给，后端又set个别字段。
    //所以本文的提交就默认老老实实用ajax提交出去，不采用JSON对象了。

    layui.use(['form', 'layedit', 'laydate'], function() {
        var form = layui.form,
            layer = layui.layer;
            layedit = layui.layedit,
            laydate = layui.laydate;

        //设置ID（读取的时间）
        laydate.render({
            elem: '#arrireDate'
        });
        laydate.render({
            elem: '#leaveDate'
        });
        laydate.render({
            elem: '#orderAllTime',
            type: 'datetime',
            min: 0,
            range: '|',
            format: 'yyyy-MM-dd',
            calendar: true
        });

        //设置ID（读取的时间）
        var time = new Date().getTime();
        $(document).ready(function() {
            $("#orderId").val("OD" + time);
        });

        //房间类型的选择
        $('#buttonTypeId').on('click', function() {
            layer.open({
                type: 2,
                title: '请选择房间类型',
                btn: ['确定', '取消'],
                area: ['880px', '440px'],
                fixed: form,
                content: './selectRoomType.jsp',
                yes: function(index, layero) {
                    typeId.value = $(layero).find('iframe')[0].contentWindow.tId.value; //将子窗口中的 tId 抓过来
                    price.value = $(layero).find('iframe')[0].contentWindow.tPrice.value;
                    layer.close(index); //关闭弹窗
                },
                btn2: function(index) {
                    layer.close(index);
                },
                success: function(layero, index) {
                    var obj = $(layero).find('iframe')[0].contentWindow;
                }
            });
        });

        //监听提交
        form.on('submit(insertRome)', function(data) {

            //先获取值
            var checkID = $('#checkID').val();
            var checkName = $('#checkName').val();
            var checkPhone = $('#checkPhone').val();
            var checkIDcard = $('#checkIDcard').val();
            var arrireDate = $('#arrireDate').val();
            var leaveDate  = $('#leaveDate').val();
            var typeId = $('#typeId').val();

            var price = $('#price').val();
            var checkMoney = $('#checkMoney').val();
            var ifCheckout = $('#ifCheckout').val();
            var orderMoney = $('#orderMoney').val();

            var params = "checkID=" + checkID + "&checkName=" + checkName + "&checkPhone=" + checkPhone +
                "&checkIDcard=" + checkIDcard + "&arrireDate=" + arrireDate  +
                "&leaveDate=" + leaveDate + "&typeId=" + typeId + "&price=" + price +
                "&checkMoney=" + checkMoney + "&ifCheckout=" + ifCheckout +
                "&orderMoney=" + orderMoney ;

           $.post(baseUrl + '/InsertOrderInfoServlet', params, function(data) {
                if (data === '1') {
                    layer.alert('入住单登记成功！', {
                        title: '新增成功',
                        icon: 6,
                        shade: 0.6 ,
                        anim: 3,
                        offset: '220px'
                    });
                }else if (data === '0') {
                    layer.alert('存在相同字段！', {
                        title: '新增失败',
                        icon: 5,
                        shade: 0.6 ,
                        anim: 6,
                        offset: '220px'
                    });
                } else {
                    layer.alert('入住单登记失败！', {
                        title: '新增失败',
                        icon: 2,
                        shade: 0.6 ,
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
