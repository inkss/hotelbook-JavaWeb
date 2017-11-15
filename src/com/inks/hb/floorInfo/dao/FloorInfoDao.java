package com.inks.hb.floorInfo.dao;

import com.inks.hb.floorInfo.pojo.FloorInfo;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * 楼层Dao
 */
public interface FloorInfoDao {

    void insertFloorInfo(String floorName) throws SQLException;

    FloorInfo query(String floorName) throws SQLException;

    ArrayList<FloorInfo> query(int start, int length) throws SQLException;

    int queryFloorInfoNum() throws SQLException;
}
