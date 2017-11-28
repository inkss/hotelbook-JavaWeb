package com.inks.hb.roomtype.dao;

import com.inks.hb.common.CommonDao;
import com.inks.hb.common.DBUtil;
import com.inks.hb.roomtype.pojo.RoomType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * 房间类型 DAO
 * 提供独立函数：public RoomType queryName(String typeName) throws SQLException
 * 根据类型名称进行查询
 */
public class RoomTypeDao implements CommonDao {

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
        pstmt.setString(6, roomType.getIsSplice());

        pstmt.executeUpdate();

        pstmt.close();
    }

    @Override
    public void deleteData(Object o) throws SQLException {
        RoomType roomType = (RoomType) o;

        Connection conn = DBUtil.getConnection();

        String sql = "DELETE FROM roomType WHERE typeId = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, roomType.getTypeId());

        pstmt.executeUpdate();
        pstmt.close();
    }

    @Override
    public void updateData(Object o) throws SQLException {
        RoomType roomType = (RoomType) o;

        Connection conn = DBUtil.getConnection();

        String sql = "UPDATE roomType SET typeName = ? ,price = ? ,splicPrice = ? ,exceedance = ? ,isSplice = ? WHERE typeId = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, roomType.getTypeName());
        pstmt.setString(2, roomType.getPrice());
        pstmt.setString(3, roomType.getSplicPrice());
        pstmt.setInt(4, roomType.getExceedance());
        pstmt.setString(5, roomType.getIsSplice());
        pstmt.setString(6, roomType.getTypeId());

        pstmt.executeUpdate();
        pstmt.close();
    }

    @Override
    public int queryDataNum() throws SQLException {

        Connection conn = DBUtil.getConnection();

        String sql = "select count(*) from roomType;";
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
        pstmt.setInt(1, start - 1);   //减一，详见声明部分
        pstmt.setInt(2, length);
        ResultSet rs = pstmt.executeQuery();

        ArrayList<RoomType> list = new ArrayList<>();
        RoomType roomType;

        while (rs.next()) {
            roomType = new RoomType(rs.getString(1), rs.getString(2), rs.getString(3)
                    , rs.getString(4), rs.getInt(5), rs.getString(6));
            list.add(roomType);
        }

        rs.close();
        pstmt.close();

        return list;
    }

    @Override
    public Object query(Object o) throws SQLException {
        RoomType roomTypeQuery = (RoomType) o;

        Connection conn = DBUtil.getConnection();

        String sql = "SELECT * FROM roomType WHERE typeId = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, roomTypeQuery.getTypeId());
        ResultSet rs = pstmt.executeQuery();

        RoomType roomType = null;
        while (rs.next()) {
            roomType = new RoomType(rs.getString(1), rs.getString(2), rs.getString(3)
                    , rs.getString(4), rs.getInt(5), rs.getString(6));
        }

        if (roomType == null) {
            roomType = new RoomType();
            roomType.setNull(true);
        }
        rs.close();
        pstmt.close();

        return roomType;
    }

    /**
     * 根据类型名称进行查询
     *
     * @param typeName 包装成typeName的待查询对象
     * @return 包装成roomType的查询结果
     * @throws SQLException 数据库
     */
    public RoomType queryName(String typeName) throws SQLException {

        Connection conn = DBUtil.getConnection();

        String sql = "SELECT * FROM roomType WHERE typeName = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, typeName);
        ResultSet rs = pstmt.executeQuery();

        RoomType roomTypeQuery = null;
        while (rs.next()) {
            roomTypeQuery = new RoomType(rs.getString(1), rs.getString(2), rs.getString(3)
                    , rs.getString(4), rs.getInt(5), rs.getString(6));
        }

        if (roomTypeQuery == null) {
            roomTypeQuery = new RoomType();
            roomTypeQuery.setNull(true);
        }

        rs.close();
        pstmt.close();

        return roomTypeQuery;
    }
}
