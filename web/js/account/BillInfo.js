/**
 * 参照公共模板而写
 */

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
            , url: baseUrl + ''  // <--------------------------------待修改：数据接口
            , cols: [[
                {field: 'billId', title: '账单编号', width: 105, sort: true, fixed: true}
                , {field: 'checkedId', title: '入住单号', width: 190}
                , {field: 'costMoney', title: '消费金额', width: 105}
                , {field: 'costDate', title: '消费时间', width: 105}
                , {field: 'remark', title: '可超预定数', width: 105}
                , {field: 'right', title: '备注', align: 'center', toolbar: '#barAuth', width: 200}

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

            var typeId = data.typeId;
            var typeName = data.typeName;
            var price = data.price;
            var splicPrice = data.splicPrice;
            var exceedance = data.exceedance;
            var isSplice = data.isSplice;

            if (layEvent === 'detail') {
                //查看


            } else if (layEvent === 'del') {
                //删除


            } else if (layEvent === 'edit') {
                //编辑

            }
        });

        //搜索
        $('#searchButton').click(function () {
            var inputTxt = $('#inputSearch').val();
            if (inputTxt == "")
                layer.msg('您必须输入值', {offset: '250px'});
            else if (inputTxt.length > 10)             // <-----------------------------模板修改：修改搜索框的长度
                layer.msg('您所输入的值长度不合法', {offset: '250px'});
            else {
                layer.msg('搜索结果', {offset: '250px'});

            }
        });

        //刷新
        $('#refreshButton').click(function () {
            layer.msg('重载表格', {offset: '250px'});
            tableIns.reload({where: {make: 0}});
        });

        //新增
        $('#insertButton').click(function () {

        });

        //导出
        $('#toXlsButton').click(function () {
            tableIns.reload({where: {make: 0, limit: countNum}});
            layer.prompt({
                title: '请输入文件名称',
                formType: 0,
                offset: '220px'
            }, function (fileName, index) {
                layer.close(index);
                export_table_to_excel('toxlsTable', fileName);
                layer.alert('当前页面数据导出完成！', {
                    title: '导出成功', icon: 6, anim: 1, offset: '250px'
                });
                tableIns.reload({where: {make: 0}});
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