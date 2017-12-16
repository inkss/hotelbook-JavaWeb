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
    <script src="../js/Cookie.js"></script>
    <style>
        body {
            margin: 10px;
        }

        .layui-elem-field legend {
            font-size: 14px;
        }
    </style>
</head>

<body>

<div id="toxlsTable">
    <table id="tableID"></table>
</div>
<script type="text/html" id="barAuth">
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
<script>
    layui.use(['util', 'layer', 'table'], function () {
        $(document).ready(function () {
            var table = layui.table,
                layer = layui.layer,
                util = layui.util;
            var countNum;
            var tableIns = table.render({
                elem: '#tableID',
                id: 'tableID',
                url: baseUrl + '/CheckinServlet',
                cols: [
                    [{
                        field: 'checkId',
                        title: '入住单号',
                        width: 180,
                        sort: true,
                        fixed: true
                    }, {
                        field: 'checkName',
                        title: '预定人',
                        sort: true,
                        width: 180
                    }, {
                        field: 'checkPhone',
                        title: '预定电话',
                        width: 180
                    }, {
                        field: 'checkIDcard',
                        title: '身份证',
                        width: 200
                    }, {
                        field: 'arriveTime',
                        title: '抵店时间',
                        width: 180
                    }, {
                        field: 'leaveTime',
                        title: '离店时间',
                        width: 180
                    }, {
                        field: 'checkNum',
                        title: '入住人数',
                        width: 100
                    }, {
                        field: 'price',
                        title: '客房价格',
                        width: 100
                    }, {
                        field: 'typeId',
                        title: '房间类型',
                        width: 180
                    }, {
                        field: 'roomId',
                        title: '房号',
                        width: 100
                    }, {
                        field: 'price',
                        title: '客房价格',
                        width: 100
                    }, {
                        field: 'discount',
                        title: '折扣',
                        width: 100
                    }, {
                        field: 'orderMoney',
                        title: '预收款',
                        width: 100
                    }, {
                        field: 'money',
                        title: '应收款',
                        width: 100
                    }, {
                        field: 'checkState',
                        title: '单据状态',
                        sort: true,
                        width: 100
                    }, {
                        field: 'isCheck',
                        title: '是否结账',
                        sort: true,
                        width: 100
                    }, {
                        field: 'checkMoney',
                        title: '结张金额',
                        sort: true,
                        width: 100
                    }, {
                        field: 'checkoutDate',
                        title: '结账日期',
                        sort: true,
                        width: 180
                    }, {
                        field: 'remark',
                        title: '备注',
                        width: 400
                    }, {
                        field: 'right',
                        title: '管理',
                        align: 'center',
                        toolbar: '#barAuth',
                        width: 100,
                        fixed: 'right'
                    }]
                ],
                page: true,
                where: {
                    make: 0
                },
                done: function (res, curr, count) {
                    countNum = count;
                }
            });

            //监听工具条
            table.on('tool', function (obj) {
                var data = obj.data,
                    layEvent = obj.event;
                var checkId = data.checkId;

                if (layEvent === 'del') {
                    layer.confirm('您确定要删除该条数据吗？', {
                        offset: '180px',
                        btn: ['是滴', '手滑']
                    }, function () {
                        table.reload('tableID', {
                            where: {
                                make: 1,
                                checkId: checkId
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


            //回到顶端
            util.fixbar({
                showHeight: 2,
                click: function (type) {
                    console.log(type);
                }
            });
        });
    });
</script>
</body>

</html>