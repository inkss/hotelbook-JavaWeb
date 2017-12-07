package com.inks.hb.floorinfo.dao;

import com.inks.hb.common.CommonDao;
import com.inks.hb.common.DBUtil;
import com.inks.hb.floorinfo.pojo.FloorInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * 楼层 DAO
 * 未提供独立函数
 */
public class FloorInfoDao implements CommonDao {
    @Override
    public void insertData(Object o) throws SQLException {
        FloorInfo floorInfo = (FloorInfo) o;

        Connection conn = DBUtil.getConnection();

        String sql = "INSERT INTO floorInfo (floorName) VALUES (?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, floorInfo.getFloorName());
        pstmt.executeUpdate();

        pstmt.close();
    }

    @Override
    public void deleteData(Object o) throws SQLException {
        FloorInfo floorInfo = (FloorInfo) o;

        Connection conn = DBUtil.getConnection();

        String sql = "DELETE FROM floorInfo WHERE floorId = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, floorInfo.getFloorId());
        ps.executeUpdate();

        ps.close();
    }

    @Override
    public void updateData(Object o) throws SQLException {
        FloorInfo floorInfo = (FloorInfo) o;

        Connection conn = DBUtil.getConnection();

        String sql = "UPDATE floorInfo SET floorName = ?  WHERE floorId = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, floorInfo.getFloorName());
        ps.setInt(2, floorInfo.getFloorId());
        ps.executeUpdate();

        ps.close();
    }

    @Override
    public int queryDataNum() throws SQLException {

        Connection conn = DBUtil.getConnection();

        String sql = "select count(*) from floorInfo;";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        int num = 0;
        if (rs.next())
            num = rs.getInt("count(*)");

        rs.close();
        ps.close();

        return num;
    }

    @Override
    public ArrayList query(int start, int length) throws SQLException {

        Connection conn = DBUtil.getConnection();

        String sql = "select * from floorInfo limit ?, ?;";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, start - 1);
        ps.setInt(2, length);
        ResultSet rs = ps.executeQuery();

        ArrayList<FloorInfo> list = new ArrayList<>();
        FloorInfo authInfo;
        while (rs.next()) {
            authInfo = new FloorInfo(rs.getInt(1), rs.getString(2));
            list.add(authInfo);
        }

        rs.close();
        ps.close();

        return list;
    }

    @Override
    public Object query(Object o) throws SQLException {
        FloorInfo floorInfoQuery = (FloorInfo) o;

        Connection conn = DBUtil.getConnection();

        String sql = "SELECT * FROM floorInfo WHERE floorName = ?";
        PreparedStatement pstms = conn.prepareStatement(sql);
        pstms.setString(1, floorInfoQuery.getFloorName());
        ResultSet rs = pstms.executeQuery();

        FloorInfo floorInfo = null;
        if (rs.next())
            floorInfo = new FloorInfo(rs.getInt(1), rs.getString(2));

        if (floorInfo == null) {
            floorInfo = new FloorInfo();
            floorInfo.setNull(true);
        }

        rs.close();
        pstms.close();

        return floorInfo;
    }

}
