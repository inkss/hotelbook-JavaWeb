package com.inks.hb.orderinfo.pojo;

import com.inks.hb.roomtype.pojo.RoomType;

public class OrderInfo {

    private String orderId; //预订单号

    private String orderName; //预定人

    private String orderPhone; //联系电话

    private RoomType typeId; //房间类型

    private String arrireDate; //抵店时间

    private String leaveDate; //离店时间

    private String orderState; //单据状态

    private String checkNum; //入住人数

    private String roomId; //客房编号

    private String price; //客房价格

    private String checkPrice; //入住价格

    private int discount; //折扣

    private String discountReason; //折扣原因

    private String addBed; //是否加床

    private String addBedPrice; //加床价格

    private String orderMoney; //预收款

    private String remark; //备注

    private String operatorId; //操作员
}
