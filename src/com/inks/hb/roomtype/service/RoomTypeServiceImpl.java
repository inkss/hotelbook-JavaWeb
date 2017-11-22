package com.inks.hb.roomtype.service;

import com.inks.hb.roomtype.dao.RoomTypeDao;
import com.inks.hb.roomtype.pojo.RoomType;

import java.sql.SQLException;
import java.util.ArrayList;

public class RoomTypeServiceImpl implements RoomTypeService {

    private RoomTypeDao dao = new RoomTypeDao();

    @Override
    public void insertRoomType(RoomType roomType) throws SQLException {

        if (queryRepeat(roomType.getTypeName()) == 1)
            dao.insertData(roomType);
    }

    @Override
    public void deleteRoomType(String typeId) throws SQLException {
        RoomType roomType = new RoomType();
        roomType.setTypeId(typeId);

        dao.deleteData(roomType);
    }

    @Override
    public void updateRoomType(RoomType roomType) throws SQLException {

        dao.updateData(roomType);
    }

    @Override
    public RoomType query(String typeId) throws SQLException {
        RoomType roomType = new RoomType();
        roomType.setTypeId(typeId);

        return (RoomType) dao.query(roomType);
    }

    @Override
    public ArrayList query(int page, int limit) throws SQLException {

        int start = (page * limit) - limit + 1; //每一页的起始位置

        if (start < 1)  //小于1的话会触发一个错误
            start = 1;  //但是理论上page和limit是由table表格生成的参数

        return dao.query(start, limit);
    }

    @Override
    public int queryRoomTypeNum() throws SQLException {

        return dao.queryDataNum();
    }

    @Override
    public int queryRepeat(String typeName) throws SQLException {

        RoomType roomType = dao.queryName(typeName);

        if (roomType.getTypeId() == null && roomType.getExceedance() == 0)
            return 1;

        return 0;
    }
}
