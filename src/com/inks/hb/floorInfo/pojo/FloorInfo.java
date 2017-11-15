package com.inks.hb.floorInfo.pojo;

public class FloorInfo {

    private int floorId;

    private String floorName;

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
        return "\n--->FloorInfo对象信息输出：" +
                "\n floorId = " + floorId +
                "\n floorName = " + floorName +
                "\n--->FloorInfo信息输出结束\n";
    }
}
