package com.inks.hb.roomtype.service;

import com.inks.hb.roomtype.dao.RoomTypeDao;
import com.inks.hb.roomtype.pojo.RoomType;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * 修订：2017.11.23
 * 将异常放在了本层处理
 * 如果出现数据库相关异常，则返回-1或者null
 */
public class RoomTypeServiceImpl implements RoomTypeService {

    private RoomTypeDao dao = new RoomTypeDao();

    @Override
    public int insertRoomType(RoomType roomType) {
        try {
            String name = roomType.getTypeName();
            if (queryRepeat(name, name) != 1)
                return 0;
            dao.insertData(roomType);
        } catch (SQLException e) {
            System.out.println(e.getErrorCode() + e.getMessage());
            return -1;
        }
        return 1;
    }

    @Override
    public int deleteRoomType(String typeId) {
        RoomType roomType = new RoomType();
        roomType.setTypeId(typeId);

        try {
            dao.deleteData(roomType);
        } catch (SQLException e) {
            System.out.println(e.getErrorCode() + e.getMessage());
            return -1;
        }
        return 1;
    }

    @Override
    public int updateRoomType(RoomType roomType) {
        try {
            dao.updateData(roomType);
        } catch (SQLException e) {
            System.out.println(e.getErrorCode() + e.getMessage());
            return -1;
        }
        return 1;
    }

    @Override
    public RoomType query(String typeId) {
        RoomType roomType = new RoomType();
        roomType.setTypeId(typeId);

        try {
            return (RoomType) dao.query(roomType);
        } catch (SQLException e) {
            System.out.println(e.getErrorCode() + e.getMessage());
            return null;
        }
    }

    @Override
    public ArrayList query(int page, int limit) {
        int start = (page * limit) - limit + 1; //每一页的起始位置

        if (start < 1)  //小于1的话会触发一个错误
            start = 1;  //但是理论上page和limit是由table表格生成的参数

        try {
            return dao.query(start, limit);
        } catch (SQLException e) {
            System.out.println(e.getErrorCode() + e.getMessage());
            return null;
        }
    }

    @Override
    public int queryRoomTypeNum() {

        try {
            return dao.queryDataNum();
        } catch (SQLException e) {
            System.out.println(e.getErrorCode() + e.getMessage());
            return -1;
        }
    }

    @Override
    public int queryRepeat(String newName, String oldName) {
        RoomType roomType;

        try {
            roomType = dao.queryName(newName);
            if (!roomType.isNull()) {//表示存在同名项
                if (roomType.getTypeName().equals(oldName))
                    return 2;           //表示存在同名项，但是是与传递来的相同
                return 0;
            } else
                return 1;
        } catch (SQLException e) {
            System.out.println(e.getErrorCode() + e.getMessage());
            return -1;
        }
    }

}
