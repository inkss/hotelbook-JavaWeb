package com.inks.hb.floorinfo.pojo;

/**
 * 楼层信息
 * 2017.11.23 --------
 * 添加isNull字段，现在可以通过setNull设置元素信息，通过isNull读取信息
 * 原构造函数不变，不提供含该字段的构造函数，该字段应主要用于查询函数（查询函数不返回未实例化的对象）
 * ------------
 */
public class FloorInfo {

    private int floorId; //楼层编号

    private String floorName; //楼层名称

    private boolean isNull; //是否为空值对象

    public FloorInfo() {
        super();
    }

    public FloorInfo(int floorId, String floorName) {
        this.floorId = floorId;
        this.floorName = floorName;
    }

    public int getFloorId() {
        return floorId;
    }

    public void setFloorId(int floorId) {
        this.floorId = floorId;
    }

    public String getFloorName() {
        return floorName;
    }

    public void setFloorName(String floorName) {
        this.floorName = floorName;
    }

    public boolean isNull() {
        return isNull;
    }

    /**
     * 如果为null，则设置为true，否则false
     *
     * @param aNull 对象是否为空
     */
    public void setNull(boolean aNull) {
        isNull = aNull;
    }

    @Override
    public String toString() {
        return "FloorInfo{" +
                "floorId=" + floorId +
                ", floorName='" + floorName + '\'' +
                ", isNull=" + isNull +
                '}';
    }
}
