package com.july.hb.bill.dao;

import com.july.hb.bill.pojo.BillInfo;
import com.july.hb.common.CommonDao;
import com.july.hb.common.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BillDao implements CommonDao
{
    @Override
    public void insertData(Object o) throws SQLException {
        BillInfo billInfo = (BillInfo) o;

        Connection conn = DBUtil.getConnection();

        String sql = "INSERT INTO floorInfo (floorName) VALUES (?,?,?,?,?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, billInfo.getBillId());
        pstmt.setString(2,billInfo.getCheckedId());
        pstmt.setString(3,billInfo.getCostMoney());
        pstmt.setString(4,billInfo.getCostDate());
        pstmt.setString(5,billInfo.getRemark());

        pstmt.executeUpdate();

        pstmt.close();
    }

    @Override
    public void deleteData(Object o) throws SQLException {
        BillInfo billInfo = (BillInfo) o;

        Connection conn = DBUtil.getConnection();

        String sql = "DELETE FROM billInfo WHERE billInfo = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, billInfo.getBillId());
        ps.executeUpdate();

        ps.close();
    }

    @Override
    public void updateData(Object o) throws SQLException {
        BillInfo billInfo = (BillInfo) o;

        Connection conn = DBUtil.getConnection();

        String sql = "UPDATE billInfo SET costMoney = ? ,costDate = ? ,remark = ?  WHERE billId = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, billInfo.getCostDate());
        pstmt.setString(2, billInfo.getCostDate());
        pstmt.setString(3, billInfo.getRemark());
        pstmt.executeUpdate();
        pstmt.close();
    }

    @Override
    public int queryDataNum() throws SQLException {

        Connection conn = DBUtil.getConnection();

        String sql = "select count(*) from billInfo;";
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

        String sql = "select * from roomType limit ?, ?;";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, start - 1);
        pstmt.setInt(2, length);
        ResultSet rs = pstmt.executeQuery();

        ArrayList<BillInfo> list = new ArrayList<>();
        BillInfo billInfo;

        while (rs.next()) {
            billInfo = new BillInfo(rs.getInt(1), rs.getString(2), rs.getString(3)
                    , rs.getString(4), rs.getString(5) );
            list.add(billInfo);
        }

        rs.close();
        pstmt.close();

        return list;
    }

    @Override
    public Object query(Object o) throws SQLException {
        BillInfo billInfoQuery = (BillInfo) o;

        Connection conn = DBUtil.getConnection();

        String sql = "SELECT * FROM billInfo WHERE billId = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, billInfoQuery.getBillId());
        ResultSet rs = pstmt.executeQuery();

        BillInfo billInfo = null;
        while (rs.next()) {
            billInfo = new BillInfo(rs.getInt(1), rs.getString(2), rs.getString(3)
                    , rs.getString(4), rs.getString(5) );
        }

        if (billInfo == null) {
            billInfo = new BillInfo();
            billInfo.setNull(true);
        }
        rs.close();
        pstmt.close();

        return billInfo;
    }
}
