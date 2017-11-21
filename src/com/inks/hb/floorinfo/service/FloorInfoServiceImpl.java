package com.inks.hb.floorinfo.service;

import com.inks.hb.common.CommonDao;
import com.inks.hb.floorinfo.dao.FloorInfoDaoImpl;
import com.inks.hb.floorinfo.pojo.FloorInfo;

import java.sql.SQLException;
import java.util.ArrayList;

public class FloorInfoServiceImpl implements FloorInfoService {

    private CommonDao dao = new FloorInfoDaoImpl();

    @Override
    public void insertFloorInfo(String floorName) throws SQLException {
        FloorInfo floorInfoQuery = new FloorInfo();
        floorInfoQuery.setFloorName(floorName);

        FloorInfo floorInfo = (FloorInfo) dao.query(floorInfoQuery);

        if (floorInfo.getFloorId() == 0) //表示存在同名
            dao.insertData(floorInfoQuery);
    }

    @Override
    public ArrayList query(int page, int limit) throws SQLException {

        int start = (page * limit) - limit + 1; //每一页的起始位置

        if (start < 1)  //小于1的话会触发一个错误
            start = 1;  //但是理论上page和limit是由table表格生成的参数

        return dao.query(start, limit);
    }

    @Override
    public FloorInfo query(String floorName) throws SQLException {
        FloorInfo floorInfoQuery = new FloorInfo();
        floorInfoQuery.setFloorName(floorName);

        return (FloorInfo) dao.query(floorInfoQuery);
    }

    @Override
    public int queryFloorInfoNum() throws SQLException {

        return dao.queryDataNum();
    }

    @Override
    public int queryRepeat(String floorName) throws SQLException {
        FloorInfo floorInfoQuery = new FloorInfo();
        floorInfoQuery.setFloorName(floorName);

        FloorInfo floorInfo = (FloorInfo) dao.query(floorInfoQuery);

        if (floorInfo.getFloorId() != 0) //表示存在同名项
            return 0;
        else
            return 1;
    }

    @Override
    public void updateFloorInfo(FloorInfo floorInfo) throws SQLException {

        dao.updateData(floorInfo);
    }

    @Override
    public void deleteFloorInfo(int floorId) throws SQLException {
        FloorInfo floorInfoQuery = new FloorInfo();
        floorInfoQuery.setFloorId(floorId);

        dao.deleteData(floorInfoQuery);
    }
}
