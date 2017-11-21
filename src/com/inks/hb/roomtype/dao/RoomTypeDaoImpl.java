package com.inks.hb.roomtype.dao;

import com.inks.hb.common.CommonDao;
import com.inks.hb.common.DBUtil;
import com.inks.hb.roomtype.pojo.RoomType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class RoomTypeDaoImpl implements CommonDao {

    @Override
    public void insertData(Object o) throws SQLException {

        RoomType roomType = (RoomType) o;

        Connection conn = DBUtil.getConnection();

        String sql = "INSERT INTO roomType VALUES (?,?,?,?,?,?)";

        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, roomType.getTypeId());
        pstmt.setString(2, roomType.getTypeName());
        pstmt.setString(3, roomType.getPrice());
        pstmt.setString(4, roomType.getSplicPrice());
        pstmt.setInt(5, roomType.getExceedance());
        pstmt.setString(6, roomType.getTypeId());

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
