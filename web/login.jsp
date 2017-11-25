<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<meta charset="UTF-8"/>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>酒店管理系统</title>
<link rel="stylesheet" type="text/css" href="css/normalize.css"/>
<link rel="stylesheet" type="text/css" href="css/demo.css"/>
<link rel="stylesheet" type="text/css" href="css/login.css"/>
<script src="js/html5.js"></script>

</head>


<body>
<div class="container demo-1">
    <div class="content">
        <div id="large-header" class="large-header">
            <canvas id="demo-canvas"></canvas>
            <div class="logo_box">
                <h3>Starry Hotel</h3>
                <form action="#" name="f" method="post">
                    <div class="username">
                        <span class="img1"></span>
                        <input name="logname" id="loginName" class="text" style="color: #FFFFFF !important" type="text"
                               placeholder="请输入账户">
                    </div>
                    <div class="pwd">
                        <span class="img2"></span>
                        <input name="password" id="loginPwd" class="text"
                               style="color: #FFFFFF !important; position:absolute; z-index:100;" value=""
                               type="password" placeholder="请输入密码">
                    </div>
                    <div class="button" id="btnLogin">
                        <a class="but" href="javascript:;" style="color: #FFFFFF">Sign In</a>
                    </div>
                </form>
                <div id="footer">
                    <a href="register.html">
                        No account number? Sign up for one.
                    </a>
                </div>
            </div>
        </div>
    </div>
</div>


<!-- /container -->
<script src="js/global.js"></script>
<script src="js/TweenLite.min.js"></script>
<script src="js/EasePack.min.js"></script>
<script src="js/rAF.js"></script>
<script src="js/demo-1.js"></script>
<script src="js/layui/layui.js"></script>
<script src="js/jquery.js"></script>
<script type="text/javascript" src="./js/Cookie.js"></script>
<script type="text/javascript" src="MAIN/js/win10.child.js"></script>

<script>
    //模块化调用layui
    layui.use(['layer'], function () {
        var layer = layui.layer;
        $(document).ready(function () {
            //alert("网页加载完毕");

            //按钮点击事件
            $('#btnLogin').click(function () {
                //alert("按钮被点击");

                loginName = $('#loginName').val();
                var loginPwd = $('#loginPwd').val();
                var params = "loginName=" + loginName + "&loginPwd=" + loginPwd;

                if (loginName === "")
                    layer.tips("请输入用户名", "#loginName"); //layer.tips(“string","#吸附容器")
                else if (loginPwd === "")
                    layer.tips("请输入密码", "#loginPwd");
                else {
                    //发出ajax请求，调用后端功能
                    $.post(baseUrl + '/QueryLoginNameServlet', params, function (data) {
                        if (data === '-1')
                            layer.msg("用户名不存在", {
                                anim: 6
                            });
                        else if (data === '0')
                            layer.msg("密码不正确", {
                                anim: 6
                            });
                        else {
                            layer.msg('登录成功', {
                                icon: 16,
                                shade: 0.01
                            });

                            //根据写入的session值得到结果
                            $.post(baseUrl + '/QueryLoginInfoServlet', function (loginInfo) {

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

                            setTimeout(function () {
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