//自定义js

//从cookie读取登录用户
var loginName = getCookie("loginName");
var isLogin = getCookie("isLogin");
var loginNickName = getCookie("loginNickName");
var loginAdmin = getCookie("loginAdmin");

if (isLogin == null)
    setCookie("isLogin","0");   //表示第一次登录

Win10.onReady(function () {
    //设置壁纸
    Win10.setBgUrl({
        main: './img/wallpapers/main.jpg',
        mobile: './img/wallpapers/mobile.jpg',
    });

    //Animated动画 地址：https://daneden.github.io/animate.css
    Win10.setAnimated([
        'animated flip',
        'animated bounceIn',
    ], 0.01);

    //发送一条消息
    setTimeout(function () {
        isLogin = getCookie("isLogin");
        if  (isLogin == 0) {
            Win10.newMsg('欢迎登录',
                '欢迎用户"' + loginNickName + '"的登录。');
            setCookie("isLogin","1")
        }else {
            Win10.newMsg('欢迎回来',
                '你好' + loginNickName +'，欢迎回来。');
        }
    }, 2500);

});