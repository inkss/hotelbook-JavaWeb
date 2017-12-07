package com.inks.hb.roomtype.service;

import com.inks.hb.roomtype.pojo.RoomType;

import java.util.ArrayList;

/**
 * 数据异常在本层解决
 * 但凡出现SQL方面异常均返回-1
 */
public interface RoomTypeService {

    //增添
    int insertRoomType(RoomType roomType);

    //删除
    int deleteRoomType(String typeId);

    //更新
    int updateRoomType(RoomType roomType);

    //查询单条
    RoomType query(String typeId);

    //查询多条
    ArrayList query(int page, int limit);

    //查询长度
    int queryRoomTypeNum();

    /**
     * 查重函数
     *
     * @param newName oldName 房间类型名称
     * @return 0:已经存在 1：未存在 2：与自身相同
     */
    int queryRepeat(String newName, String oldName);
}
