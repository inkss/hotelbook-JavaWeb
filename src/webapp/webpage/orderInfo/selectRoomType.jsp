<%@ page contentType="text/html;charset=UTF-8" %>
<html>

	<head>
		<meta charset="utf-8">
		<link rel="stylesheet" href="../../js/layui/css/layui.css" media="all">
		<script src="../../js/layui/layui.js"></script>
		<script src="../../js/jquery.js"></script>
		<script src="../../js/global.js"></script>
		<style>
			.fixDiv {
				position: sticky;
				bottom: 0;
				background-color: white;
				BORDER-BOTTOM: #e1e1e1 1px solid;
				BORDER-TOP: #e1e1e1 1px solid;
				BORDER-RIGHT: #e1e1e1 1px solid;
				BORDER-LEFT: #e1e1e1 1px solid;
				border-radius: 10px
			}
		</style>
	</head>

	<body>
		<table id="dataTable" class='layui-table'>
			<tr>
				<th>ID</th>
				<th>类型名称</th>
				<th>价格</th>
				<th>拼房价格</th>
				<th>可超预定数</th>
				<th>是否可拼房</th>
			</tr>
		</table>
		<div class="fixDiv">
			<label class="layui-form-label">当前选中：</label>
			<div class="layui-input-inline">
				<input type="text" id="tId" class="layui-input" placeholder="ID" readonly>
			</div>
			<div class="layui-input-inline">
				<input type="text" id="tPrice" class="layui-input" placeholder="价格" readonly>
			</div>
		</div>

		<script>
			//网页加载完毕
			$(document).ready(function() {

				//发出ajax请求，调用后端数据
				$.getJSON(baseUrl + '/selectRomeTypeIdServlet', function(data) {

					//遍历响应的json数组

					$.each(data, function(index, el) {
						var tId = el.typeId;
						var tPrice = el.price;
						var html = '';
						html += '<tr onclick="tId.value=\'' + tId + '\',tPrice.value=\'' + tPrice + '\'" >';
						html += '	<td>' + el.typeId + '</td>';
						html += '	<td>' + el.typeName + '</td>';
						html += '	<td>' + el.price + '</td>';
						html += '	<td>' + el.splicPrice + '</td>';
						html += '	<td>' + el.exceedance + '</td>';
						html += '	<td>' + el.isSplice + '</td>';
						html += '</tr>';

						//追加到表格中
						$('#dataTable').append(html);

					});

				});
			});
		</script>
	</body>

</html>