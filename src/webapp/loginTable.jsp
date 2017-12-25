<%@ page contentType="text/html;charset=UTF-8" %>
<html>

<head>
    <meta charset="utf-8">
    <title>酒店管理系统</title>
    <link rel="stylesheet" href="./js/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="./MAIN/component/font-awesome-4.7.0/css/font-awesome.min.css">
    <script src="./js/layui/layui.js"></script>
    <script src="./js/jquery.js"></script>
    <script src="./js/global.js"></script>
    <script src="./js/Cookie.js"></script>
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
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
    <legend>
        <div>
            <div class="layui-inline">
                <button class="layui-btn layui-btn-primary fa fa-pencil-square-o " id="insertButton"> 新增</button>
            </div>
            <div class="layui-inline">
                <button class="layui-btn layui-btn-primary fa  fa-cloud-download" id="toXlsButton"> 导出</button>
            </div>
            <div class="layui-inline">
                <button type="button" class="layui-btn layui-btn-primary fa fa-cloud-upload" id="upload"> 导入</button>
            </div>
        </div>
    </legend>
</fieldset>
<table id="tableID"></table>
<script type="text/html" id="barAuth">
    <a class="layui-btn layui-btn-xs" lay-event="edit">改密</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
<script>

    layui.use(['util', 'layer', 'table','upload'], function () {
        $(document).ready(function () {
            var table = layui.table,
                layer = layui.layer,
                upload = layui.upload,
                util = layui.util;

            upload.render({ //允许上传的文件后缀
                elem: '#upload'
                ,url: baseUrl + '/UploadFileServlet'
                ,accept: 'file' //普通文件
                ,exts: 'xlsx' //只允许上传excel文件
                ,before: function(){
                    layer.msg('文件上传中');
                }
                ,success: function(res){
                    alert(res.msg);
                }
            });

            var countNum;
            var tableIns = table.render({
                elem: '#tableID',
                id: 'tableID',
                url: baseUrl + '/LoginTableServlet',
                cols: [
                    [{
                        field: 'loginId',
                        title: '用户ID',
                        width: 100,
                        sort: true,
                        fixed: true
                    }, {
                        field: 'loginName',
                        title: '用户登录名'
                    }, {
                        field: 'loginNickName',
                        title: '用户昵称'
                    }, {
                        field: 'right',
                        title: '管理',
                        align: 'center',
                        toolbar: '#barAuth',
                        width: 150
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
                var loginId = data.loginId;
                var loginName = data.loginName;
                var loginNameNow = getCookie("loginName");
                if (layEvent === 'del') {
                    if (loginName != loginNameNow) {
                        layer.confirm('您确定要删除该条数据吗？', {
                            offset: '180px',
                            btn: ['是滴', '手滑']
                        }, function () {
                            table.reload('tableID', {
                                where: {
                                    make: 4,
                                    loginId: loginId
                                }
                            });
                            layer.msg('删除结果如下', {
                                offset: '250px',
                                icon: 1
                            });
                        }, function () {
                            layer.msg('删除操作已取消', {
                                offset: '250px'
                            });
                        });
                    } else {
                        layer.msg('当前登陆账号禁止删除', {
                            offset: '250px'
                        });
                    }
                } else if (layEvent === 'edit') {
                    layer.prompt({
                        title: '请输入旧密码',
                        formType: 1,
                        offset: '220px',
                        maxlength: 18
                    }, function (value, index) {
                        var params = "loginName=" + loginName + "&loginPwd=" + value;
                        $.post(baseUrl + '/QueryLoginNameServlet', params, function updateCheck(data) {
                            layer.close(index);
                            if (data === "0") {
                                layer.alert('密码不正确！', {
                                    title: '警告',
                                    icon: 2,
                                    anim: 6,
                                    offset: '220px'
                                });
                            } else {
                                layer.prompt({
                                    title: '请输入新密码',
                                    formType: 1,
                                    offset: '220px',
                                    maxlength: 18
                                }, function (value1, index1) {
                                    var pwd1 = value1;
                                    layer.prompt({
                                        title: '请再次输入新密码',
                                        formType: 1,
                                        offset: '220px',
                                        maxlength: 18
                                    }, function (value2, index2) {
                                        var pwd2 = value2;
                                        if (pwd2 != pwd1) {
                                            layer.close(index2);
                                            layer.alert('两次输入的值不一致！', {
                                                title: '警告',
                                                icon: 2,
                                                anim: 6,
                                                offset: '220px'
                                            });
                                        } else {
                                            layer.close(index1);
                                            layer.close(index2);
                                            params = "loginName=" + loginName + "&loginPwd=" + value2;
                                            $.post(baseUrl + '/UpdatePwdServlet', params, function updateCheck(data) {
                                                if (data === '1') {
                                                    layer.alert('修改成功！', {
                                                        title: '成功',
                                                        icon: 6,
                                                        anim: 1,
                                                        offset: '220px'
                                                    });
                                                } else {
                                                    layer.alert('修改失败！', {
                                                        title: '失败',
                                                        icon: 2,
                                                        anim: 6,
                                                        offset: '220px'
                                                    });
                                                }
                                            });
                                        }
                                    });
                                });

                            }
                        });
                    });

                }
            });

            //新增
            $('#insertButton').click(function () {
                layer.open({
                    title: "新增",
                    btn: ['关闭'],
                    yes: function (index) {
                        tableIns.reload({
                            where: {
                                make: 0
                            }
                        });
                        layer.close(index); //关闭弹窗
                    },
                    type: 2,
                    area: ['450px', '500px'],
                    fixed: false,
                    maxmin: true,
                    content: '/hb/insertLogin.jsp',
                    cancel: function () {
                        tableIns.reload({
                            where: {
                                make: 0
                            }
                        });
                    }
                });

            });

            //导出
            $('#toXlsButton').click(function () {
                location.href = baseUrl + '/LoginExcelServlet';
                layer.alert('Excel文件生成完成！', {
                    title: '成功',
                    icon: 6,
                    anim: 1,
                    offset: '250px'
                });
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