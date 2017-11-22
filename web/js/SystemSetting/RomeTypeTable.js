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
                        where: {
                            make: 4,
                            typeId: typeId
                        }
                    });
                    layer.msg('删除成功', {offset: '250px', icon: 1});
                }, function () {
                    layer.msg('删除操作已取消', {offset: '250px'});
                });

            } else if (layEvent === 'edit') {                    // <--------------------------------模板修改：编辑按钮
                //编辑
                layer.prompt({ //修改类型
                    title: '请输入类型名称',
                    formType: 0,
                    value: typeName,
                    offset: '220px',
                    maxlength: 30
                }, function (typeName2, index) {
                    var NewTypeName = "typeName=" + typeName2;
                    $.post(baseUrl + '/QueryRoomTypeNameServlet', NewTypeName, function updateCheck(data) {
                        if (data == 1) {
                            layer.close(index);
                            layer.prompt({ //修改价格
                                title: '请输入价格',
                                formType: 0,
                                value: price,
                                offset: '220px',
                                maxlength: 10
                            }, function (price2, index) {
                                if (isNaN(price2)) {
                                    layer.alert('价格必需是整数！', {
                                        title: '警告', icon: 4, anim: 6, offset: '220px'
                                    });
                                } else {
                                    layer.close(index);
                                    layer.prompt({ //修改拼房价格
                                        title: '请输入拼房价格',
                                        formType: 0,
                                        value: splicPrice,
                                        offset: '220px',
                                        maxlength: 10
                                    }, function (splicPrice2, index) {
                                        if (isNaN(splicPrice2)) {
                                            layer.alert('价格必需是整数！', {
                                                title: '警告', icon: 4, anim: 6, offset: '220px'
                                            });
                                        } else {
                                            layer.close(index);
                                            layer.prompt({ //修改可超预定数
                                                title: '请输入可超预定数',
                                                formType: 0,
                                                value: exceedance,
                                                offset: '220px',
                                                maxlength: 1
                                            }, function (exceedance2, index) {
                                                if (isNaN(exceedance2)) {
                                                    layer.alert('价格必需是整数！', {
                                                        title: '警告', icon: 4, anim: 6, offset: '220px'
                                                    });
                                                } else {
                                                    layer.close(index);
                                                    layer.msg('该值请填：Y 、N', {offset: '150px'});
                                                    layer.prompt({ //修改是否可拼房
                                                        title: '请输入是否可拼房',
                                                        formType: 0,
                                                        value: isSplice,
                                                        offset: '220px',
                                                        maxlength: 1
                                                    }, function (isSplice2, index) {
                                                        if (isSplice2 === "Y" || isSplice2 === "N") {
                                                            layer.close(index);
                                                            table.reload('tableID', {
                                                                where: {
                                                                    make: 2,
                                                                    typeId: typeId,
                                                                    typeName: typeName2,
                                                                    price: price2,
                                                                    splicPrice: splicPrice2,
                                                                    exceedance: exceedance2,
                                                                    isSplice: isSplice2
                                                                }
                                                            });
                                                            layer.msg('修改数据成功', {offset: '250px'});
                                                        } else {
                                                            layer.alert('请输入合法类型！', {
                                                                title: '警告', icon: 4, anim: 6, offset: '220px'
                                                            });
                                                        }
                                                    });
                                                }
                                            });
                                        }
                                    });
                                }
                            });
                        } else {
                            layer.alert('该类型名称已经存在！', {
                                title: '警告', icon: 4, anim: 6, offset: '220px'
                            });
                        }
                    });
                });
            }
        });

        //搜索
        $('#searchButton').click(function () {
            var inputTxt = $('#inputSearch').val();
            if (inputTxt == "")
                layer.msg('您必须输入值', {offset: '250px'});
            else if (inputTxt.length > 10)                       // <-----------------------------模板修改：修改搜索框的长度
                layer.msg('您所输入的值长度不合法', {offset: '250px'});
            else {
                layer.msg('搜索结果', {offset: '250px'});
                //与tableIns.reload方法类似，这种方法是取表格容器索引值
                table.reload('tableID', {
                    where: {                                     // <------------------------------模板修改：修改搜索的传参值
                        make: 3,
                        floorName: inputTxt
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
            layer.prompt({
                title: '请输入楼层名称',
                formType: 0,
                offset: '220px',
                maxlength: 10
            }, function (inputValue, index) {
                layer.close(index);
                var params = "floorName=" + inputValue;
                $.post(baseUrl + '/QueryFloorNameServlet', params, function insertCheck(data) {
                    if (data == 1) {
                        table.reload('tableID', {
                            where: {
                                make: 1,
                                floorName: inputValue
                            }
                        });
                        layer.msg('新增楼层成功', {offset: '250px'});
                    } else {
                        layer.alert('该楼层名称已经存在！', {
                            title: '警告', icon: 4, anim: 6, offset: '220px'
                        });
                    }
                });
            });
        });

        //导出
        $('#toXlsButton').click(function () {
            tableIns.reload({where: {make: 0, limit: countNum}});
            layer.prompt({
                title: '请输入文件名称',
                formType: 0,
                value: 'FloorInfo',                              // <------------------------------模板修改：修改默认的导出文件名称
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