package com.july.hb.bill.service;

import com.july.hb.bill.pojo.BillInfo;

import java.sql.SQLException;
import java.util.ArrayList;

public interface BillService {
    //增添
    int insertBill(BillInfo billInfo);

    //删除
    int deleteBill(int billId);

    //更新
    int updateBill(BillInfo billInfo);

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
