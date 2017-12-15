package com.july.hb.billInfo.service;

import com.july.hb.billInfo.pojo.BillInfo;

import java.sql.SQLException;
import java.util.ArrayList;

public interface BillService {
    //增添
    int insertBillInfo(BillInfo billInfo);

    //删除
    int deleteBillInfo(int billId);

    //更新
    int updateBillInfo(BillInfo billInfo);

    //查询多条
    ArrayList query(int page, int limit);

    //查询单条
    BillInfo query(int billId);

    //查询长度
     int queryBillNum();

    /**
     * 独立的查重函数
     *
     * @return 0:已经存在 1：未存在
     * @throws SQLException 数据库
     */
    int queryRepeat(int billId);
}
