package com.inks.hb.logInfo.dao;

import com.inks.hb.common.CommonDao;
import com.inks.hb.common.DBUtil;
import com.inks.hb.logInfo.pojo.LogInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LogInfoDao implements CommonDao {
    @Override
    public void insertData(Object o) throws SQLException {
        LogInfo logInfo = (LogInfo) o;

        Connection conn = DBUtil.getConnection();
        String sql = "INSERT INTO logInfo (logName, loginId,loginName, logDate) VALUE (?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, logInfo.getLogName());
        ps.setInt(2, logInfo.getLoginId());
        ps.setString(3, logInfo.getLoginName());
        ps.setString(4, logInfo.getLogDate());

        ps.executeUpdate();
        ps.close();
    }

    @Override
    public void deleteData(Object o) throws SQLException {
        LogInfo logInfo = (LogInfo) o;

        Connection conn = DBUtil.getConnection();
        String sql = "DELETE FROM logInfo WHERE logId = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, logInfo.getLogId());

        ps.executeUpdate();
        ps.close();
    }

    @Override
    public void updateData(Object o) throws SQLException {

    }

    @Override
    public int queryDataNum() throws SQLException {
        Connection conn = DBUtil.getConnection();

        String sql = "select count(*) from logInfo;";
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

        String sql = "select * from logInfo limit ?, ?;";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, start - 1);
        pstmt.setInt(2, length);
        ResultSet rs = pstmt.executeQuery();

        ArrayList<LogInfo> list = new ArrayList<>();
        LogInfo logInfo;

        while (rs.next()) {
            logInfo = new LogInfo(rs.getInt(1), rs.getString(2),
                    rs.getInt(3), rs.getString(4), rs.getString(5));
            list.add(logInfo);
        }

        rs.close();
        pstmt.close();

        return list;
    }

    @Override
    public Object query(Object o) throws SQLException {
        return null;
    }

    public ArrayList queryName(int loginId) throws SQLException {
        Connection conn = DBUtil.getConnection();
        String sql = "SELECT * FROM logInfo WHERE loginId = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, loginId);
        ResultSet rs = ps.executeQuery();
        ArrayList<LogInfo> list = new ArrayList<>();
        LogInfo logInfo;
        while (rs.next()) {
            logInfo = new LogInfo(rs.getInt(1), rs.getString(2),
                    rs.getInt(3), rs.getString(4), rs.getString(5));
            list.add(logInfo);
        }
        rs.close();
        ps.close();
        return list;
    }
}
