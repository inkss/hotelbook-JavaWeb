package com.inks.hb.authInfo.pojo;

import java.util.ArrayList;

/**
 * 方便toJson
 * 表格使用
 *
 */
public class AuthINfotoJson {

    private String code; //数据状态字段

    private String msg; //状态字段名

    private String count; //数据总数

    private ArrayList<AuthInfo> data; //数据

    public AuthINfotoJson(String code, String msg, String count, ArrayList<AuthInfo> authInfo) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = authInfo;
    }
}
