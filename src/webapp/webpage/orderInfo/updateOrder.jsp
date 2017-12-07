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
		<script src="../../js/Cookie.js"></script>
	</head>

	<body>
		<fieldset class="layui-elem-field layui-field-title " style="margin-top: 20px;">
			<legend>酒店管理 - 预订单</legend>
		</fieldset>

		<form class="layui-form">

			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">预定单号</label>
					<div class="layui-input-block">
						<input type="text" id="orderId" class="layui-input" readonly>
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">预定人</label>
					<div class="layui-input-inline">
						<input type="text" id="orderName" lay-verify="required" autocomplete="off" placeholder="预定人姓名" class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">预定电话</label>
					<div class="layui-input-inline">
						<input type="tel" id="orderPhone" lay-verify="phone" autocomplete="off" placeholder="预定人电话" class="layui-input">
					</div>
				</div>
			</div>

			<div class="layui-form-item">
				<label class="layui-form-label">身份证</label>
				<div class="layui-input-block">
					<input type="text" id="orderIDcard" lay-verify="required|identity" placeholder="公民身份证号" autocomplete="off" class="layui-input">
				</div>
			</div>

			<div class="layui-form-item">

				<div class="layui-inline">
					<label class="layui-form-label">入住时长</label>
					<div class="layui-input-inline">
						<input type="text" class="layui-input" lay-verify="required" id="orderAllTime" placeholder="抵店时间 - 离店时间" readonly>
					</div>
				</div>

				<div class="layui-inline">
					<label class="layui-form-label">入住人数</label>
					<div class="layui-input-inline">
						<input type="text" id="checkNum" lay-verify="number" autocomplete="off" placeholder="实际入住人数" class="layui-input">
					</div>
				</div>

				<div class="layui-inline">
					<label class="layui-form-label">房间类型</label>
					<div class="layui-input-inline">
						<input type="text" id="typeId" lay-verify="required" autocomplete="off" placeholder="房间类型" class="layui-input" readonly>
					</div>
					<button type="button" class="layui-btn layui-btn-primary" id="buttonTypeId"><i class="layui-icon">&#xe654;</i> 选择</button>
				</div>

			</div>

			<div class="layui-form-item">

				<div class="layui-inline">
					<label class="layui-form-label">客房价格</label>
					<div class="layui-input-inline">
						<input type="text" id="price" lay-verify="number" autocomplete="off" placeholder="￥" class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">入住价格</label>
					<div class="layui-input-inline">
						<input type="text" id="checkPrice" lay-verify="number" autocomplete="off" placeholder="￥" class="layui-input">
					</div>
				</div>

			</div>

			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">折扣</label>
					<div class="layui-input-inline">
						<input type="text" id="discount" lay-verify="number" autocomplete="off" placeholder="折扣请输入，无折扣置空" class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">折扣原因</label>
					<div class="layui-input-inline">
						<input type="text" id="discountReason" autocomplete="off" placeholder="请输入折扣原因" class="layui-input">
					</div>
				</div>

			</div>

			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">是否加床</label>
					<div class="layui-input-inline">
						<input type="radio" name="addBed" value="Y" title="是" lay-filter="addBedYes">
						<input type="radio" name="addBed" value="N" title="否" lay-filter="addBedNo" checked>
					</div>
				</div>
				<div class="layui-inline">
					<div id="addBed" class="layui-inline layui-hide">
						<label class="layui-form-label">加床价格</label>
						<div class="layui-input-inline">
							<input type="text" id="addBedPrice" lay-verify="number" autocomplete="off" placeholder="￥" class="layui-input">
						</div>
					</div>
				</div>
			</div>

			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">预收款</label>
					<div class="layui-input-inline">
						<input type="text" id="orderMoney" lay-verify="required|number" autocomplete="off" placeholder="￥" class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">单据状态</label>
					<div class="layui-input-inline">
						<select name="orderState" class="layui-input-inline" id="orderState">
							<option value="预定">预定</option>
							<option value="入住">入住</option>
							<option value="结算">结算</option>
							<option value="延期">延期</option>
						</select>
					</div>
				</div>

			</div>

			<div class="layui-form-item layui-form-text">
				<label class="layui-form-label">备注</label>
				<div class="layui-input-block">
					<textarea id="remark" placeholder="请输入内容" class="layui-textarea"></textarea>
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
					layer = layui.layer,
					layedit = layui.layedit,
					laydate = layui.laydate;
				var isAddBed = false;

				var orderId = getCookie("orderId");
				deleteCookie("orderId"); //取到值就麻溜的删
				var queryId = "orderId=" + orderId;

				// 开始赋值
				$.post(baseUrl + '/QueryOrderInfoServlet', queryId, function(orderInfo) {
					var obj = JSON.parse(orderInfo);
					$("#orderId").val(orderId);
					$("#orderName").val(obj.orderName);
					$("#orderPhone").val(obj.orderPhone);
					$("#orderIDcard").val(obj.orderIDcard);
					$("#typeId").val(obj.typeId);
					$("#orderAllTime").val(obj.arrireDate + " | " + obj.leaveDate);

					$("#orderState").val(obj.orderState); //<--需要处理
					form.render("select"); //重新渲染select

					$("#checkNum").val(obj.checkNum);
					$("#price").val(obj.price);
					$("#orderName").val(obj.orderName);
					$("#checkPrice").val(obj.checkPrice);
					$("#discount").val(obj.discount);
					$("#discountReason").val(obj.discountReason);

					isAddBed = obj.addBed; //<--需要处理，默认选中的是否
					if(isAddBed === "false") {
						$('#addBed').removeClass("layui-show");
						$('#addBed').addClass("layui-hide");
					} else {
						$('#addBed').removeClass("layui-hide");
						$('#addBed').addClass("layui-show");
						$("input[name='addBed'][value='Y']").prop("checked", true); //把 是 给主动选上
						form.render('radio'); //重新渲染
					}

					$("#addBedPrice").val(obj.addBedPrice);
					$("#orderMoney").val(obj.orderMoney);
					$("#operatorId").val(obj.operatorId);
					$("#remark").val(obj.remark);

				});

				//日期
				laydate.render({
					elem: '#arrireDate'
				});
				laydate.render({
					elem: '#leaveDate'
				});
				laydate.render({
					elem: '#orderAllTime',
					type: 'datetime',
					min: -30,
					range: '|',
					format: 'yyyy-MM-dd',
					calendar: true
				});

				//一个属性的显隐，直接通过修改class实现，使用了layui的class属性
				form.on('radio(addBedYes)', function() {
					$('#addBed').removeClass("layui-hide");
					$('#addBed').addClass("layui-show");
					isAddBed = true;
				});
				form.on('radio(addBedNo)', function() {
					$('#addBed').removeClass("layui-show");
					$('#addBed').addClass("layui-hide");
					isAddBed = false;
				});

				//房间类型的选择
				$('#buttonTypeId').on('click', function() {
					layer.open({
						type: 2,
						title: '请选择房间类型',
						btn: ['确定', '取消'],
						area: ['750', '360px'],
						fixed: form,
						content: './selectRoomType.jsp',
						yes: function(index, layero) {
							typeId.value = $(layero).find('iframe')[0].contentWindow.tId.value; //将子窗口中的 tId 抓过来
							price.value = $(layero).find('iframe')[0].contentWindow.tPrice.value;
							layer.close(index); //关闭弹窗
						},
						btn2: function(index) {
							layer.close(index);
						},
						success: function(layero, index) {
							var obj = $(layero).find('iframe')[0].contentWindow;
						},
						offset: '0px'
					});
				});

				//监听提交
				form.on('submit(insertRome)', function(data) {

					//先获取值
					var orderId = $('#orderId').val();
					var orderName = $('#orderName').val();
					var orderPhone = $('#orderPhone').val();
					var orderIDcard = $('#orderIDcard').val();
					var typeId = $('#typeId').val();

					//返回数据类型： yyyy-mm-dd hh:mm:ss
					var orderAllTime = ($('#orderAllTime').val()).split(" | ");
					var arrireDate = orderAllTime[0];
					var leaveDate = orderAllTime[1];

					var orderState = $('#orderState').val();
					var checkNum = $('#checkNum').val();

					var price = $('#price').val();
					var checkPrice = $('#checkPrice').val();
					var discount = $('#discount').val();
					var discountReason = $('#discountReason').val();

					//加床：true 不加：false
					var addBed = isAddBed;

					var addBedPrice = $('#addBedPrice').val();
					var orderMoney = $('#orderMoney').val();
					var operatorId = getCookie("loginName");
					var remark = $('#remark').val();

					var params = "orderId=" + orderId + "&orderName=" + orderName + "&orderPhone=" + orderPhone +
						"&orderIDcard=" + orderIDcard + "&typeId=" + typeId + "&arrireDate=" + arrireDate +
						"&leaveDate=" + leaveDate + "&orderState=" + orderState + "&checkNum=" + checkNum +
						"&price=" + price + "&checkPrice=" + checkPrice + "&discount=" + discount +
						"&discountReason=" + discountReason + "&addBed=" + addBed + "&addBedPrice=" + addBedPrice +
						"&orderMoney=" + orderMoney + "&operatorId=" + operatorId + "&remark=" + remark + "&make=2";

					$.post(baseUrl + '/InsertAndUpdateServlet', params, function(data) {
						if(data === '1') {
							layer.alert('修改登记单成功！', {
								title: '修改成功',
								icon: 6,
								shade: 0.6,
								anim: 3,
								offset: '0px'
							});
						} else {
							layer.alert('修改登记单失败！', {
								title: '修改失败',
								icon: 2,
								shade: 0.6,
								anim: 6,
								offset: '0px'
							});
						}
					});
					return false;
				});
			});
		</script>
	</body>

</html>