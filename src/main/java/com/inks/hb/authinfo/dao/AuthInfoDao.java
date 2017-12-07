package com.inks.hb.authinfo.dao;

import com.inks.hb.authinfo.pojo.AuthInfo;
import com.inks.hb.common.CommonDao;
import com.inks.hb.common.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AuthInfoDao implements CommonDao {

    @Override
    public void insertData(Object o) throws SQLException {
        AuthInfo authInfo = (AuthInfo) o;

        Connection conn = DBUtil.getConnection();

        String sql = "insert into authInfo (authItem, isRead, isWrite, isChange, isDelete) values (?,?,?,?,?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, authInfo.getAuthItem());
        pstmt.setString(2, authInfo.getIsRead());
        pstmt.setString(3, authInfo.getIsWrite());
        pstmt.setString(4, authInfo.getIsChange());
        pstmt.setString(5, authInfo.getIsDelete());

        pstmt.executeUpdate();
        pstmt.close();
    }

    @Override
    public void deleteData(Object o) throws SQLException {
        AuthInfo authInfo = (AuthInfo) o;

        Connection conn = DBUtil.getConnection();

        String sql = "DELETE FROM authInfo WHERE authId = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, authInfo.getAuthId());

        pstmt.executeUpdate();
        pstmt.close();
    }

    @Override
    public void updateData(Object o) throws SQLException {
        AuthInfo authInfo = (AuthInfo) o;

        Connection conn = DBUtil.getConnection();

        String sql = "UPDATE authInfo SET authItem = ? ,isRead = ?,isWrite = ?,isChange = ?,isDelete = ? WHERE authId = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, authInfo.getAuthItem());
        pstmt.setString(2, authInfo.getIsRead());
        pstmt.setString(3, authInfo.getIsWrite());
        pstmt.setString(4, authInfo.getIsChange());
        pstmt.setString(5, authInfo.getIsDelete());
        pstmt.setInt(6, authInfo.getAuthId());

        pstmt.executeUpdate();
        pstmt.close();
    }

    @Override
    public int queryDataNum() throws SQLException {

        Connection conn = DBUtil.getConnection();

        String sql = "select count(*) from authInfo;";
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
    public ArrayList<AuthInfo> query(int start, int length) throws SQLException {

        Connection conn = DBUtil.getConnection();

        String sql = "select * from authInfo limit ?, ?;";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, start - 1);
        pstmt.setInt(2, length);
        ResultSet rs = pstmt.executeQuery();

        ArrayList<AuthInfo> list = new ArrayList<>();
        AuthInfo authInfo;

        while (rs.next()) {
            authInfo = new AuthInfo(rs.getInt(1), rs.getString(2), rs.getString(3)
                    , rs.getString(4), rs.getString(5), rs.getString(6));
            list.add(authInfo);
        }

        rs.close();
        pstmt.close();

        return list;
    }

    @Override
    public Object query(Object o) throws SQLException {
        AuthInfo authInfoQuery = (AuthInfo) o;

        Connection conn = DBUtil.getConnection();

        //存在两种查：查ID和查NAME
        String sql = "";
        boolean isQueryId = false;
        if (authInfoQuery.getAuthId() == 0)
            sql = "SELECT * FROM authInfo WHERE authItem = ?";
        else if (authInfoQuery.getAuthItem() == null) {
            sql = "SELECT * FROM authInfo WHERE authId = ?";
            isQueryId = true;
        }

        PreparedStatement pstmt = conn.prepareStatement(sql);
        if (isQueryId) pstmt.setInt(1, authInfoQuery.getAuthId());
        else pstmt.setString(1, authInfoQuery.getAuthItem());
        ResultSet rs = pstmt.executeQuery();

        AuthInfo authInfo = null;
        while (rs.next()) {
            authInfo = new AuthInfo(rs.getInt(1), rs.getString(2), rs.getString(3)
                    , rs.getString(4), rs.getString(5), rs.getString(6));
        }

        if (authInfo == null)
            authInfo = new AuthInfo();

        rs.close();
        pstmt.close();

        return authInfo;
    }

    /**
     * 查询名称
     *
     * @param authInfoQuery 待查询对象
     * @return 查询结果对象
     * @throws SQLException 数据库
     */
    public AuthInfo queryName(AuthInfo authInfoQuery) throws SQLException {
        Connection conn = DBUtil.getConnection();

        String sql = "SELECT * FROM authInfo WHERE authItem = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, authInfoQuery.getAuthItem());
        ResultSet rs = pstmt.executeQuery();

        AuthInfo authInfo = null;
        while (rs.next()) {
            authInfo = new AuthInfo(rs.getInt(1), rs.getString(2), rs.getString(3)
                    , rs.getString(4), rs.getString(5), rs.getString(6));
        }

        if (authInfo == null)
            authInfo = new AuthInfo();

        rs.close();
        pstmt.close();

        return authInfo;
    }
}
