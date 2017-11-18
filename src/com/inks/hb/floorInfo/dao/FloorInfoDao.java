package com.inks.hb.floorInfo.dao;

import com.inks.hb.floorInfo.pojo.FloorInfo;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * 楼层Dao
 */
public interface FloorInfoDao {

    /**
     * 插入一条信息
     *
     * @param floorName 楼层名称
     * @throws SQLException 数据库
     */
    void insertFloorInfo(String floorName) throws SQLException;

    /**
     * 根据楼层名称返回楼层对象
     *
     * @param floorName 楼层名称
     * @return 存在返回楼层对象，否则返回无参构造对象
     * @throws SQLException 数据库
     */
    FloorInfo query(String floorName) throws SQLException;

    /**
     * 查询楼层数据
     *
     * @param start  起始位置
     * @param length 后续长度
     * @return 返回list包装的楼层对象
     * @throws SQLException 数据库
     */
    ArrayList<FloorInfo> query(int start, int length) throws SQLException;

    /**
     * @return 楼层表的长度
     * @throws SQLException 数据库
     */
    int queryFloorInfoNum() throws SQLException;

    /**
     * 更新单条楼层信息，根据ID改NAME
     *
     * @param floorInfo 原ID与新Name
     * @throws SQLException 数据库
     */
    void updateFloorInfo(FloorInfo floorInfo) throws SQLException;

    /**
     * 根据ID删信息
     *
     * @param floorId 楼层编号
     * @throws SQLException 数据库
     */
    void deleteFloorInfo(int floorId) throws SQLException;
}
