package com.inks.hb.orderinfo.service;

import com.inks.hb.orderinfo.dao.OrderInfoDao;
import com.inks.hb.orderinfo.pojo.OrderInfo;

import java.sql.SQLException;
import java.util.ArrayList;

public class OrderInfoServiceImpl implements OrderInfoService {

    private OrderInfoDao dao = new OrderInfoDao();

    @Override
    public int insertOrderInfo(OrderInfo orderInfo) {

        try {
            String orderId = orderInfo.getOrderId();
            if (queryRepeat(orderId,orderId) != 1)
                return 0;
            dao.insertData(orderInfo);
        } catch (SQLException e) {
            System.out.println(e.getErrorCode() + e.getMessage());
            return -1;
        }
        return 1;
    }

    @Override
    public int deleteOrderInfo(String orderId) {
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setOrderId(orderId);

        try {
            dao.deleteData(orderInfo);
        } catch (SQLException e) {
            System.out.println(e.getErrorCode() + e.getMessage());
            return -1;
        }
        return 1;
    }

    @Override
    public int updateOrderInfo(OrderInfo orderInfo) {
        return 0;
    }

    @Override
    public OrderInfo query(String orderId) {
        return null;
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
    public int queryOrderInfoNum() {
        return 0;
    }

    @Override
    public int queryRepeat(String newName, String oldName) {
        OrderInfo orderInfoQuery = new OrderInfo();
        orderInfoQuery.setOrderId(newName);
        OrderInfo orderInfo;
        try {
            orderInfo = (OrderInfo) dao.query(orderInfoQuery);
            if (!orderInfo.isNull()) {
                if (orderInfo.getOrderId().equals(oldName))
                    return 2; //和旧名称重复
                return 0; //重复
            } else
                return 1; //不重复
        } catch (SQLException e) {
            System.out.println(e.getErrorCode() + e.getMessage());
            return -1; //异常
        }
    }
}
