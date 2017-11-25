/**
 * 权限表 全部完成
 * 2017.11.15 1:33
 */
layui.use(['util', 'layer', 'table'], function () {
    $(document).ready(function () {
        //自动初始化表格
        var table = layui.table
            , layer = layui.layer
            , util = layui.util;
        var countNum; //统计所有的数据量
        //方法级渲染
        var tableIns = table.render({
            done: function (res, curr, count) {
                //回调函数
                //如果是直接赋值的方式，res即为：{data: [], count: 99} data为当前页数据、count为数据总长度
                countNum = count;
            }
            , elem: '#tableAuth'  //绑定元素
            , id: 'tableAuth'  //表格容器索引
            , url: baseUrl + '/AuthInfoServlet' //数据接口
            , cols: [[  //表头
                //field字段名、title标题名、width列宽、sort排序、fixed固定列、toolbar绑定工具条
                {field: 'authId', title: 'ID', width: 100, sort: true, fixed: true}
                , {field: 'authItem', title: '权限名称'}
                , {field: 'isRead', title: '可读'}
                , {field: 'isWrite', title: '可写'}
                , {field: 'isChange', title: '可改'}
                , {field: 'isDelete', title: '可删'}
                , {field: 'right', title: '管理', align: 'center', toolbar: '#barAuth', width: 200}

            ]]
            , page: true  //是否开启分页
            , where: {
                make: 0 //make,此值将传入到servlet，根据值判断当前需要从后端获取的内容
            }
        });

        //监听工具条
        table.on('tool', function (obj) { //tool是工具条事件名
            var data = obj.data //获得当前行数据
                , layEvent = obj.event; //获得 lay-event 对应的值
            if (layEvent === 'detail') {
                layer.alert('权限项：' + data.authItem
                    + '<br>最低可读权限等级：' + data.isRead
                    + '<br>最低可写权限等级：' + data.isWrite
                    + '<br>最低可改权限等级：' + data.isChange
                    + '<br>最低可删权限等级：' + data.isDelete
                    , {
                        skin: 'layui-layer-lan'
                        , closeBtn: 0
                        , title: '您当前选择的权限值信息'
                        , anim: 4
                        , offset: '180px'
                    });

            } else if (layEvent === 'del') {
                layer.alert('本条目禁止删除！', {
                    title: '警告', icon: 4, anim: 6, offset: '250px'  //保持水平，自顶部向下偏移250像素
                });
            } else if (layEvent === 'edit') {
                //layer.prompt(options, yes) - 输入层
                //formType:输入框类型，支持0（文本）默认1（密码）2（多行文本）
                //maxlength: 140, //可输入文本的最大长度，默认500
                var authId = data.authId;
                var authItem = data.authItem;
                var isRead = data.isRead;
                var isWrite = data.isWrite;
                var isChange = data.isChange;
                var isDelete = data.isDelete;
                layer.prompt({
                    title: '请输入最低可读权限等级',
                    formType: 0,
                    value: isRead,
                    offset: '220px',
                    maxlength: 1
                }, function (IsRead, index) {
                    layer.close(index);
                    layer.prompt({
                        title: '请输入最低可写权限等级',
                        formType: 0,
                        value: isWrite,
                        offset: '220px',
                        maxlength: 1
                    }, function (IsWrite, index) {
                        layer.close(index);
                        layer.prompt({
                            title: '请输入最低可改权限等级',
                            formType: 0,
                            value: isChange,
                            offset: '220px',
                            maxlength: 1
                        }, function (IsChange, index) {
                            layer.close(index);
                            layer.prompt({
                                title: '请输入最低可删权限等级',
                                formType: 0,
                                value: isDelete,
                                offset: '220px',
                                maxlength: 1
                            }, function (IsDelete, index) {
                                layer.close(index);
                                //isNaN() 函数用于检查其参数是否是非数字值,如果是数字返回true
                                if (isNaN(IsRead) || isNaN(IsWrite) || isNaN(IsChange) || isNaN(IsDelete)) {
                                    layer.msg('您所输入的值类型不合法', {offset: '250px'});
                                } else {
                                    //传数据
                                    table.reload('tableAuth', {
                                        where: {
                                            make: 2,
                                            authId: authId,
                                            authItem: authItem,
                                            isRead: IsRead,
                                            isWrite: IsWrite,
                                            isChange: IsChange,
                                            isDelete: IsDelete
                                        }
                                    });
                                    layer.msg('修改成功', {offset: '250px'});
                                }
                            });
                        });
                    });
                });
            }
        });

        //刷新
        $('#refresh').click(function () {
            tableIns.reload({where: {make: 0}});
        });

        //新增
        $('#insertAuth').click(function () {
            layer.alert('本条目禁止新增！', {
                title: '警告', icon: 4, anim: 6, offset: '250px'  //保持水平，自顶部向下偏移250像素
            });
        });


        //搜索权限项目
        $('#searchAuthITEM').click(function () {
            var authItem = $('#AuthITEM').val();
            if (authItem == "")
                layer.msg('您必须输入值', {offset: '250px'});
            else if (authItem.length > 10)
                layer.msg('您所输入的值长度不合法', {offset: '250px'});
            else {
                layer.msg('搜索结果', {offset: '250px'});
                //与tableIns.reload方法类似，这种方法是取表格容器索引值
                table.reload('tableAuth', {
                    where: {
                        make: 3,
                        authItem: authItem
                    }
                })
            }

        });

        //导出
        $('#toXls').click(function () {
            //显示所有表格
            tableIns.reload({where: {make: 0, limit: countNum}});
            layer.prompt({
                title: '请输入文件名称',
                formType: 0,
                value: 'AuthInfo',
                offset: '220px'
            }, function (fileName, index) {

                layer.close(index);
                /**
                 * 此处导出文件
                 * 只能导出显示的文件
                 */
                export_table_to_excel('toxlsTable', fileName);
                layer.alert('当前页面数据导出完成！', {
                    title: '导出成功', icon: 6, anim: 1, offset: '250px'  //保持水平，自顶部向下偏移250像素
                });
                //刷新恢复
                tableIns.reload({where: {make: 0}});
            });
        });

        //固定块  -- 就是那个回到顶部
        util.fixbar({
            showHeight: 2
            , click: function (type) {
                console.log(type);
            }
        });
    });
});
