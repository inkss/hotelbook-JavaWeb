package com.inks.hb.floorinfo.dao;

import com.inks.hb.common.DBUtil;
import com.inks.hb.floorinfo.pojo.FloorInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FloorInfoDaoImpl implements FloorInfoDao {
    @Override
    public void insertFloorInfo(String floorName) throws SQLException {

        Connection conn = DBUtil.getConnection();

        String sql = "INSERT INTO floorInfo (floorName) VALUES (?)";

        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, floorName);

        pstmt.executeUpdate();

        pstmt.close();

    }

    @Override
    public FloorInfo query(String floorName) throws SQLException {

        Connection conn = DBUtil.getConnection();

        String sql = "SELECT * FROM floorInfo WHERE floorName = ?";

        PreparedStatement pstms = conn.prepareStatement(sql);
        pstms.setString(1, floorName);

        ResultSet rs = pstms.executeQuery();

        FloorInfo floorInfo = null;

        if (rs.next())
            floorInfo = new FloorInfo(rs.getInt(1), rs.getString(2));

        if (floorInfo == null)
            floorInfo = new FloorInfo();

        rs.close();

        pstms.close();

        return floorInfo;
    }

    @Override
    public ArrayList<FloorInfo> query(int start, int length) throws SQLException {

        Connection conn = DBUtil.getConnection();

        String sql = "select * from floorInfo limit ?, ?;";

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setInt(1, start - 1);   //减一，详见声明部分
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
    public int queryFloorInfoNum() throws SQLException {
        Connection conn = DBUtil.getConnection();

        String sql = "select count(*) from floorInfo;";

        PreparedStatement ps = conn.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        int num;

        if (rs.next())
            num = rs.getInt("count(*)");
        else
            num = 0;

        rs.close();

        ps.close();

        return num;
    }

    @Override
    public void updateFloorInfo(FloorInfo floorInfo) throws SQLException {
        Connection conn = DBUtil.getConnection();

        String sql = "UPDATE floorInfo SET floorName = ?  WHERE floorId = ?";

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, floorInfo.getFloorName());
        ps.setInt(2,floorInfo.getFloorId());

        ps.executeUpdate();

        ps.close();
    }

    @Override
    public void deleteFloorInfo(int floorId) throws SQLException {

        Connection conn = DBUtil.getConnection();

        String sql = "DELETE FROM floorInfo WHERE floorId = ?";

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setInt(1,floorId);

        ps.executeUpdate();

        ps.close();
    }
}
