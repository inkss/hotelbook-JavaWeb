package com.inks.hb.authinfo.dao;

import com.inks.hb.authinfo.pojo.AuthInfo;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class AuthInfoDaoTest {

    private AuthInfoDao dao = new AuthInfoDao();

    @Test
    public void insertData() {
        AuthInfo authInfo;
        for (int i = 0;i < 100; i++) {
            authInfo = new AuthInfo(i,"测试" + i, "1","1",""+i,"0");
            try {
                dao.insertData(authInfo);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}