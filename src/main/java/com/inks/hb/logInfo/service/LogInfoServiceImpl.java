package com.inks.hb.logInfo.service;

import com.inks.hb.logInfo.dao.LogInfoDao;
import com.inks.hb.logInfo.pojo.LogInfo;

import java.sql.SQLException;
import java.util.ArrayList;

public class LogInfoServiceImpl implements LogInfoService {

    private LogInfoDao dao = new LogInfoDao();

    /**
     * 这里接收包装好的对象
     *
     * @param logInfo 日志
     * @return 状态码 0失败 1成功
     */
    @Override
    public int insertLogInfo(LogInfo logInfo) {
        int check = 0;

        try {
            dao.insertData(logInfo);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }

    /**
     * 删除
     *
     * @param logId 主键
     * @return 状态码 1成功 0失败
     */
    @Override
    public int deleteLogInfo(int logId) {

        LogInfo logInfo = new LogInfo();
        logInfo.setLogId(logId);

        try {
            dao.deleteData(logInfo);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
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
    public int queryLogInfoNum() {
        try {
            return dao.queryDataNum();
        } catch (SQLException e) {
            System.out.println(e.getErrorCode() + e.getMessage());
            return -1;
        }
    }

    @Override
    public int deleteByName(int loginId) {
        try {
            ArrayList<LogInfo> list = dao.queryName(loginId);
            for (LogInfo logInfo : list)
                dao.deleteData(logInfo);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
        return 1;
    }
}
