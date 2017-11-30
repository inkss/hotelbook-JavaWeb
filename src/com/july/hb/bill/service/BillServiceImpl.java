package com.july.hb.bill.service;

import com.july.hb.bill.dao.BillDao;
import com.july.hb.bill.pojo.BillInfo;

import java.sql.SQLException;
import java.util.ArrayList;

public class BillServiceImpl implements BillService {
    private BillDao dao = new BillDao();
    @Override
    public int insertBill(BillInfo billInfo) {

        return 1;
    }

    @Override
    public int deleteBill(int billId) {
        return 0;
    }

    @Override
    public int updateBill(BillInfo billInfo) {
        return 0;
    }

    @Override
    public ArrayList query(int page, int limit) {
        return null;
    }

    @Override
    public BillInfo query(int billId) {
        return null;
    }

    @Override
    public int queryBillNum() {
        return 0;
    }

    @Override
    public int queryRepeat(int billId) {
        return 0;
    }
}
