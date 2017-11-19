package com.inks.hb.floorinfo.service;

import com.inks.hb.floorinfo.dao.FloorInfoDao;
import com.inks.hb.floorinfo.dao.FloorInfoDaoImpl;
import com.inks.hb.floorinfo.pojo.FloorInfo;

import java.sql.SQLException;
import java.util.List;

public class FloorInfoServiceImpl implements FloorInfoService {

    private FloorInfoDao dao = new FloorInfoDaoImpl();

    @Override
    public void insertFloorInfo(String floorName) throws SQLException {

        FloorInfo floorInfo = dao.query(floorName);

        if (floorInfo.getFloorId() == 0) //表示存在同名
            dao.insertFloorInfo(floorName);

    }

    @Override
    public List<FloorInfo> query(int page, int limit) throws SQLException {

        int start = (page * limit) - limit + 1; //每一页的起始位置

        if (start < 1)  //小于1的话会触发一个错误
            start = 1;  //但是理论上page和limit是由table表格生成的参数

        return dao.query(start, limit);
    }

    @Override
    public FloorInfo query(String floorName) throws SQLException {

        return dao.query(floorName);
    }

    @Override
    public int queryFloorInfoNum() throws SQLException {

        return dao.queryFloorInfoNum();
    }

    @Override
    public int queryRepeat(String floorName) throws SQLException {

        FloorInfo floorInfo = dao.query(floorName);

        if (floorInfo.getFloorId() != 0) //表示存在同名项
            return 0;
        else
            return 1;
    }

    @Override
    public void updateFloorInfo(FloorInfo floorInfo) throws SQLException {
        dao.updateFloorInfo(floorInfo);
    }

    @Override
    public void deleteFloorInfo(int floorId) throws SQLException {
        dao.deleteFloorInfo(floorId);
    }
}
