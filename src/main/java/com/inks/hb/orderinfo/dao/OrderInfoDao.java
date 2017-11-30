package com.inks.hb.orderinfo.dao;

import com.inks.hb.common.CommonDao;
import com.inks.hb.common.DBUtil;
import com.inks.hb.orderinfo.pojo.OrderInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderInfoDao implements CommonDao {

    /**
     * 插入函数关联内容如下：
     * 1.外键关联： roomtype表
     * 2.属性关联  login字段
     * 3.pojo对象只定义了无参构造函数，所以
     * 3.1 String类型无赋值则其值为NULL
     * 3.2 Int类型为0
     * 3.3 typeId与operatorId需要负值对象
     *
     * @param o OrderInfo字段信息
     * @throws SQLException 数据库
     */
    @Override
    public void insertData(Object o) throws SQLException {

        OrderInfo orderInfo = (OrderInfo) o;

        Connection conn = DBUtil.getConnection();

        String sql = "INSERT INTO orderinfo VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, orderInfo.getOrderId());
        pstmt.setString(2, orderInfo.getOrderName());
        pstmt.setString(3, orderInfo.getOrderPhone());
        pstmt.setString(4, orderInfo.getOrderIDcard());
        pstmt.setString(5, orderInfo.getTypeId().getTypeId());
        pstmt.setString(6, orderInfo.getArrireDate());
        pstmt.setString(7, orderInfo.getLeaveDate());
        pstmt.setString(8, orderInfo.getOrderState());
        pstmt.setString(9, orderInfo.getCheckNum());
        pstmt.setString(10, orderInfo.getRoomId());
        pstmt.setString(11, orderInfo.getPrice());
        pstmt.setString(12, orderInfo.getCheckPrice());
        pstmt.setInt(13, orderInfo.getDiscount());
        pstmt.setString(14, orderInfo.getDiscountReason());
        pstmt.setString(15, orderInfo.getAddBed());
        pstmt.setString(16, orderInfo.getAddBedPrice());
        pstmt.setString(17, orderInfo.getOrderMoney());
        pstmt.setString(18, orderInfo.getRemark());
        pstmt.setString(19, orderInfo.getOperatorId().getLoginName());

        pstmt.executeUpdate();

        pstmt.close();
    }

    @Override
    public void deleteData(Object o) throws SQLException {

    }

    @Override
    public void updateData(Object o) throws SQLException {

    }

    @Override
    public int queryDataNum() throws SQLException {
        return 0;
    }

    @Override
    public ArrayList query(int start, int length) throws SQLException {
        return null;
    }

    @Override
    public Object query(Object o) throws SQLException {
        return null;
    }
}
