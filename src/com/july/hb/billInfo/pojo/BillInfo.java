package com.july.hb.billInfo.pojo;

public class BillInfo {

    private int billId;
    private String checkId;
    private String costMoney;
    private String costDate;
    private String remark;

    private boolean isNull;

    public BillInfo() {
    }

    public BillInfo(int billId, String checkId, String costMoney, String costDate, String remark) {
        this.billId = billId;
        this.checkId = checkId;
        this.costMoney = costMoney;
        this.costDate = costDate;
        this.remark = remark;
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public String getCheckId() {
        return checkId;
    }

    public void setCheckId(String checkId) {
        this.checkId = checkId;
    }

    public String getCostMoney() {
        return costMoney;
    }

    public void setCostMoney(String costMoney) {
        this.costMoney = costMoney;
    }

    public String getCostDate() {
        return costDate;
    }

    public void setCostDate(String costDate) {
        this.costDate = costDate;
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
        return "BillInfo{" +
                "billId=" + billId +
                ", checkId='" + checkId + '\'' +
                ", costMoney='" + costMoney + '\'' +
                ", costDate='" + costDate + '\'' +
                ", remark='" + remark + '\'' +
                ", isNull=" + isNull +
                '}';
    }
}
