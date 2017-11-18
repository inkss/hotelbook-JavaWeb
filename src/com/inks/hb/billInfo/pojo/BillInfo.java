package com.inks.hb.billInfo.pojo;

public class BillInfo {

    private int billId;

    private String checkedId;

    private String costMoney;

    private String costDate;

    private String remark;

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

    @Override
    public String toString() {
        return "BillInfo{" +
                "billId=" + billId +
                ", checkedId='" + checkedId + '\'' +
                ", costMoney='" + costMoney + '\'' +
                ", costDate='" + costDate + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
