package com.inks.hb.authInfo.dao;

import com.inks.hb.authInfo.pojo.AuthInfo;
import org.junit.Test;

import java.util.ArrayList;

public class AuthInfoDaoImplTest {

    private AuthInfo authInfo;

    private AuthInfoDao dao = new AuthInfoDaoImpl();

    @Test
    public void insertAuthInfo() throws Exception {

        for (int i = 1; i < 100; i++) {
            authInfo = new AuthInfo(i, "测试数据" + i, "1", "1", "1", "1");
            dao.insertAuthInfo(authInfo);
        }
    }

    @Test
    public void deleteAuthInfo() throws Exception {

        dao.deleteAuthInfo(99);
    }

    @Test
    public void updateAuthInfo() throws Exception {

        AuthInfo authInfo = new AuthInfo(1,"测试数据AAA","0","1","1","0");

        dao.updateAuthInfo(authInfo);

    }

    @Test
    public void queryAuthInfoNum() throws Exception {

        System.out.println("表长度：" + dao.queryAuthInfoNum());
    }

    @Test
    public void query() throws Exception {

        ArrayList<AuthInfo> list = dao.query(95,110);

        for(AuthInfo authInfo : list)
            System.out.println(authInfo.toString());
    }

    @Test
    public void query2() throws Exception {

        authInfo = dao.query(0);

        System.out.println(authInfo.toString());
    }

    @Test
    public void query3() throws Exception {

        authInfo = dao.query("5");

        System.out.println(authInfo.toString());
    }

}