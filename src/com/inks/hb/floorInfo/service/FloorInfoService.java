package com.inks.hb.floorInfo.service;

import com.inks.hb.floorInfo.pojo.FloorInfo;

import java.sql.SQLException;
import java.util.ArrayList;

public interface FloorInfoService {

    /**
     *
     * @param floorName 楼层名称
     * @return 0:代表已经存在 1：新增成功
     * @throws SQLException 数据库
     */
    int insertFloorInfo(String floorName) throws SQLException;

    ArrayList<FloorInfo> query(int page, int limit) throws SQLException;

    FloorInfo query(String floorName) throws SQLException;

    int queryFloorInfoNum() throws SQLException;

    int queryRepeat(String floorName) throws SQLException;

    void updateFloorInfo(FloorInfo floorInfo) throws SQLException;

    void deleteFloorInfo(int floorId) throws SQLException;
}
