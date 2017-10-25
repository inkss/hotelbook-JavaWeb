
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