package com.inks.hb.floorinfo.service;

import com.inks.hb.floorinfo.pojo.FloorInfo;

import java.sql.SQLException;
import java.util.ArrayList;

public interface FloorInfoService {

    //增添
    void insertFloorInfo(String floorName) throws SQLException;

    //删除
    void deleteFloorInfo(int floorId) throws SQLException;

    //更新
    void updateFloorInfo(FloorInfo floorInfo) throws SQLException;

    //查询多条
    ArrayList query(int page, int limit) throws SQLException;

    //查询单条
    FloorInfo query(String floorName) throws SQLException;

    //查询长度
    int queryFloorInfoNum() throws SQLException;

    /**
     * 独立的查重函数
     *
     * @param floorName 楼层名称
     * @return 0:已经存在 1：未存在
     * @throws SQLException 数据库
     */
    int queryRepeat(String floorName) throws SQLException;
}
