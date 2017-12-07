package com.inks.hb.orderinfo.service;

import com.inks.hb.orderinfo.pojo.OrderInfo;

import java.util.ArrayList;

public interface OrderInfoService {

    /**
     * 插入一条数据
     *
     * @param orderInfo 预订单
     * @return -1失败 0重名 1成功
     */
    int insertOrderInfo(OrderInfo orderInfo);

    //删除
    int deleteOrderInfo(String orderId);

    //更新
    int updateOrderInfo(OrderInfo orderInfo);

    //查询单条
    OrderInfo query(String orderId);

    //查询多条
    ArrayList query(int page, int limit);

    //查询长度
    int queryOrderInfoNum();

    //俩查询 1：查名称 2：查类型
    ArrayList queryOrder(int make, String select);

    /**
     * 查重函数
     *
     * @param newName oldName 房间类型名称
     * @return 0:已经存在 1：未存在 2：与自身相同
     */
    int queryRepeat(String newName, String oldName);
}

