package com.inks.hb.orderinfo.service;

import com.inks.hb.orderinfo.pojo.OrderInfo;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class OrderInfoServiceImplTest {

    private OrderInfoService service = new OrderInfoServiceImpl();

    @Test
    public void insertOrderInfo() {
    }

    @Test
    public void deleteOrderInfo() {
    }

    @Test
    public void updateOrderInfo() {
    }

    @Test
    public void query() {

        ArrayList<OrderInfo> list = service.query(1,50);

        for (OrderInfo info : list) {
            System.out.println(info);
        }

    }

    @Test
    public void query1() {

        System.out.println(service.query("OD151254780333"));
    }

    @Test
    public void queryOrderInfoNum() {
    }

    @Test
    public void queryRepeat() {
    }
}