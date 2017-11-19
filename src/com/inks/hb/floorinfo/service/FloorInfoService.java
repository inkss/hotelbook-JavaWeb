package com.inks.hb.floorinfo.service;

import com.inks.hb.floorinfo.pojo.FloorInfo;

import java.sql.SQLException;
import java.util.List;

public interface FloorInfoService {

    /**
     * 插入一条信息
     *
     * @param floorName 楼层名称
     * @throws SQLException 数据库
     */
    void insertFloorInfo(String floorName) throws SQLException;

    //查询多条
    List<FloorInfo> query(int page, int limit) throws SQLException;

    //查询单条
    FloorInfo query(String floorName) throws SQLException;

    //查询长度
    int queryFloorInfoNum() throws SQLException;

    /**
     * 独立的查重函数
     *
     * @param floorName 楼层名称
     * @return 0:代表已经存在 1：新增成功
     * @throws SQLException 数据库
     */
    int queryRepeat(String floorName) throws SQLException;

    //更新
    void updateFloorInfo(FloorInfo floorInfo) throws SQLException;

    //删除
    void deleteFloorInfo(int floorId) throws SQLException;
}
