package com.inks.hb.orderinfo.pojo;

import com.inks.hb.login.pojo.Login;
import com.inks.hb.roomtype.pojo.RoomType;

/**
 * 预订单
 * 字段太多了，只提供空参构造器
 */
public class OrderInfo {

    private String orderId; //预订单号->直接获取时间戳?存进去 1

    private String orderName; //预定人 2

    private String orderPhone; //联系电话 3

    private String orderIDcard; // 4

    private RoomType typeId; //房间类型->对应roomtype表 5<-------------------

    private String arrireDate; //抵店时间 6

    private String leaveDate; //离店时间 7

    private String orderState; //单据状态->该字段前端做下拉框写死 8

    private String checkNum; //入住人数 9

    private String roomId; //客房编号->预订单不一定实际分配，预定转入住时才可以 10

    private String price; //客房价格 11

    private String checkPrice; //入住价格 12

    private int discount; //折扣 13<-------------------

    private String discountReason; //折扣原因 14

    private String addBed; //是否加床 15

    private String addBedPrice; //加床价格 16

    private String orderMoney; //预收款 17

    private String remark; //备注 18

    private Login operatorId; //操作员->登录 19<-------------------

    private boolean isNull; //是否为空值对象 20

    public OrderInfo() {
        super();
    }

    public OrderInfo(String orderId, String orderName, String orderPhone, String orderIDcard, RoomType typeId, String arrireDate, String leaveDate, String orderState, String checkNum, String roomId, String price, String checkPrice, int discount, String discountReason, String addBed, String addBedPrice, String orderMoney, String remark, Login operatorId) {
        this.orderId = orderId;
        this.orderName = orderName;
        this.orderPhone = orderPhone;
        this.orderIDcard = orderIDcard;
        this.typeId = typeId;
        this.arrireDate = arrireDate;
        this.leaveDate = leaveDate;
        this.orderState = orderState;
        this.checkNum = checkNum;
        this.roomId = roomId;
        this.price = price;
        this.checkPrice = checkPrice;
        this.discount = discount;
        this.discountReason = discountReason;
        this.addBed = addBed;
        this.addBedPrice = addBedPrice;
        this.orderMoney = orderMoney;
        this.remark = remark;
        this.operatorId = operatorId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getOrderPhone() {
        return orderPhone;
    }

    public void setOrderPhone(String orderPhone) {
        this.orderPhone = orderPhone;
    }

    public String getOrderIDcard() {
        return orderIDcard;
    }

    public void setOrderIDcard(String orderIDcard) {
        this.orderIDcard = orderIDcard;
    }

    public RoomType getTypeId() {
        return typeId;
    }

    public void setTypeId(RoomType typeId) {
        this.typeId = typeId;
    }

    public String getArrireDate() {
        return arrireDate;
    }

    public void setArrireDate(String arrireDate) {
        this.arrireDate = arrireDate;
    }

    public String getLeaveDate() {
        return leaveDate;
    }

    public void setLeaveDate(String leaveDate) {
        this.leaveDate = leaveDate;
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    public String getCheckNum() {
        return checkNum;
    }

    public void setCheckNum(String checkNum) {
        this.checkNum = checkNum;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCheckPrice() {
        return checkPrice;
    }

    public void setCheckPrice(String checkPrice) {
        this.checkPrice = checkPrice;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getDiscountReason() {
        return discountReason;
    }

    public void setDiscountReason(String discountReason) {
        this.discountReason = discountReason;
    }

    public String getAddBed() {
        return addBed;
    }

    public void setAddBed(String addBed) {
        this.addBed = addBed;
    }

    public String getAddBedPrice() {
        return addBedPrice;
    }

    public void setAddBedPrice(String addBedPrice) {
        this.addBedPrice = addBedPrice;
    }

    public String getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(String orderMoney) {
        this.orderMoney = orderMoney;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Login getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Login operatorId) {
        this.operatorId = operatorId;
    }

    public boolean isNull() {
        return isNull;
    }

    public void setNull(boolean aNull) {
        isNull = aNull;
    }

    @Override
    public String toString() {
        return "OrderInfo{" +
                "orderId='" + orderId + '\'' +
                ", orderName='" + orderName + '\'' +
                ", orderPhone='" + orderPhone + '\'' +
                ", orderIDcard='" + orderIDcard + '\'' +
                ", typeId=" + typeId +
                ", arrireDate='" + arrireDate + '\'' +
                ", leaveDate='" + leaveDate + '\'' +
                ", orderState='" + orderState + '\'' +
                ", checkNum='" + checkNum + '\'' +
                ", roomId='" + roomId + '\'' +
                ", price='" + price + '\'' +
                ", checkPrice='" + checkPrice + '\'' +
                ", discount=" + discount +
                ", discountReason='" + discountReason + '\'' +
                ", addBed='" + addBed + '\'' +
                ", addBedPrice='" + addBedPrice + '\'' +
                ", orderMoney='" + orderMoney + '\'' +
                ", remark='" + remark + '\'' +
                ", operatorId=" + operatorId +
                ", isNull=" + isNull +
                '}';
    }
}
