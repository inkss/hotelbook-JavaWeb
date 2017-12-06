package com.inks.hb.orderinfo.pojo;

/**
 * 怎么的呢
 * 这个类将关联类换成了String
 * 并且去掉了前端不需要的字段
 * 都怪数据库设计时不仔细呀
 */
public class OrderToTable {

    private String orderId; //预订单号->直接获取时间戳?存进去 1

    private String orderName; //预定人 2

    private String orderPhone; //联系电话 3

    private String orderIDcard; // 4

    private String arrireDate; //抵店时间 5

    private String leaveDate; //离店时间 6

    private String typeId; //房间类型->对应roomtype表 7<-------------------

    private String checkNum; //入住人数 8

    private String price; //客房价格 9

    private String checkPrice; //入住价格 10

    private int discount; //折扣 11<-------------------

    private String discountReason; //折扣原因 12

    private String addBed; //是否加床 13

    private String addBedPrice; //加床价格 14

    private String orderMoney; //预收款 15

    private String orderState; //单据状态->该字段前端做下拉框写死 16

    private String remark; //备注 17

    private String operatorId; //操作员->登录 19<-------------------

    public OrderToTable(String orderId, String orderName, String orderPhone, String orderIDcard, String arrireDate, String leaveDate, String typeId, String checkNum, String price, String checkPrice, int discount, String discountReason, String addBed, String addBedPrice, String orderMoney, String orderState, String remark, String operatorId) {
        this.orderId = orderId;
        this.orderName = orderName;
        this.orderPhone = orderPhone;
        this.orderIDcard = orderIDcard;
        this.arrireDate = arrireDate;
        this.leaveDate = leaveDate;
        this.typeId = typeId;
        this.checkNum = checkNum;
        this.price = price;
        this.checkPrice = checkPrice;
        this.discount = discount;
        this.discountReason = discountReason;
        this.addBed = addBed;
        this.addBedPrice = addBedPrice;
        this.orderMoney = orderMoney;
        this.orderState = orderState;
        this.remark = remark;
        this.operatorId = operatorId;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public String getOrderPhone() {
        return orderPhone;
    }

    public String getOrderIDcard() {
        return orderIDcard;
    }

    public String getArrireDate() {
        return arrireDate;
    }

    public String getLeaveDate() {
        return leaveDate;
    }

    public String getTypeId() {
        return typeId;
    }

    public String getCheckNum() {
        return checkNum;
    }

    public String getPrice() {
        return price;
    }

    public String getCheckPrice() {
        return checkPrice;
    }

    public int getDiscount() {
        return discount;
    }

    public String getDiscountReason() {
        return discountReason;
    }

    public String getAddBed() {
        return addBed;
    }

    public String getAddBedPrice() {
        return addBedPrice;
    }

    public String getOrderMoney() {
        return orderMoney;
    }

    public String getOrderState() {
        return orderState;
    }

    public String getRemark() {
        return remark;
    }

    public String getOperatorId() {
        return operatorId;
    }

    @Override
    public String toString() {
        return "OrderToTable{" +
                "orderId='" + orderId + '\'' +
                ", orderName='" + orderName + '\'' +
                ", orderPhone='" + orderPhone + '\'' +
                ", orderIDcard='" + orderIDcard + '\'' +
                ", arrireDate='" + arrireDate + '\'' +
                ", leaveDate='" + leaveDate + '\'' +
                ", typeId='" + typeId + '\'' +
                ", checkNum='" + checkNum + '\'' +
                ", price='" + price + '\'' +
                ", checkPrice='" + checkPrice + '\'' +
                ", discount=" + discount +
                ", discountReason='" + discountReason + '\'' +
                ", addBed='" + addBed + '\'' +
                ", addBedPrice='" + addBedPrice + '\'' +
                ", orderMoney='" + orderMoney + '\'' +
                ", orderState='" + orderState + '\'' +
                ", remark='" + remark + '\'' +
                ", operatorId='" + operatorId + '\'' +
                '}';
    }
}
