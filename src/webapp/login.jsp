<%@ page contentType="text/html;charset=UTF-8" %>
<html>

	<head>
		<meta charset="utf-8">
		<title>酒店管理系统</title>
		<link rel="stylesheet Icon" type=" image/x-icon" href="img/windows.ico">
		<link rel="stylesheet" type="text/css" href="css/login/register-login.css">
		<script src="./js/global.js"></script>
	</head>

	<body>

		<div id="box"></div>

		<!--主栏-->
		<div class="cent-box">
			<!--标题-->
			<div class="cent-box-header">
				<h1 class="main-title">HotelBook</h1>
				<h2 class="sub-title">酒店管理系统</h2>
			</div>

			<div class="cont-main clearfix">

				<!--登录区域开始-->
				<div class="login form">
					<!--文本输入框-->
					<div class="group">
						<!--用户名输入框-->
						<div class="group-ipt loginName">
							<input type="text" name="loginName" id="loginName" class="ipt" placeholder="输入您的用户名" required>
						</div>
						<!--密码输入框-->
						<div class="group-ipt loginPwd">
							<input type="password" name="loginPwd" id="loginPwd" class="ipt" placeholder="输入您的登录密码" required>
						</div>
					</div>
					<!--登录按钮-->
					<div class="button" id="btnLogin">
						<button type="submit" class="login-btn register-btn button" id="embed-submit">登录</button>
					</div>
				</div>
				<!--登录区域结束-->
				<!--尾注-->
				<div class="remember clearfix">
					<label class="remember-me">
                <a href="#">获取帮助</a>
            </label>
					<label class="forgot-password">
                <a href="#">忘记密码？</a>
            </label>
				</div>
			</div>
		</div>

		<!--脚注-->
		<div class="footer">
			<p>© 2017
				<a href="#">HotelBook System</a>
			</p>
		</div>

		<script type="text/javascript" src="./js/login/particles.js"></script>
		<script type="text/javascript" src="./js/login/background.js"></script>
		<script type="text/javascript" src="./js/jquery.js"></script>
		<script type="text/javascript" src="./js/layui/layui.js"></script>
		<script type="text/javascript" src="./js/Cookie.js"></script>

		//引入win10的api
		<script type="text/javascript" src="MAIN/js/win10.child.js"></script>

		<script>
			//模块化调用layui
			layui.use(['layer'], function() {
				var layer = layui.layer;
				$(document).ready(function() {
					//alert("网页加载完毕");

					//按钮点击事件
					$('#btnLogin').click(function() {
						//alert("按钮被点击");

						loginName = $('#loginName').val();
						var loginPwd = $('#loginPwd').val();
						var params = "loginName=" + loginName + "&loginPwd=" + loginPwd;

						if(loginName === "")
							layer.tips("请输入用户名", "#loginName"); //layer.tips(“string","#吸附容器")
						else if(loginPwd === "")
							layer.tips("请输入密码", "#loginPwd");
						else {
							//发出ajax请求，调用后端功能
							$.post(baseUrl + '/QueryLoginNameServlet', params, function(data) {
								if(data === '-1')
									layer.msg("用户名不存在", {
										anim: 6
									});
								else if(data === '0')
									layer.msg("密码不正确", {
										anim: 6
									});
								else {
									layer.msg('登录成功', {
										icon: 16,
										shade: 0.01
									});

									//根据写入的session值得到结果
									$.post(baseUrl + '/QueryLoginInfoServlet', function(loginInfo) {

										//数据返回样例
										<%--{"loginId":1,"loginName":"root","loginPwd":"toor","loginNickName":"管理员","loginAdmin":0}--%>

										//取值方法
										var obj = JSON.parse(loginInfo);
										//alert(obj.loginName);
										//alert(obj.loginPwd);
										//alert(obj.loginNickName);
										//alert(obj.loginAdmin);

										//设置cookie
										setCookie("loginName", loginName);
										setCookie("loginNickName", obj.loginNickName);
										setCookie("loginAdmin", obj.loginAdmin);
									});

									setTimeout(function() {
										location.href = 'MAIN/main.html';
									}, 1000); //等待一段时间后跳入
								}
							});
						}
					}); //button
				}); //jquery
			}); //layui
		</script>

	</body>

</html>