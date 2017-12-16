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
    <script src="../js/toExcel/xlsx.full.min.js"></script>
    <script type="text/javascript" src="../js/toExcel/FileSaver.js"></script>
    <script type="text/javascript" src="../js/toExcel/Export2Excel.js"></script>
    <style>
        body {
            margin: 10px;
        }

        .layui-elem-field legend {
            font-size: 14px;
        }

        .layui-field-title {
            margin: 25px 0 15px;
        }
    </style>
</head>

<body>

<%--<顶层公共模板>--%>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
    <legend>
        <div>
            <div class="layui-inline">
                <button class="layui-btn fa fa-save" id="toXlsButton"> 导出</button>
            </div>
        </div>
    </legend>
</fieldset>

<div id="toxlsTable">
    <%--方法级渲染表格--%>
    <table id="tableID"></table>
</div>

<script type="text/html" id="barAuth">
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

<script>
    layui.use(['util', 'layer', 'table'], function () {
        $(document).ready(function () {
            var table = layui.table
                , layer = layui.layer
                , util = layui.util;

            var countNum;
            var tableIns = table.render({
                done: function (res, curr, count) {
                    countNum = count;
                }
                , elem: '#tableID'
                , id: 'tableID'
                , url: baseUrl + '/BillInfoServlet'  // <--------------------------------待修改：数据接口
                , cols: [[
                    {field: 'billId', title: '账单编号', width: 200, sort: true, fixed: true}
                    , {field: 'checkId', title: '入住单号', width: 200}
                    , {field: 'costMoney', title: '消费金额', width: 150}
                    , {field: 'costDate', title: '消费时间', width: 150}
                    , {field: 'remark', title: '备注'}
                    , {field: 'right', title: '工具', align: 'center', toolbar: '#barAuth', width: 200, fixed: 'right'}

                ]]
                , page: true
                , where: {
                    make: 0
                }
            });

            //监听工具条
            table.on('tool', function (obj) {
                var data = obj.data
                    , layEvent = obj.event;
                var billId = data.billId;

                if (layEvent === 'del') {
                    //删除
                    layer.confirm('您确定要删除该条数据吗？', {
                        offset: '180px',
                        btn: ['是滴', '手滑']
                    }, function () {
                        table.reload('tableID', {
                            where: {
                                make: 1,
                                billId: billId
                            }
                        });
                        layer.msg('删除结果如下', {
                            offset: '250px',
                            icon: 1
                        });
                        tableIns.reload({
                            where: {
                                make: 0,
                                page: 1
                            }
                        });
                    }, function () {
                        layer.msg('删除操作已取消', {
                            offset: '250px'
                        });
                    });

                }
            });


            //导出
            $('#toXlsButton').click(function () {
                location.href = baseUrl + '/ToExcelServlet';
                layer.alert('Excel文件生成完成！', {
                    title: '成功',
                    icon: 6,
                    anim: 1,
                    offset: '250px'
                });
            });

            //回到顶端
            util.fixbar({
                showHeight: 2
                , click: function (type) {
                    console.log(type);
                }
            });
        });
    });
</script>


</body>

</html>