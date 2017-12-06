<%@ page contentType="text/html;charset=UTF-8" %>
<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<title>酒店管理系统</title>
		<link rel="stylesheet" href="../../js/layui/css/layui.css" media="all">
		<link rel="stylesheet" href="../../MAIN/component/font-awesome-4.7.0/css/font-awesome.min.css">
		<script src="../../js/toExcel/xlsx.full.min.js"></script>
		<script type="text/javascript" src="../../js/toExcel/FileSaver.js"></script>
		<script type="text/javascript" src="../../js/toExcel/Export2Excel.js"></script>
	</head>

	<body class="layui-layout-body">
		<div class="layui-layout layui-layout-admin">
			<div class="layui-header">
				<div class="layui-logo">酒店管理系统</div>
				<!-- 头部区域（可配合layui已有的水平导航） -->
				<ul class="layui-nav layui-layout-left">
					<li class="layui-nav-item" lay-unselect>
						<a href="../orderInfo/orderTable.jsp" target="search">预订单</a>
					</li>
					<li class="layui-nav-item" lay-unselect>
						<a href="此处填充地址" target="search">入住单</a>
					</li>
					<li class="layui-nav-item" lay-unselect>
						<a href="此处填充地址" target="search">账单明细</a>
					</li>
				</ul>
				<ul class="layui-nav layui-layout-right">
					<li class="layui-nav-item" lay-unselect>
						<a href="此处填充地址" target="search">预订单历史</a>
					</li>
					<li class="layui-nav-item" lay-unselect>
						<a href="此处填充地址" target="search">入住单历史</a>
					</li>
				</ul>
			</div>
		</div>

		<script src="../../js/layui/layui.js"></script>
		<script src="../../js/jquery.js"></script>

		<script>
			//JavaScript代码区域
			layui.use('element', function() {});
		</script>
	</body>

</html>