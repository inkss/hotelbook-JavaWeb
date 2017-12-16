package com.july.hb.checkin.pojo;

public class CheckinInfo {

    private String checkId; //入住单号
    private String checkName; //入住人
    private String checkPhone; //入住人电话
    private String checkIDcard; //身份证
    private String arriveTime; //抵店时间
    private String leaveTime; //离店时间
    private String checkNum; //入住人数
    private String floorId; //楼层类型
    private String typeId; //房间类型
    private String roomId; //房号
    private String price; //客房价格
    private String checkPrice; //入住价格
    private String discount; //折扣
    private String orderMoney; //预收款
    private String money; //应收款
    private String checkState; //单据状态
    private String isCheck; //是否结账
    private String checkMoney; //结张金额
    private String checkoutDate; //结账日期
    private String remark; //备注

    private boolean isNull;

    public CheckinInfo() {
    }

    public CheckinInfo(String checkId, String checkName, String checkPhone, String checkIDcard, String arriveTime, String leaveTime, String checkNum, String floorId, String typeId, String roomId, String price, String checkPrice, String discount, String orderMoney, String money, String checkState, String isCheck, String checkMoney, String checkoutDate, String remark) {
        this.checkId = checkId;
        this.checkName = checkName;
        this.checkPhone = checkPhone;
        this.checkIDcard = checkIDcard;
        this.arriveTime = arriveTime;
        this.leaveTime = leaveTime;
        this.checkNum = checkNum;
        this.floorId = floorId;
        this.typeId = typeId;
        this.roomId = roomId;
        this.price = price;
        this.checkPrice = checkPrice;
        this.discount = discount;
        this.orderMoney = orderMoney;
        this.money = money;
        this.checkState = checkState;
        if (isCheck == null)
            isCheck = "否";
        this.isCheck = isCheck;
        this.checkMoney = checkMoney;
        if (checkoutDate == null)
            checkoutDate = leaveTime;
        this.checkoutDate = checkoutDate;
        this.remark = remark;
    }

    public String getCheckId() {
        return checkId;
    }

    public void setCheckId(String checkId) {
        this.checkId = checkId;
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

    public String getCheckNum() {
        return checkNum;
    }

    public void setCheckNum(String checkNum) {
        this.checkNum = checkNum;
    }

    public String getFloorId() {
        return floorId;
    }

    public void setFloorId(String floorId) {
        this.floorId = floorId;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
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

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
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

    public String getCheckState() {
        return checkState;
    }

    public void setCheckState(String checkState) {
        this.checkState = checkState;
    }

    public String getIsCheck() {
        return isCheck;
    }

    public void setIsCheck(String isCheck) {
        if (isCheck == null)
            isCheck = "否";
        this.isCheck = isCheck;
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
        if (checkoutDate == null)
            checkoutDate = leaveTime;
        this.checkoutDate = checkoutDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
                ", checkName='" + checkName + '\'' +
                ", checkPhone='" + checkPhone + '\'' +
                ", checkIDcard='" + checkIDcard + '\'' +
                ", arriveTime='" + arriveTime + '\'' +
                ", leaveTime='" + leaveTime + '\'' +
                ", checkNum='" + checkNum + '\'' +
                ", floorId='" + floorId + '\'' +
                ", typeId='" + typeId + '\'' +
                ", roomId='" + roomId + '\'' +
                ", price='" + price + '\'' +
                ", checkPrice='" + checkPrice + '\'' +
                ", discount='" + discount + '\'' +
                ", orderMoney='" + orderMoney + '\'' +
                ", money='" + money + '\'' +
                ", checkState='" + checkState + '\'' +
                ", isCheck='" + isCheck + '\'' +
                ", checkMoney='" + checkMoney + '\'' +
                ", checkoutDate='" + checkoutDate + '\'' +
                ", remark='" + remark + '\'' +
                ", isNull=" + isNull +
                '}';
    }
}
