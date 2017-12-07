<%@ page contentType="text/html;charset=UTF-8" %>
<html>

	<head>
		<meta charset="utf-8">
		<title>酒店管理系统</title>
		<link rel="stylesheet" href="../../js/layui/css/layui.css" media="all">
		<link rel="stylesheet" href="../../MAIN/component/font-awesome-4.7.0/css/font-awesome.min.css">
		<script src="../../js/layui/layui.js"></script>
		<script src="../../js/jquery.js"></script>
		<script src="../../js/global.js"></script>
		<script src="../../js/toExcel/xlsx.full.min.js"></script>
		<script type="text/javascript" src="../../js/toExcel/FileSaver.js"></script>
		<script type="text/javascript" src="../../js/toExcel/Export2Excel.js"></script>
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
						<div class="layui-input-inline">
							<input class="layui-input" id="inputSearch" placeholder="楼层名称">
						</div>
						<button class="layui-btn fa fa-search" id="searchButton"> 搜索</button>
					</div>
					<div class="layui-inline">
						<button class="layui-btn fa fa-refresh" id="refreshButton"> 刷新</button>
					</div>
					<div class="layui-inline">
						<button class="layui-btn fa fa-pencil-square-o " id="insertButton"> 新增</button>
					</div>
					<div class="layui-inline">
						<button class="layui-btn fa fa-save" id="toXlsButton"> 导出</button>
					</div>
				</div>
			</legend>
		</fieldset>
		<div id="toxlsTable">
			<table id="tableID"></table>
		</div>
		<script type="text/html" id="barAuth">
			<a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
			<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
			<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
		</script>
		<script>
			/**
			 * 公共模板部分，自制模板修改
			 * 规定：make 0重载 1新增 2修改 3搜索 4删除
			 *
			 * 这个模板来自权限表的jsp与js,因为大体类似，前端可以参照同一结构
			 * 一些变量名换成了与具体项无关的名称，需要修改的部分通过注释注明
			 * 原注释可以参考最初的版本 : AuthTable.jsp
			 */

			layui.use(['util', 'layer', 'table'], function() {
				$(document).ready(function() {
					var table = layui.table,
						layer = layui.layer,
						util = layui.util;
					var countNum;
					var tableIns = table.render({
						elem: '#tableID',
						id: 'tableID',
						url: baseUrl + '/FloorInfoServlet',
						cols: [
							[{
								field: 'floorId',
								title: 'ID',
								width: 100,
								sort: true,
								fixed: true
							}, {
								field: 'floorName',
								title: '楼层名称'
							}, {
								field: 'right',
								title: '管理',
								align: 'center',
								toolbar: '#barAuth',
								width: 200
							}]
						],
						page: true,
						where: {
							make: 0
						},
						done: function(res, curr, count) {
							countNum = count;
						}
					});

					//监听工具条
					table.on('tool', function(obj) {
						var data = obj.data,
							layEvent = obj.event;
						var floorId = data.floorId;
						var floorName = data.floorName;

						if(layEvent === 'detail') { //查看功能
							layer.alert('ID：' + floorId + '<br>楼层名称：' + floorName, {
								skin: 'layui-layer-lan',
								closeBtn: 0,
								title: '您当前选择的楼层值信息',
								anim: 4,
								offset: '180px'
							});
						} else if(layEvent === 'del') {
							layer.confirm('您确定要删除该条数据吗？', {
								offset: '180px',
								btn: ['是滴', '手滑']
							}, function() {
								table.reload('tableID', {
									where: {
										make: 4,
										floorId: floorId
									}
								});
								layer.msg('删除结果如下', {
									offset: '250px',
									icon: 1
								});
							}, function() {
								layer.msg('删除操作已取消', {
									offset: '250px'
								});
							});
						} else if(layEvent === 'edit') {
							layer.prompt({
								title: '请输入楼层名称',
								formType: 0,
								value: floorName,
								offset: '220px',
								maxlength: 10
							}, function(value, index) {
								var params = "new=" + value + "&old=" + floorName;
								$.post(baseUrl + '/QueryFloorNameServlet', params, function updateCheck(data) {
									if(data === "1" || data === "2") {
										layer.close(index);
										table.reload('tableID', {
											where: {
												make: 2,
												floorId: floorId,
												floorName: value
											}
										});
										layer.msg('修改结果如下', {
											offset: '250px'
										});
									} else {
										layer.alert('该楼层名称已经存在！', {
											title: '警告',
											icon: 4,
											anim: 6,
											offset: '220px'
										});
									}
								});
							});
						}
					});

					//搜索
					$('#searchButton').click(function() {
						var inputTxt = $('#inputSearch').val();
						if(inputTxt === "")
							layer.msg('您必须输入值', {
								offset: '250px'
							});
						else if(inputTxt.length > 10)
							layer.msg('您所输入的值长度不合法', {
								offset: '250px'
							});
						else {
							tableIns.reload({
								where: {
									make: 3,
									floorName: inputTxt
								}
							});
							layer.msg('搜索结果', {
								offset: '250px'
							});
						}
					});

					//刷新
					$('#refreshButton').click(function() {
						tableIns.reload({
							where: {
								make: 0,
								page: 1
							}
						});
					});

					//新增
					$('#insertButton').click(function() {
						layer.prompt({
							title: '请输入楼层名称',
							formType: 0,
							offset: '220px',
							maxlength: 10
						}, function(inputValue, index) {
							var params = "new=" + inputValue + "&old=" + inputValue;
							$.post(baseUrl + '/QueryFloorNameServlet', params, function(data) {
								if(data === "1") {
									layer.close(index);
									table.reload('tableID', {
										where: {
											make: 1,
											floorName: inputValue
										}
									});
									layer.msg('新增楼层成功', {
										offset: '250px'
									});
									tableIns.reload({
										where: {
											make: 0
										}
									});
								} else {
									layer.alert('该楼层名称已经存在！', {
										title: '警告',
										icon: 4,
										anim: 6,
										offset: '220px'
									});
								}
							});
						});
					});

					//导出
					$('#toXlsButton').click(function() {
						location.href = baseUrl + '/FloorInfoExcelServlet';
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
						click: function(type) {
							console.log(type);
						}
					});
				});
			});
		</script>
	</body>

</html>