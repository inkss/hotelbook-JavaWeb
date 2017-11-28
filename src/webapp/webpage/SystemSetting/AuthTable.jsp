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
							<input class="layui-input" id="AuthITEM" placeholder="权限名称">
						</div>
						<button class="layui-btn fa fa-search" id="searchAuthITEM"> 搜索</button>
					</div>
					<div class="layui-inline">
						<button class="layui-btn fa fa-refresh" id="refresh"> 刷新</button>
					</div>
					<div class="layui-inline">
						<button class="layui-btn fa fa-pencil-square-o " id="insertAuth"> 新增</button>
					</div>
					<div class="layui-inline">
						<button class="layui-btn fa fa-save" id="toXls"> 导出</button>
					</div>
				</div>
			</legend>
		</fieldset>
		<div id="toxlsTable">
			<%--方法级渲染表格--%>
			<table id="tableAuth"></table>
		</div>
		<script type="text/html" id="barAuth">
			<a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
			<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
			<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
		</script>
		<script src="../../js/SystemSetting/AuthTable.js"></script>
	</body>

</html>