<%@ page contentType="text/html;charset=UTF-8" %>
<html>

<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="../js/layui/css/layui.css" media="all">
    <script src="../js/layui/layui.js"></script>
    <script src="../js/jquery.js"></script>
    <script src="../js/global.js"></script>
    <style>
        .fixDiv {
            position: sticky;
            bottom: 0;
            background-color: white;
            BORDER-BOTTOM: #e1e1e1 1px solid;
            BORDER-TOP: #e1e1e1 1px solid;
            BORDER-RIGHT: #e1e1e1 1px solid;
            BORDER-LEFT: #e1e1e1 1px solid;
            border-radius: 10px
        }
    </style>
</head>

<body>
<table id="dataTable" class='layui-table'>
    <tr>
        <th>入住单号</th>
        <th>客房价格</th>
        <th>折扣</th>
        <th>入住时长</th>
        <th>预收款</th>
        <th>应收款</th>
    </tr>
</table>
<div class="fixDiv">
    <label class="layui-form-label">当前选中：</label>
    <div class="layui-input-inline">
        <input type="text" id="checkId" class="layui-input" placeholder="入住单号" readonly>
    </div>
    <div class="layui-input-inline">
        <input type="text" id="price" class="layui-input" placeholder="客房价格" readonly>
    </div>
    <div class="layui-input-inline">
        <input type="text" id="discount" class="layui-input" placeholder="折扣" readonly>
    </div>
    <div class="layui-input-inline">
        <input type="text" id="orderMoney" class="layui-input" placeholder="预收款" readonly>
    </div>
    <div class="layui-input-inline">
        <input type="text" id="money" class="layui-input" placeholder="应收款" readonly>
    </div>
</div>

<script>
    //网页加载完毕
    $(document).ready(function () {

        //发出ajax请求，调用后端数据
        $.getJSON(baseUrl + '/selectCheckinServlet', function (data) {

            //遍历响应的json数组
            $.each(data, function (index, el) {
                var checkId = el.checkId;
                var price = el.price;
                var discount = el.discount;
                var orderMoney = el.orderMoney;
                var money = el.money;
                var remark = el.remark;
                var html = '';
                html += '<tr onclick="checkId.value= \'' + checkId + '\',price.value=\'' + price + '\' ,discount.value=\'' + discount + '\',orderMoney.value=\'' + orderMoney + '\',money.value=\'' + money + '\'" >';
                html += '	<td>' + checkId + '</td>';
                html += '	<td>' + price + '</td>';
                html += '	<td>' + discount + '</td>';
                html += '	<td>' + remark + '</td>';
                html += '	<td>' + orderMoney + '</td>';
                html += '	<td>' + money + '</td>';
                html += '</tr>';

                //追加到表格中
                $('#dataTable').append(html);

            });

        });
    });
</script>
</body>

</html>