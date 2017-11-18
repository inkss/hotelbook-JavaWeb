package com.inks.hb.roomType.pojo;

public class RoomType {

    private String typeId; //类型编号

    private String typeName; //类型名称

    private String price; //价格

    private String splicPrice; //拼房价格

    private int exceedance; //可超预定数

    private String isSplice; //是否可拼房

    public RoomType() {
        super();
    }

    public RoomType(String typeId, String typeName, String price, String splicPrice, int exceedance, String isSplice) {
        this.typeId = typeId;
        this.typeName = typeName;
        this.price = price;
        this.splicPrice = splicPrice;
        this.exceedance = exceedance;
        this.isSplice = isSplice;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSplicPrice() {
        return splicPrice;
    }

    public void setSplicPrice(String splicPrice) {
        this.splicPrice = splicPrice;
    }

    public int getExceedance() {
        return exceedance;
    }

    public void setExceedance(int exceedance) {
        this.exceedance = exceedance;
    }

    public String getIsSplice() {
        return isSplice;
    }

    public void setIsSplice(String isSplice) {
        this.isSplice = isSplice;
    }

    @Override
    public String toString() {
        return "\n--->RoomType对象信息输出：" +
                "\n typeId = " + typeId +
                "\n typeName = '" + typeName + '\'' +
                "\n price = '" + price + '\'' +
                "\n splicPrice = '" + splicPrice + '\'' +
                "\n exceedance = " + exceedance +
                "\n isSplice = " + isSplice +
                "\n--->RoomType信息输出结束\n";
    }
}
