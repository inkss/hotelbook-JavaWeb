<%@ page contentType="text/html;charset=UTF-8" %>
<html>

	<head>
		<meta charset="utf-8">
		<title>预定单</title>
		<link rel="stylesheet" href="../../js/layui/css/layui.css" media="all">
		<script src="../../js/layui/layui.js"></script>
		<script src="../../js/jquery.js"></script>
		<script src="../../js/global.js"></script>
		<script src="../../js/getTime.js"></script>
	</head>

	<body>
		<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
			<legend>酒店管理 - 预订单</legend>
		</fieldset>

		<form class="layui-form" action="">

			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">预定单号</label>
					<div class="layui-input-block">
						<input type="text" name="orderId" class="layui-input" value="" id="orderID" readonly>
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">预定人</label>
					<div class="layui-input-inline">
						<input type="text" name="price" lay-verify="required|number" autocomplete="off" placeholder="预定人姓名" class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">预定电话</label>
					<div class="layui-input-inline">
						<input type="tel" name="phone" lay-verify="required|phone" autocomplete="off" placeholder="预定人电话" class="layui-input">
					</div>
				</div>
			</div>

			<div class="layui-form-item">
				<label class="layui-form-label">身份证</label>
				<div class="layui-input-block">
					<input type="text" name="identity" lay-verify="identity" placeholder="公民身份证号" autocomplete="off" class="layui-input">
				</div>
			</div>

			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">抵店时间</label>
					<div class="layui-input-inline">
						<input type="text" name="date" id="date1" lay-verify="date" placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
					</div>
				</div>

				<div class="layui-inline">
					<label class="layui-form-label">离店时间</label>
					<div class="layui-input-inline">
						<input type="text" name="date" id="date" lay-verify="date" placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
					</div>
				</div>

			</div>

			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">房间类型</label>
					<div class="layui-input-inline">
						<input type="text" name="price" lay-verify="required|number" autocomplete="off" placeholder="房间类型" class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">入住人数</label>
					<div class="layui-input-inline">
						<input type="text" name="price" lay-verify="required|number" autocomplete="off" placeholder="实际入住人数" class="layui-input">
					</div>
				</div>

			</div>

			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">客房编号</label>
					<div class="layui-input-inline">
						<input type="text" name="price" lay-verify="required|number" autocomplete="off" placeholder="No." class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">客房价格</label>
					<div class="layui-input-inline">
						<input type="text" name="price" lay-verify="required|number" autocomplete="off" placeholder="￥" class="layui-input">
					</div>
				</div>

			</div>

			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">入住价格</label>
					<div class="layui-input-inline">
						<input type="text" name="price" lay-verify="required|number" autocomplete="off" placeholder="￥" class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">折扣</label>
					<div class="layui-input-inline">
						<input type="text" name="price" lay-verify="required|number" autocomplete="off" placeholder="折扣请输入，无折扣置空" class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">折扣原因</label>
					<div class="layui-input-inline">
						<input type="text" name="price" lay-verify="required|number" autocomplete="off" placeholder="请输入折扣原因" class="layui-input">
					</div>
				</div>

			</div>

			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">是否可拼房</label>
					<div class="layui-input-inline">
						<input type="text" name="price" lay-verify="required|number" autocomplete="off" placeholder="拼房价格" class="layui-input">
					</div>
					<input type="radio" name="isSplice" value="Y" title="是" checked="">
					<input type="radio" name="isSplice" value="N" title="否">
				</div>
			</div>

			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">预收款</label>
					<div class="layui-input-inline">
						<input type="text" name="price" lay-verify="required|number" autocomplete="off" placeholder="￥" class="layui-input">
					</div>
				</div>
			</div>

			<div class="layui-form-item layui-form-text">
				<label class="layui-form-label">备注</label>
				<div class="layui-input-block">
					<textarea placeholder="请输入内容" class="layui-textarea"></textarea>
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

				var time = new Date().getTime();

				$(document).ready(function() {
					$("#orderID").val("OD" + time);
				});

			});
		</script>
	</body>

</html>