
$(function () {

    //此处预定义了背景数据，其实可以用ajax获取
    var themes = [
        {
            "pic": "./plugins/theme_switcher/bg/bg1.jpg",
            "thumb": "./bg/bg1_small.jpg",
            "title": "win10"
        },
        {
            "pic": "./plugins/theme_switcher/bg/bg2.jpg",
            "thumb": "./bg/bg2_small.jpg",
            "title": "梦幻光影"
        },
        {
            "pic": "./plugins/theme_switcher/bg/bg3.jpg",
            "thumb": "./bg/bg3_small.jpg",
            "title": "扬帆起航"
        },
        {
            "pic": "./plugins/theme_switcher/bg/bg4.jpg",
            "thumb": "./bg/bg4_small.jpg",
            "title": "乡土气息"
        },
        {
            "pic": "./plugins/theme_switcher/bg/bg5.jpg",
            "thumb": "./bg/bg5_small.jpg",
            "title": "绿色清新"
        },
        {
            "pic": "./plugins/theme_switcher/bg/bg6.jpg",
            "thumb": "./bg/bg6_small.jpg",
            "title": "Win8"
        },
        {
            "pic": "./plugins/theme_switcher/bg/bg7.jpg",
            "thumb": "./bg/bg7_small.jpg",
            "title": "蓝色海岸"
        },
        {
            "pic": "./plugins/theme_switcher/bg/bg8.jpg",
            "thumb": "./bg/bg8_small.jpg",
            "title": "冰天雪地"
        },
        {
            "pic": "./plugins/theme_switcher/bg/bg9.jpg",
            "thumb": "./bg/bg9_small.jpg",
            "title": "繁花满树"
        },
        {
            "pic": "./plugins/theme_switcher/bg/bg10.jpg",
            "thumb": "./bg/bg10_small.jpg",
            "title": "精灵小鸟"
        },
        {
            "pic": "./plugins/theme_switcher/bg/bg11.jpg",
            "thumb": "./bg/bg11_small.jpg",
            "title": "炫酷跑车"
        },
        {
            "pic": "./plugins/theme_switcher/bg/bg12.jpg",
            "thumb": "./bg/bg12_small.jpg",
            "title": "中国风"
        },
        {
            "pic": "./plugins/theme_switcher/bg/bg13.jpg",
            "thumb": "./bg/bg13_small.jpg",
            "title": "Winxp"
        },
        {
            "pic": "./plugins/theme_switcher/bg/bg14.jpg",
            "thumb": "./bg/bg14_small.jpg",
            "title": "淡雅唯美"
        },
        {
            "pic": "./plugins/theme_switcher/bg/bg15.jpg",
            "thumb": "./bg/bg15_small.jpg",
            "title": "Win7"
        },
    ];

    var theme_area=$("#theme_area");
    theme_area.on('click','.theme_setting',function () {
        var pic=$(this).data('pic');
        Win10_parent.setBgUrl({main:pic});

        //此处你也许想用ajax把修改信息保存到服务器。。。

    });




    themes.forEach(function (t) {
        var theme=$("<a href=\"javascript:;\" data-pic=\""+t.pic+"\" class=\"theme_setting \">\n" +
            "            <div class=\"theme_icon\"><img src=\""+t.thumb+"\"></div>\n" +
            "            <div class=\"theme_text\">"+t.title+"</div>\n" +
            "        </a>");
        theme_area.append(theme)
    });


});
