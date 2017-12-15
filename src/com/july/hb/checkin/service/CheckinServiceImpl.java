package com.july.hb.checkin.service;

import com.july.hb.checkin.dao.CheckinDao;
import com.july.hb.checkin.pojo.CheckinInfo;

import java.sql.SQLException;
import java.util.ArrayList;

public class CheckinServiceImpl implements CheckinService {

    private CheckinDao dao = new CheckinDao();

    @Override
    public int insertCheckinInfo(CheckinInfo checkinInfo) {
        try {
            if (queryRepeat(checkinInfo.getCheckId()) == 1)
                dao.insertData(checkinInfo);
            else
                return 0; //存在id
        } catch (SQLException e) {
            System.out.println(e.getErrorCode() + e.getMessage());
            e.printStackTrace();
            return -1;
        }
        return 1;
    }

    @Override
    public int deleteCheckinInfo(String checkId) {
        CheckinInfo checkinInfo = new CheckinInfo();
        checkinInfo.setCheckId(checkId);

        try {
            dao.deleteData(checkinInfo);
            return 1;
        } catch (SQLException e) {
            System.out.println(e.getErrorCode() + e.getMessage());
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public int updateCheckinInfo(CheckinInfo checkinInfo) {
        try {
            dao.updateData(checkinInfo);
            return 1;
        } catch (SQLException e) {
            System.out.println(e.getErrorCode() + e.getMessage());
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public CheckinInfo query(String checkId) {
        CheckinInfo checkinInfo = new CheckinInfo();
        checkinInfo.setCheckId(checkId);

        try {
            return (CheckinInfo) dao.query(checkId);
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
    public int queryCheckinNum() {
        try {
            return dao.queryDataNum();
        } catch (SQLException e) {
            System.out.println(e.getErrorCode() + e.getMessage());
            return -1;
        }
    }

    @Override
    public int queryRepeat(String checkName) {
        CheckinInfo checkinInfo;

        try {
            checkinInfo = dao.queryName(checkName);
            if (!checkinInfo.isNull()) //表示存在同名项
                return 0;
            else
                return 1;
        } catch (SQLException e) {
            return -1;
        }
    }
}
