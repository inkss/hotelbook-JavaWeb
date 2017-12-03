<%@ page contentType="text/html;charset=UTF-8" %>
<html>

	<head>
		<meta charset="utf-8">
		<title>新增房间类型</title>
		<link rel="stylesheet" href="../../js/layui/css/layui.css" media="all">
		<script src="../../js/layui/layui.js"></script>
		<script src="../../js/jquery.js"></script>
		<script src="../../js/global.js"></script>
	</head>

	<body>
		<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
			<legend>新增房间类型</legend>
		</fieldset>
		<form class="layui-form" action="">
			<div class="layui-form-item">
				<label class="layui-form-label">类型名称</label>
				<div class="layui-input-block">
					<input type="text" name="typeName" lay-verify="required|typeName" autocomplete="off" placeholder="请输入类型名称" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">价格</label>
					<div class="layui-input-inline">
						<input type="text" name="price" lay-verify="required|number" autocomplete="off" placeholder="￥" class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">拼房价格</label>
					<div class="layui-input-inline">
						<input type="text" name="splicPrice" lay-verify="required|number" autocomplete="off" placeholder="￥" class="layui-input">
					</div>
				</div>
			</div>
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">可超预定数</label>
					<div class="layui-input-inline">
						<input type="text" name="exceedance" lay-verify="required|number" autocomplete="off" class="layui-input">
					</div>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">是否可拼房</label>
				<div class="layui-input-block">
					<input type="radio" name="isSplice" value="Y" title="是" checked="">
					<input type="radio" name="isSplice" value="N" title="否">
				</div>
			</div>
			<div class="layui-form-item">
				<div class="layui-input-block">
					<button class="layui-btn" lay-submit lay-filter="insertRome">立即提交</button>
					<button type="reset" class="layui-btn layui-btn-primary">重置</button>
				</div>
			</div>
		</form>

		<script>
			layui.use(['form', 'layedit', 'laydate'], function() {
				var form = layui.form,
					layer = layui.layer;

				//自定义验证规则
				form.verify({
					typeName: function(value) {
						if(value.length < 3) {
							return '房间类型至少3个字符';
						}

						if(value.length > 10) {
							return '房间类型至多10个字符'
						}
					}
				});

				//监听提交
				form.on('submit(insertRome)', function(data) {
					$.post(baseUrl + '/InsertRoomTypeServlet', JSON.stringify(data.field), function(code) {
						if(code === 1) {
							layer.alert('插入成功！', {
								title: '成功',
								icon: 6,
								anim: 5
							});
						} else if(code === 0) {
							layer.alert('已存在同名项！', {
								title: '重复',
								icon: 4,
								anim: 6
							});
						} else {
							layer.alert('插入失败！', {
								title: '异常',
								icon: 6,
								anim: 6
							});
						}
					});
					return false;
				});
			});
		</script>
	</body>

</html>