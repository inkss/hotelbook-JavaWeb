package com.inks.hb.login.dao;

import com.inks.hb.common.DBUtil;
import com.inks.hb.login.pojo.Login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDaoImpl implements LoginDao {

    @Override
    public Login queryByName(String loginName) throws SQLException {

        Connection conn = DBUtil.getConnection();

        //language=GenericSQL
        String sql = "SELECT * FROM login WHERE loginName = ?";

        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,loginName);

        ResultSet rs = pstmt.executeQuery();

        Login loginer = new Login();

        if (rs.next()) {
            loginer = new Login(rs.getInt(1),rs.getString(2),
                    rs.getString(3),rs.getString(4),rs.getInt(5));
        }

        rs.close();
        pstmt.close();

        DBUtil.close();

        return loginer;
    }
}
