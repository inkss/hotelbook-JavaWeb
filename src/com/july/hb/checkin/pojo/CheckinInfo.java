package com.july.hb.checkin.pojo;

public class CheckinInfo {

    private String checkId;
    private String orderId;
    private String checkName;
    private String checkPhone;
    private String checkIDcard;
    private String typeId;
    private String arriveTime;
    private String leaveTime;
    private String checkState;
    private Integer checkNum;
    private String roomId;
    private String price;
    private String checkPrice;
    private Integer discount;
    private String discountReason;
    private String addBed;
    private String addBedPrice;
    private String orderMoney;
    private String money;
    private String ifCheckout;
    private String checkMoney;
    private String checkoutDate;
    private String remark;
    private String operatorId;

    private boolean isNull;
    //快捷键 ait+insert 空方法，全参构造器，get，set，tostring等
    public CheckinInfo() {
    }

    public CheckinInfo(String checkId) {
        this.checkId = checkId;
    }

    public CheckinInfo(String checkId, String orderId, String checkName, String checkPhone, String checkIDcard, String typeId, String arriveTime, String leaveTime, String checkState, Integer checkNum, String roomId, String price, String checkPrice, Integer discount, String discountReason, String addBed, String addBedPrice, String orderMoney, String money, String ifCheckout, String checkMoney, String checkoutDate, String remark, String operatorId ) {
        this.checkId = checkId;
        this.orderId = orderId;
        this.checkName = checkName;
        this.checkPhone = checkPhone;
        this.checkIDcard = checkIDcard;
        this.typeId = typeId;
        this.arriveTime = arriveTime;
        this.leaveTime = leaveTime;
        this.checkState = checkState;
        this.checkNum = checkNum;
        this.roomId = roomId;
        this.price = price;
        this.checkPrice = checkPrice;
        this.discount = discount;
        this.discountReason = discountReason;
        this.addBed = addBed;
        this.addBedPrice = addBedPrice;
        this.orderMoney = orderMoney;
        this.money = money;
        this.ifCheckout = ifCheckout;
        this.checkMoney = checkMoney;
        this.checkoutDate = checkoutDate;
        this.remark = remark;
        this.operatorId = operatorId;

    }

    public String getCheckId() {
        return checkId;
    }

    public void setCheckId(String checkId) {
        this.checkId = checkId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCheckName() {
        return checkName;
    }

    public void setCheckName(String checkName) {
        this.checkName = checkName;
    }

    public String getCheckPhone() {
        return checkPhone;
    }

    public void setCheckPhone(String checkPhone) {
        this.checkPhone = checkPhone;
    }

    public String getCheckIDcard() {
        return checkIDcard;
    }

    public void setCheckIDcard(String checkIDcard) {
        this.checkIDcard = checkIDcard;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(String arriveTime) {
        this.arriveTime = arriveTime;
    }

    public String getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(String leaveTime) {
        this.leaveTime = leaveTime;
    }

    public String getCheckState() {
        return checkState;
    }

    public void setCheckState(String checkState) {
        this.checkState = checkState;
    }

    public Integer getCheckNum() {
        return checkNum;
    }

    public void setCheckNum(Integer checkNum) {
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

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
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

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getIfCheckout() {
        return ifCheckout;
    }

    public void setIfCheckout(String ifCheckout) {
        this.ifCheckout = ifCheckout;
    }

    public String getCheckMoney() {
        return checkMoney;
    }

    public void setCheckMoney(String checkMoney) {
        this.checkMoney = checkMoney;
    }

    public String getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(String checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
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
        return "CheckinInfo{" +
                "checkId='" + checkId + '\'' +
                ", orderId='" + orderId + '\'' +
                ", checkName='" + checkName + '\'' +
                ", checkPhone='" + checkPhone + '\'' +
                ", checkIDcard='" + checkIDcard + '\'' +
                ", typeId='" + typeId + '\'' +
                ", arriveTime='" + arriveTime + '\'' +
                ", leaveTime='" + leaveTime + '\'' +
                ", checkState='" + checkState + '\'' +
                ", checkNum='" + checkNum +
                ", roomId='" + roomId + '\'' +
                ", price='" + price + '\'' +
                ", checkPrice='" + checkPrice + '\'' +
                ", discount=" + discount +
                ", discountReason='" + discountReason + '\'' +
                ", addBed='" + addBed + '\'' +
                ", addBedPrice='" + addBedPrice + '\'' +
                ", orderMoney='" + orderMoney + '\'' +
                ", money='" + money + '\'' +
                ", ifCheckout='" + ifCheckout + '\'' +
                ", checkMoney='" + checkMoney + '\'' +
                ", checkoutDate='" + checkoutDate + '\'' +
                ", remark='" + remark + '\'' +
                ", operatorId='" + operatorId + '\'' +
                ", isNull=" + isNull +
                '}';
    }

}
