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

	<body>
		<div class="layui-side layui-bg-black">
			<div class="layui-side-scroll">
				<ul class="layui-nav layui-nav-tree">
					<li class="layui-nav-item layui-nav-itemed">
						<a>基础功能设置</a>
						<dl class="layui-nav-child">
							<dd>
								<a href="RoomTypeTable.jsp" target="content">房间类型</a>
							</dd>
							<dd>
								<a href="FloorTable.jsp" target="content">楼层信息</a>
							</dd>
						</dl>
					</li>
					<li class="layui-nav-item">
						<a>附属功能设置</a>
						<dl class="layui-nav-child">
							<dd>
								<a href="AuthTable.jsp" target="content">权限管理</a>
							</dd>
						</dl>
					</li>
				</ul>
			</div>
		</div>
		<script src="../../js/layui/layui.js"></script>
		<script src="../../js/jquery.js"></script>
		<script>
			layui.use('element', function() {
				var element = layui.element;

			});
		</script>
	</body>

</html>