package com.inks.hb.roomtype.service;

import com.inks.hb.roomtype.pojo.RoomType;

import java.sql.SQLException;
import java.util.ArrayList;

public interface RoomTypeService {

    //增添
    void insertRoomType(RoomType roomType) throws SQLException;

    //删除
    void deleteRoomType(String typeId) throws SQLException;

    //更新
    void updateRoomType(RoomType roomType) throws SQLException;

    //查询单条
    RoomType query(String typeId) throws SQLException;

    //查询多条
    ArrayList query(int page, int limit) throws SQLException;

    //查询长度
    int queryRoomTypeNum() throws SQLException;

    /**
     * 查重函数
     *
     * @param typeName 房间类型名称
     * @return 0:已经存在 1：未存在
     * @throws SQLException 数据库
     */
    int queryRepeat(String typeName) throws SQLException;
}
