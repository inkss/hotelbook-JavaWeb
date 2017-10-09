/**
 * [插件]自定义是否需要自动隐藏桌面图标（默认不隐藏）
 * [适用版本]v1.1.2.3以及之前的所有版本
 * [引入]在引入win10.js后引入该js
 * 使用：请于Win10.onReady中使用该函数
 * Win10.enabledShortcutsHidden() //自动隐藏
 * Win10.disabledShortcutsHidden() //禁用自动隐藏
 *
 *
 * @version v1.0
 * @author yuri2
 * */

Win10.onReady(function () {
    var hide=Win10._hideShortcut;
    var show=Win10._showShortcut;
    Win10._isShortcutsHidden=false;
    Win10.enabledShortcutsHidden=function () {
        Win10._isShortcutsHidden=true;
    };
    Win10.disabledShortcutsHidden=function () {
        Win10._isShortcutsHidden=false;
    };
    Win10._hideShortcut=function () {
        if (Win10._isShortcutsHidden){
            hide();
        }
    };
    Win10._showShortcut=function () {
        if (Win10._isShortcutsHidden){
            show();
        }
    };
});