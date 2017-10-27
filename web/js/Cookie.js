
//设置cookie 销毁时间：会话结束
function setCookie(name,value) {
    document.cookie = name + '=' + value;
}

//读取cookie
function getCookie(name)
{
    var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)"); //正则匹配
    if(arr=document.cookie.match(reg)){
        return unescape(arr[2]);
    }
    else{
        return null;
    }
}

//删除一个cookie

//思路就是将cookie的时间设置成从前，这样浏览器就直接删除了
//我上面用到的设置cookie没有指定销毁时间，是在浏览器关闭时自动删除
//也就是不设置时间的cookie不会存储到硬盘，也就是保存到内存中，随浏览器生存