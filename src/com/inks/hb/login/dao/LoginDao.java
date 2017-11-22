package com.inks.hb.login.dao;

import com.inks.hb.common.CommonDao;
import com.inks.hb.common.DBUtil;
import com.inks.hb.login.pojo.Login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LoginDao implements CommonDao {

    @Override
    public void insertData(Object o) throws SQLException {

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

        Login login = (Login) o;

        Connection conn = DBUtil.getConnection();
        String sql = "SELECT * FROM login WHERE loginName = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, login.getLoginName());
        ResultSet rs = pstmt.executeQuery();

        Login loginer = new Login();
        if (rs.next()) {
            loginer = new Login(rs.getInt(1), rs.getString(2),
                    rs.getString(3), rs.getString(4), rs.getInt(5));
        }

        rs.close();
        pstmt.close();

        return loginer;
    }
}
