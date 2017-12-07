package com.inks.hb.orderinfo.dao;

import com.inks.hb.common.CommonDao;
import com.inks.hb.common.DBUtil;
import com.inks.hb.login.pojo.Login;
import com.inks.hb.orderinfo.pojo.OrderInfo;
import com.inks.hb.roomtype.pojo.RoomType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * 另提供queryOrder-> 对预定人名称和房间类型的查询
 */
public class OrderInfoDao implements CommonDao {

    /**
     * 插入函数关联内容如下：
     * 1.外键关联： roomtype表
     * 2.属性关联  login字段
     * 3.pojo对象的无参构造函数
     * String类型无赋值则其值为NULL
     * Int类型为0
     * typeId与operatorId需要负值对象
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
        OrderInfo orderInfo = (OrderInfo) o;

        Connection conn = DBUtil.getConnection();

        String sql = "DELETE FROM orderinfo WHERE orderId = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, orderInfo.getOrderId());

        pstmt.executeUpdate();
        pstmt.close();
    }

    @Override
    public void updateData(Object o) throws SQLException {
        OrderInfo orderInfo = (OrderInfo) o;

        Connection conn = DBUtil.getConnection();

        String sql = "UPDATE orderinfo SET orderName = ? ,orderPhone = ? ,orderIDcard = ? ,typeId = ? " +
                ",arrireDate = ? ,leaveDate = ? ,orderState = ? ,checkNum = ? ,roomId = ? ,price = ? ,checkPrice = ? " +
                ",discount = ? ,discountReason = ? ,addBed = ? ,addBedPrice = ? ,orderMoney = ? ,remark = ? " +
                ",operatorId = ? WHERE orderId = ?";

        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, orderInfo.getOrderName());
        pstmt.setString(2, orderInfo.getOrderPhone());
        pstmt.setString(3, orderInfo.getOrderIDcard());
        pstmt.setString(4, orderInfo.getTypeId().getTypeId());
        pstmt.setString(5, orderInfo.getArrireDate());
        pstmt.setString(6, orderInfo.getLeaveDate());
        pstmt.setString(7, orderInfo.getOrderState());
        pstmt.setString(8, orderInfo.getCheckNum());
        pstmt.setString(9, orderInfo.getRoomId());
        pstmt.setString(10, orderInfo.getPrice());
        pstmt.setString(11, orderInfo.getCheckPrice());
        pstmt.setInt(12, orderInfo.getDiscount());
        pstmt.setString(13, orderInfo.getDiscountReason());
        pstmt.setString(14, orderInfo.getAddBed());
        pstmt.setString(15, orderInfo.getAddBedPrice());
        pstmt.setString(16, orderInfo.getOrderMoney());
        pstmt.setString(17, orderInfo.getRemark());
        pstmt.setString(18, orderInfo.getOperatorId().getLoginName());
        pstmt.setString(19, orderInfo.getOrderId());

        pstmt.executeUpdate();
        pstmt.close();
    }

    @Override
    public int queryDataNum() throws SQLException {

        Connection conn = DBUtil.getConnection();

        String sql = "select count(*) from orderinfo;";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();

        int num;
        if (rs.next()) num = rs.getInt("count(*)");
        else num = 0;

        rs.close();
        pstmt.close();

        return num;
    }

    @Override
    public ArrayList query(int start, int length) throws SQLException {

        Connection conn = DBUtil.getConnection();

        String sql = "select * from orderinfo limit ?, ?;";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, start - 1);
        pstmt.setInt(2, length);
        ResultSet rs = pstmt.executeQuery();

        ArrayList<OrderInfo> list = new ArrayList<>();
        OrderInfo orderInfo;

        while (rs.next()) {
            orderInfo = new OrderInfo(rs.getString(1), rs.getString(2), rs.getString(3)
                    , rs.getString(4), new RoomType(rs.getString(5)), rs.getString(6)
                    , rs.getString(7), rs.getString(8), rs.getString(9)
                    , rs.getString(10), rs.getString(11), rs.getString(12)
                    , rs.getInt(13), rs.getString(14), rs.getString(15)
                    , rs.getString(16), rs.getString(17), rs.getString(18)
                    , new Login(rs.getString(19)));
            list.add(orderInfo);
        }

        rs.close();
        pstmt.close();

        return list;
    }

    @Override
    public Object query(Object o) throws SQLException {
        OrderInfo orderInfoQuery = (OrderInfo) o;

        Connection conn = DBUtil.getConnection();

        //根据ID的查询
        String sql = "SELECT * FROM orderinfo WHERE orderId = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, orderInfoQuery.getOrderId());
        ResultSet rs = pstmt.executeQuery();

        OrderInfo orderInfo = null;
        while (rs.next()) {
            orderInfo = new OrderInfo(rs.getString(1), rs.getString(2), rs.getString(3)
                    , rs.getString(4), new RoomType(rs.getString(5)), rs.getString(6)
                    , rs.getString(7), rs.getString(8), rs.getString(9)
                    , rs.getString(10), rs.getString(11), rs.getString(12)
                    , rs.getInt(13), rs.getString(14), rs.getString(15)
                    , rs.getString(16), rs.getString(17), rs.getString(18)
                    , new Login(rs.getString(19)));
        }

        if (orderInfo == null) {
            orderInfo = new OrderInfo();
            orderInfo.setNull(true);
        }
        rs.close();
        pstmt.close();

        return orderInfo;
    }

    /**
     * 查询啊,模糊查询呀
     *
     * @param make   1：查名称 2：查类型
     * @param select 待查的值
     * @return 查询对象
     * @throws SQLException 抛给业务层
     */
    public ArrayList queryOrder(int make, String select) throws SQLException {
        Connection conn = DBUtil.getConnection();

        String sql;
        if (make == 1)
            sql = "select * from orderinfo WHERE orderName LIKE ?;";
        else
            sql = "select * from orderinfo WHERE typeId LIKE ?;";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, "%" + select + "%");

        ResultSet rs = pstmt.executeQuery();
        ArrayList<OrderInfo> list = new ArrayList<>();
        OrderInfo orderInfo;

        while (rs.next()) {
            orderInfo = new OrderInfo(rs.getString(1), rs.getString(2), rs.getString(3)
                    , rs.getString(4), new RoomType(rs.getString(5)), rs.getString(6)
                    , rs.getString(7), rs.getString(8), rs.getString(9)
                    , rs.getString(10), rs.getString(11), rs.getString(12)
                    , rs.getInt(13), rs.getString(14), rs.getString(15)
                    , rs.getString(16), rs.getString(17), rs.getString(18)
                    , new Login(rs.getString(19)));
            list.add(orderInfo);
        }

        rs.close();
        pstmt.close();

        return list;
    }

}
