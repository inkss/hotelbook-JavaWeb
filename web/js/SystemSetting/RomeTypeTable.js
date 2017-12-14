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
            , url: baseUrl + '/RoomTypeServlet'
            , cols: [[
                {field: 'typeId', title: 'ID', width: 80, sort: true, fixed: true}
                , {field: 'typeName', title: '类型名称', width: 190}
                , {field: 'price', title: '价格', width: 105}
                , {field: 'splicPrice', title: '拼房价格', width: 105}
                , {field: 'exceedance', title: '可超预定数', width: 105}
                , {field: 'isSplice', title: '是否可拼房', width: 105}
                , {field: 'right', title: '管理', align: 'center', toolbar: '#barAuth', width: 200}

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
                layer.alert('ID：' + typeId
                    + '<br>类型名称：' + typeName
                    + '<br>价格：' + price
                    + '<br>拼房价格：' + splicPrice
                    + '<br>可超预定数：' + exceedance
                    + '<br>是否可拼房：' + isSplice
                    , {
                        skin: 'layui-layer-lan'
                        , closeBtn: 0
                        , title: '您当前选择的房间类型信息'
                        , anim: 4
                        , offset: '180px'
                    });
            } else if (layEvent === 'del') {
                //删除

                layer.confirm('您确定要删除该条数据吗？', {
                    offset: '180px',
                    btn: ['是滴', '手滑'] //按钮
                }, function () {
                    table.reload('tableID', {
                        where: {make: 4, typeId: typeId}

                    });
                    layer.msg('删除结果如下', {offset: '250px', icon: 1});
                }, function () {
                    layer.msg('删除操作已取消', {offset: '250px'});
                });

            } else if (layEvent === 'edit') {                    // <--------------------------------模板修改：编辑按钮
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
                //与tableIns.reload方法类似，这种方法是取表格容器索引值
                table.reload('tableID', {
                    where: {
                        make: 3,
                        typeName: inputTxt
                    }
                })
            }
        });

        //刷新
        $('#refreshButton').click(function () {
            layer.msg('重载表格', {offset: '250px'});
            tableIns.reload({where: {make: 0}});
        });

        //新增
        $('#insertButton').click(function () {
            layer.open({
                title: "新增",
                type: 2,
                area: ['780px', '450px'],
                fixed: false, //不固定
                maxmin: true,
                content: '/SystemSetting/insertRomeType.jsp'
            });
        });

        //导出
        $('#toXlsButton').click(function () {
            tableIns.reload({where: {make: 0, limit: countNum}});
            layer.prompt({
                title: '请输入文件名称',
                formType: 0,
                value: 'RomeType',
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