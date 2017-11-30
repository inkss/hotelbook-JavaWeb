package com.july.hb.bill.pojo;

public class BillInfo {

    private int billId;

    private String checkedId;

    private String costMoney;

    private String costDate;

    private String remark;

    private boolean isNull;

    public BillInfo() {
    }

    public BillInfo(int billId, String checkedId, String costMoney, String costDate, String remark) {
        this.billId = billId;
        this.checkedId = checkedId;
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

    public String getCheckedId() {
        return checkedId;
    }

    public void setCheckedId(String checkedId) {
        this.checkedId = checkedId;
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
                ", checkedId='" + checkedId + '\'' +
                ", costMoney='" + costMoney + '\'' +
                ", costDate='" + costDate + '\'' +
                ", remark='" + remark + '\'' +
                ", isNull=" + isNull +
                '}';
    }
}
