//自定义js

//存在一种情况，就是在退出系统清除session情况时
//此时点击浏览器的返回按钮，因为页面不会重载和浏览器本身的缓存机制
//页面仍然存在，但是因为session为空，点击一个功能时就会跳转到登录界面
//但是是在框架界面里打开的，所以在登录完成后，就会形成类似俄罗斯套娃的效果
if (window.top == window.self) {
    //alert('页面不是在框架中打开的');
} else {
    //alert('页面是在框架中打开的');
    //所以最简单的方法就是判断主页面是否在框架里，如果在就直接刷新父类界面
    parent.location.reload();
}

//从cookie读取登录用户
var loginName = getCookie("loginName");
var isLogin = getCookie("isLogin");
var loginNickName = getCookie("loginNickName");
var loginAdmin = getCookie("loginAdmin");

if (isLogin == null)
    setCookie("isLogin", "0");   //表示第一次登录

Win10.onReady(function () {
    //设置壁纸
    Win10.setBgUrl({
        main: './img/wallpapers/miaowu.jpg',
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
        loginAdmin = getCookie("loginAdmin");
        if (isLogin == 0) {
            Win10.newMsg('欢迎登录',
                '欢迎用户"' + loginNickName + '"的登录。');
            setCookie("isLogin", "1")
        } else {
            Win10.newMsg('欢迎回来',
                '你好' + loginNickName + '，欢迎回来。');
        }



    }, 2500);


});