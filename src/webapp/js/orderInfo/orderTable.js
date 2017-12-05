layui.use(['util', 'layer', 'table'], function() {
	$(document).ready(function() {
		var table = layui.table,
			layer = layui.layer,
			util = layui.util;
		var countNum;
		var tableIns = table.render({
			elem: '#tableID',
			id: 'tableID',
			url: baseUrl + '/OrderInfoServlet',
			cols: [
				[{
					field: 'orderId',
					title: '预定单号',
                    width: 180,
					sort: true,
					fixed: true
				}, {
					field: 'orderName',
					title: '预定人',
                    sort: true,
                    width: 180
				}, {
					field: 'orderPhone',
					title: '预定电话',
                    width: 180
				}, {
					field: 'orderIDcard',
					title: '身份证',
                    width: 200
				}, {
					field: 'arrireDate',
					title: '抵店时间',
                    width: 180
				}, {
                    field: 'leaveDate',
                    title: '离店时间',
                    width: 180
                }, {
                    field: 'typeId',
                    title: '房间类型',
                    sort: true,
                    width: 180
                }, {
                    field: 'checkNum',
                    title: '入住人数',
                    width: 100
                }, {
                    field: 'price',
                    title: '客房价格',
                    width: 100
                }, {
                    field: 'checkPrice',
                    title: '入住价格',
                    width: 100
                }, {
                    field: 'discount',
                    title: '折扣',
                    width: 100
                }, {
                    field: 'discountReason',
                    title: '折扣原因',
                    width: 180
                }, {
                    field: 'addBed',
                    title: '是否加床',
                    sort: true,
                    width: 100
                }, {
                    field: 'addBedPrice',
                    title: '加床价格',
                    width: 100
                }, {
                    field: 'orderMoney',
                    title: '预收款',
                    width: 100
                }, {
                    field: 'orderState',
                    title: '单据状态',
                    sort: true,
                    width: 100
                }, {
                    field: 'remark',
                    title: '备注',
                    width: 400
                }, {
                    field: 'operatorId',
                    title: '操作员',
                    sort: true,
                    width: 100
				}, {
					field: 'right',
					title: '管理',
					align: 'center',
					toolbar: '#barAuth',
					width: 200,
                    fixed: 'right'
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
			var orderId = data.orderId;

			if(layEvent === 'detail') {
				layer.alert(
					'别闹，左边就是', {
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
                            orderId: orderId
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


			}
		});

		//搜索
		$('#searchButton1').click(function() {

		});

        $('#searchButton2').click(function() {

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

		//导出
		$('#toXlsButton').click(function() {

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