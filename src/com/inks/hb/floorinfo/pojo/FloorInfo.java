package com.inks.hb.floorinfo.pojo;

/**
 * 楼层信息
 */
public class FloorInfo {

    private int floorId; //楼层编号

    private String floorName; //楼层名称

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

    @Override
    public String toString() {
        return "--->FloorInfo对象信息输出：" +
                "\n floorId = " + floorId +
                "\n floorName = " + floorName +
                "\n--->FloorInfo信息输出结束";
    }
}
