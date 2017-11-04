package com.inks.hb.authInfo.dao;

import com.inks.hb.authInfo.pojo.AuthInfo;
import com.inks.hb.common.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AuthInfoDaoImpl implements AuthInfoDao {
    @Override
    public void insertAuthInfo(AuthInfo authInfo) throws SQLException {

        Connection conn = DBUtil.getConnection();

        String sql = "insert into authInfo values (?,?,?,?,?,?)";

        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, authInfo.getAuthId());
        pstmt.setString(2, authInfo.getAuthItem());
        pstmt.setString(3, authInfo.getIsRead());
        pstmt.setString(4, authInfo.getIsWrite());
        pstmt.setString(5, authInfo.getIsChange());
        pstmt.setString(6, authInfo.getIsDelete());

        pstmt.executeUpdate();

        pstmt.close();

        DBUtil.close();
    }

    @Override
    public void deleteAuthInfo(int authId) throws SQLException {

        Connection conn = DBUtil.getConnection();

        String sql = "DELETE FROM authInfo WHERE authId = ?";

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setInt(1, authId);

        ps.executeUpdate();

        ps.close();

        DBUtil.close();

    }

    @Override
    public void updateAuthInfo(AuthInfo authInfo) throws SQLException {

        Connection conn = DBUtil.getConnection();

        String sql = "UPDATE authInfo SET authItem = ? ,isRead = ?,isWrite = ?,isChange = ?,isDelete = ? WHERE authId = ?";

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, authInfo.getAuthItem());
        ps.setString(2,authInfo.getIsRead());
        ps.setString(3,authInfo.getIsWrite());
        ps.setString(4,authInfo.getIsChange());
        ps.setString(5,authInfo.getIsDelete());
        ps.setInt(6,authInfo.getAuthId());

        ps.executeUpdate();

        ps.close();

        DBUtil.close();
    }

    @Override
    public int queryAuthInfoNum() throws SQLException {

        Connection conn = DBUtil.getConnection();

        String sql = "select count(*) from authInfo;";

        PreparedStatement ps = conn.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        int num;

        if (rs.next())
            num = rs.getInt("count(*)");
        else
            num = 0;

        rs.close();

        ps.close();

        DBUtil.close();

        return num;
    }

    @Override
    public ArrayList<AuthInfo> query(int start, int length) throws SQLException {

        Connection conn = DBUtil.getConnection();

        String sql = "select * from authInfo limit ?, ?;";

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setInt(1, start - 1);   //减一，详见声明部分
        ps.setInt(2, length);

        ResultSet rs = ps.executeQuery();

        ArrayList<AuthInfo> list = new ArrayList<>();

        AuthInfo authInfo = null;

        while (rs.next()) {
            authInfo = new AuthInfo(rs.getInt(1), rs.getString(2), rs.getString(3)
                    , rs.getString(4), rs.getString(5), rs.getString(6));
            list.add(authInfo);
        }

        rs.close();

        ps.close();

        DBUtil.close();

        return list;
    }
}
