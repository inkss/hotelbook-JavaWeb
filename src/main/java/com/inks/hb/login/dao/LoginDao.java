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

        Login login = (Login) o;

        Connection conn = DBUtil.getConnection();
        String sql = "INSERT INTO login (loginName, loginPwd, loginNickName, loginAdmin) VALUE (?,?,?,?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, login.getLoginName());
        pstmt.setString(2, login.getLoginPwd());
        pstmt.setString(3, login.getLoginNickName());
        pstmt.setInt(4, login.getLoginAdmin());

        pstmt.executeUpdate();
        pstmt.close();
    }

    @Override
    public void deleteData(Object o) throws SQLException {
        Login login = (Login) o;

        Connection conn = DBUtil.getConnection();

        String sql = "DELETE FROM login WHERE loginId = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, login.getLoginId());

        pstmt.executeUpdate();
        pstmt.close();
    }

    @Override
    public void updateData(Object o) throws SQLException {
        Login login = (Login) o;

        Connection conn = DBUtil.getConnection();

        String sql = "UPDATE login SET loginName = ? ,loginPwd = ?,loginNickName = ?,loginAdmin = ? WHERE loginId = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, login.getLoginName());
        pstmt.setString(2, login.getLoginPwd());
        pstmt.setString(3, login.getLoginNickName());
        pstmt.setInt(4, login.getLoginAdmin());
        pstmt.setInt(5, login.getLoginId());

        pstmt.executeUpdate();
        pstmt.close();
    }

    @Override
    public int queryDataNum() throws SQLException {

        Connection conn = DBUtil.getConnection();

        String sql = "select count(*) from login;";
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

        String sql = "select * from login limit ?, ?;";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, start - 1);
        pstmt.setInt(2, length);
        ResultSet rs = pstmt.executeQuery();

        ArrayList<Login> list = new ArrayList<>();
        Login login;

        while (rs.next()) {
            login = new Login(rs.getInt(1), rs.getString(2),
                    rs.getString(3), rs.getString(4), rs.getInt(5));
            list.add(login);
        }

        rs.close();
        pstmt.close();

        return list;
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
