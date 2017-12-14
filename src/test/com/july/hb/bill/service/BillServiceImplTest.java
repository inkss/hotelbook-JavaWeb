package com.july.hb.bill.service;

import com.july.hb.bill.pojo.BillInfo;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BillServiceImplTest {
    private BillService service = new BillServiceImpl();
    private int n;
    @Test
    public void insertBillInfo() throws Exception {
        BillInfo billInfo = new BillInfo();
        billInfo.setBillId(1);
        billInfo.setCheckId("1");
        billInfo.setCostDate("kkk");
        billInfo.setCostMoney("999");
        billInfo.setRemark("jj");
        n = service.insertBillInfo(billInfo);
        System.out.println(n);
    }

    @Test
    public void deleteBillInfo() throws Exception {
        n = service.deleteBillInfo(1);
        System.out.println(n);
    }

    @Test
    public void updateBillInfo() throws Exception {
        BillInfo billInfo = new BillInfo();
        billInfo.setBillId(1);
        billInfo.setCheckId("1");
        billInfo.setCostDate("kkk");
        billInfo.setCostMoney("999");
        billInfo.setRemark("bjkghfg");
        n = service.updateBillInfo(billInfo);
        System.out.println(n);

    }

    @Test
    public void query(int i, int i1) throws Exception {
        BillInfo billInfo = service.query(1);
        System.out.println(billInfo);
    }

    @Test
    public void query1() throws Exception {

         service.query(1,10);

    }

    @Test
    public void queryBillNum() throws Exception {
    }

    @Test
    public void queryRepeat() throws Exception {
    }

}