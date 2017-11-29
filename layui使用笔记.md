# 我是一级标题

> 记录本项目中对layui的使用细节，毕竟官网文档辣么长

## 1.模块名称:table

### 1.1 方法级渲染表格

    <html>
        <body>
        <table id="demo"></table>
        <script>
            ...
            //初始化表格
            var tableIns = table.render({ //tableIns:table.render()方法的实例
                  elem: '#demo' //指定原始表格元素选择器
                , id: 'tableID' //表格容器索引
                , height: 315 //容器高度
                , cols: [{
                    //field字段名、title标题名、width列宽、sort排序、fixed固定列、toolbar绑定工具条
                }] //设置表头
                , page: true //是否开启分页
                , where: {
                    make: 0 //接口的其它自定义参数
                } 
                , done: function(res, curr, count){ //回调
                    console.log(res.msg); //得到状态信息
                    console.log(curr); //得到当前页码
                    console.log(count); //得到数据总量
                }
            });
            //表格重载 方法一
            tableIns.reload({
                where: {
                    //其它自定义参数
                }
            });
            //表格重载 方法二
            table.reload('tableID', {
                where: {
                    //其它自定义参数
                }
            });
            ...
        </script>
        </body>
    </html>

### 1.2 表格接口

    private String code; //数据状态字段
    private String msg; //状态字段名
    private String count; //数据总数
    private List data; //数据

## 2.模块名称:util

### 2.1 固定块:回到顶端

    util.fixbar({
        showHeight: 2,
        click: function(type) {
            console.log(type);
        }
    });

## 3.模块名称:layer