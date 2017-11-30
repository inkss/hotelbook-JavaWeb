package com.july.hb.floor.service;

import com.july.hb.floor.pojo.FloorInfo;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * 数据异常在本层解决
 * 但凡出现SQL方面异常均返回-1
 */
public interface FloorInfoService {

    //增添
    int insertFloorInfo(String floorName);

    //删除
    int deleteFloorInfo(int floorId);

    //更新
    int updateFloorInfo(FloorInfo floorInfo);

    //查询多条
    ArrayList query(int page, int limit);

    //查询单条
    FloorInfo query(String floorName);

    //查询长度
    int queryFloorInfoNum();

    /**
     * 独立的查重函数
     *
     * @param floorName 楼层名称
     * @return 0:已经存在 1：未存在
     * @throws SQLException 数据库
     */
    int queryRepeat(String floorName);
}
