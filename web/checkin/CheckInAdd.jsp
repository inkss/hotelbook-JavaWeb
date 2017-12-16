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
    <legend>酒店管理 - 入住单</legend>
</fieldset>

<form class="layui-form">

    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">入住单号</label>
            <div class="layui-input-block">
                <input type="text" class="layui-input" id="checkId" name="checkId" placeholder="入住单号" readonly>
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">入住人</label>
            <div class="layui-input-inline">
                <input type="text" id="checkName" name="checkName" lay-verify="required"
                       autocomplete="off" placeholder="入住人姓名" class="layui-input">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">入住人电话</label>
            <div class="layui-input-inline">
                <input type="tel" id="checkPhone" name="checkPhone" lay-verify="required|phone"
                       autocomplete="off" placeholder="入住人电话" class="layui-input">
            </div>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">身份证</label>
        <div class="layui-input-block">
            <input type="text" id="checkIDcard" name="checkIDcard" lay-verify="required|identity"
                   placeholder="入住人身份证号" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">抵店时间</label>
            <div class="layui-input-inline">
                <input type="text" id="arriveTime" name="arriveTime" lay-verify="required|date"
                       placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input" readonly>
            </div>
        </div>

        <div class="layui-inline">
            <label class="layui-form-label">离店时间</label>
            <div class="layui-input-inline">
                <input type="text" id="leaveTime" name="leaveTime" lay-verify="required|date"
                       placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input" readonly>
            </div>
        </div>

        <div class="layui-inline">
            <label class="layui-form-label">入住人数</label>
            <div class="layui-input-inline">
                <input type="text" id="checkNum" name="checkNum" lay-verify="required|number"
                       autocomplete="off" placeholder="收入入住人数" class="layui-input">
            </div>
        </div>

    </div>

    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">房间类型</label>
            <div class="layui-input-inline">
                <select class="layui-input-inline" id="typeId" name="typeId" lay-verify="required"
                        autocomplete="off" placeholder="房间类型" class="layui-input">
                    <option value="RT171130160554">单人间</option>
                    <option value="RT171203233121">标准间</option>
                    <option value="RT171203233825">大床房</option>
                    <option value="RT171203233828">家庭房</option>
                </select>
            </div>
        </div>

        <div class="layui-inline">
            <label class="layui-form-label">楼层类型</label>
            <div class="layui-input-inline">
                <select class="layui-input-inline" id="floorId" name="floorId" lay-verify="required"
                        autocomplete="off" placeholder="楼层" class="layui-input">
                    <option value="1">一楼</option>
                    <option value="2">二楼</option>
                    <option value="3">三楼</option>
                    <option value="4">四楼</option>
                </select>
            </div>
        </div>

        <div class="layui-inline">
            <label class="layui-form-label">分配房号</label>
            <div class="layui-input-inline">
                <input type="text" id="roomId" name="roomId" lay-verify="required" autocomplete="off"
                       placeholder="房号" readonly
                       class="layui-input">
            </div>
            <div class="layui-input-inline">
                <button class="layui-btn layui-btn-primary" id="buildRoomId">分配</button>
            </div>
        </div>

    </div>

    <div class="layui-form-item">

        <div class="layui-inline">
            <label class="layui-form-label">客房价格</label>
            <div class="layui-input-inline">
                <input type="text" id="price" name="price" lay-verify="number" autocomplete="off"
                       placeholder="￥" class="layui-input">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">入住价格</label>
            <div class="layui-input-inline">
                <input type="text" id="checkPrice" name="checkPrice" lay-verify="number" autocomplete="off"
                       placeholder="￥" class="layui-input">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">折扣</label>
            <div class="layui-input-inline">
                <input type="text" id="discount" name="discount" lay-verify="number" autocomplete="off"
                       placeholder="折扣请输入，无折扣置空" class="layui-input" value="0">
            </div>
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">预收款</label>
            <div class="layui-input-inline">
                <input type="text" id="orderMoney" name="orderMoney" lay-verify="required|number" autocomplete="off"
                       placeholder="￥" class="layui-input">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">应收款</label>
            <div class="layui-input-inline">
                <input type="text" id="money" name="money" lay-verify="number" autocomplete="off"
                       placeholder="￥" class="layui-input">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">单据状态</label>
            <div class="layui-input-inline">
                <select name="checkState" class="layui-input-inline" id="checkState" lay-verify="required">
                    <option value="预定">预定</option>
                    <option value="入住">入住</option>
                    <option value="结算">结算</option>
                    <option value="延期">延期</option>
                </select>
            </div>
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">是否结账</label>
            <div class="layui-input-inline">
                <input type="checkbox" name="isCheck" id="isCheck" lay-skin="switch"
                       lay-text="是|否" lay-verify="required">
            </div>
        </div>

        <div class="layui-inline">
            <label class="layui-form-label">结张金额</label>
            <div class="layui-input-inline">
                <input type="text" id="checkMoney" name="checkMoney" lay-verify="number" autocomplete="off"
                       placeholder="￥" class="layui-input">
            </div>
        </div>

        <div class="layui-inline">
            <label class="layui-form-label">结账日期</label>
            <div class="layui-input-inline">
                <input type="text" id="checkDate" name="checkDate" lay-verify="date"
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
            <button class="layui-btn" lay-submit lay-filter="insertRome">立即提交</button>
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
            elem: '#arriveTime'
        });
        laydate.render({
            elem: '#leaveTime'
        });
        laydate.render({
            elem: '#checkDate'
        });

        //设置ID（读取的时间）
        var time = new Date().getTime();
        $(document).ready(function () {
            $("#checkId").val("CI" + time);
        });

        //分配房号
        $('#buildRoomId').on('click', function () {
            time = new Date().getTime().toString();
            var floor = $("#floorId").val();
            var type = $("#typeId").val();
            var num = time.substring(9);
            $("#roomId").val(floor + num);
            return false;
        });

        //监听提交
        form.on('submit(insertRome)', function (data) {
            $.post(baseUrl + '/InsertCheckinServlet', JSON.stringify(data.field), function (data) {
                if (data === 1) {
                    layer.alert('登记成功！', {
                        title: '新增成功',
                        icon: 6,
                        shade: 0.6,
                        anim: 3,
                        offset: '220px'
                    });
                } else if (data === 0) {
                    layer.alert('存在相同字段！', {
                        title: '新增失败',
                        icon: 5,
                        shade: 0.6,
                        anim: 6,
                        offset: '220px'
                    });
                } else {
                    layer.alert('登记失败！', {
                        title: '新增失败',
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
