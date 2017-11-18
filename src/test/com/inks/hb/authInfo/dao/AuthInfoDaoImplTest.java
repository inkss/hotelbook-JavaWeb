package com.inks.hb.authInfo.dao;

import com.inks.hb.authInfo.pojo.AuthInfo;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;

public class AuthInfoDaoImplTest {

    private AuthInfo authInfo;

    private AuthInfoDao dao = new AuthInfoDaoImpl();

    @Test
    public void insertAuthInfo()  {

        for (int i = 1; i < 100; i++) {
            authInfo = new AuthInfo(i, "测试数据" + i, "1", "1", "1", "1");
            try {
                dao.insertAuthInfo(authInfo);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void deleteAuthInfo()  {
        for (int i = 20; i < 100; i++) {
            try {
                dao.deleteAuthInfo(i);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void updateAuthInfo()  {

        AuthInfo authInfo = new AuthInfo(1, "测试数据AAA", "0", "1", "1", "0");

        try {
            dao.updateAuthInfo(authInfo);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void queryAuthInfoNum() {

        try {
            System.out.println("表长度：" + dao.queryAuthInfoNum());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void query()  {

        ArrayList<AuthInfo> list = null;
        try {
            list = dao.query(95, 110);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //for (AuthInfo authInfo : list)
            //System.out.println(authInfo.toString());
    }

    @Test
    public void query2()  {

        try {
            authInfo = dao.query(0);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //System.out.println(authInfo.toString());
    }

    @Test
    public void query3(){

        try {
            authInfo = dao.query("5");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //System.out.println(authInfo.toString());
    }

}