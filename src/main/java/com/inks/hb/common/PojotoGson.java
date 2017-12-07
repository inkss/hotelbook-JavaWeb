package com.inks.hb.common;

import java.util.List;

/**
 * 抽象出一个统一的toJson类
 * 最主要用途是包装ArrayList的各个pojo对象
 */
public class PojotoGson {

    private String code; //数据状态字段

    private String msg; //状态字段名

    private String count; //数据总数

    private List data; //数据

    public PojotoGson(String code, String msg, String count, List data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }

    @Override
    public String toString() {
        return "PojotoGson{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", count='" + count + '\'' +
                ", data=" + data +
                '}';
    }
}
