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
							<input class="layui-input" id="inputSearch" placeholder="房间类型">
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
			layui.use(['util', 'layer', 'table'], function() {
				$(document).ready(function() {
					var table = layui.table,
						layer = layui.layer,
						util = layui.util;
					var countNum;
					var tableIns = table.render({
						elem: '#tableID',
						id: 'tableID',
						url: baseUrl + '/RoomTypeServlet',
						cols: [
							[{
								field: 'typeId',
								title: 'ID',
								sort: true,
								fixed: true,
                                width: 150
							}, {
								field: 'typeName',
								title: '类型名称'
							}, {
								field: 'price',
								title: '价格'
							}, {
								field: 'splicPrice',
								title: '拼房价格'
							}, {
								field: 'exceedance',
								title: '可超预定数'
							}, {
								field: 'isSplice',
								title: '是否可拼房'
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
						var typeId = data.typeId;
						var typeName = data.typeName;
						var price = data.price;
						var splicPrice = data.splicPrice;
						var exceedance = data.exceedance;
						var isSplice = data.isSplice;

						if(layEvent === 'detail') {
							layer.alert(
								'ID：' + typeId + '<br>类型名称：' + typeName + '<br>价格：' + price +
								'<br>拼房价格：' + splicPrice + '<br>可超预定数：' + exceedance + '<br>是否可拼房：' + isSplice, {
									skin: 'layui-layer-lan',
									closeBtn: 0,
									title: '您当前选择的房间类型信息',
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
										typeId: typeId
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
							//编辑
							layer.prompt({
								title: '请输入类型名称',
								formType: 0,
								value: typeName,
								offset: '220px',
								maxlength: 10
							}, function(NewTypeName, index) {
								var params = "new=" + NewTypeName + "&old=" + typeName;
								$.post(baseUrl + '/QueryRoomTypeNameServlet', params, function(data) {
									if(data === "1" || data === "2") {
										if(NewTypeName.length < 3)
											layer.alert('长度不符合！', {
												title: '警告',
												icon: 4,
												anim: 6,
												offset: '220px'
											});
										else {
											layer.close(index);
											layer.prompt({
												title: '请输入价格',
												formType: 0,
												value: price,
												offset: '220px',
												maxlength: 10
											}, function(NewPrice, index) {
												if(isNaN(NewPrice)) {
													layer.msg('您所输入的值类型不合法', {
														offset: '250px'
													});
												} else {
													layer.close(index);
													layer.prompt({
														title: '请输入拼房价格',
														formType: 0,
														value: splicPrice,
														offset: '220px',
														maxlength: 10
													}, function(NewSplicPrice, index) {
														if(isNaN(NewSplicPrice)) {
															layer.msg('您所输入的值类型不合法', {
																offset: '250px'
															});
														} else {
															layer.close(index);
															layer.prompt({
																title: '请输入可超预定数',
																formType: 0,
																value: exceedance,
																offset: '220px',
																maxlength: 10
															}, function(NewExceedance, index) {
																if(isNaN(NewExceedance)) {
																	layer.msg('您所输入的值类型不合法', {
																		offset: '250px'
																	});
																} else {
																	layer.close(index);
																	layer.prompt({
																		title: '是否可拼房（Y/N）',
																		formType: 0,
																		value: isSplice,
																		offset: '220px',
																		maxlength: 10
																	}, function(NewIsSplice, index) {
																		if(NewIsSplice.valueOf() === "Y" || NewIsSplice.valueOf() === "N") {
																			tableIns.reload({
																				where: {
																					make: 2,
																					typeId: typeId,
																					typeName: NewTypeName,
																					price: NewPrice,
																					splicPrice: NewSplicPrice,
																					exceedance: NewExceedance,
																					isSplice: NewIsSplice
																				}
																			});
																			layer.close(index);
																		} else {
																			layer.msg('您所输入的值类型不合法', {
																				offset: '260px'
																			});
																		}
																	});
																}
															});
														}
													});
												}
											});
										}
									} else {
										layer.alert('已存在同名项！', {
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
							layer.msg('搜索结果', {
								offset: '250px'
							});
							table.reload('tableID', {
								where: {
									make: 3,
									typeName: inputTxt
								}
							})
						}
					});

					//刷新
					$('#refreshButton').click(function() {
						// 简述此处存在的BUG 删除操作触发外键依赖后，出500异常
						// 通过msg回传参数，尔后执行刷新操作时，框架本身死掉
						// 即往后端传入的分页参数固定为1，表格的重载刷新失效
						// 暂时只发现删除引起的异常，先通过强制刷新解决此处异常
						// tableIns.reload({
						// 	where: {
						// 		make: 0,
						// 		page: 1
						// 	}
						// });
						location.reload();
					});

					//新增
					$('#insertButton').click(function() {
						layer.open({
							title: "新增",
							btn: ['关闭'],
							yes: function(index) {
								tableIns.reload({
									where: {
										make: 0
									}
								});
								layer.close(index); //关闭弹窗
							},
							type: 2,
							area: ['780px', '450px'],
							fixed: false,
							maxmin: true,
							content: '/hb/webpage/SystemSetting/insertRomeType.jsp',
							cancel: function() {
								tableIns.reload({
									where: {
										make: 0
									}
								});
							}
						});
					});

					//导出
					$('#toXlsButton').click(function() {
						location.href = baseUrl + '/RoomInfoExcelServlet';
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