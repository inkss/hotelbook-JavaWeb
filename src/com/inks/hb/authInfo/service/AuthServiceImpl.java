package com.inks.hb.authInfo.service;

import com.inks.hb.authInfo.dao.AuthInfoDao;
import com.inks.hb.authInfo.dao.AuthInfoDaoImpl;
import com.inks.hb.authInfo.pojo.AuthInfo;

import java.sql.SQLException;
import java.util.ArrayList;

public class AuthServiceImpl implements AuthService {

    AuthInfoDao dao = new AuthInfoDaoImpl();

    @Override
    public int queryAuthInfoNum() throws SQLException {

        return dao.queryAuthInfoNum();
    }

    @Override
    public AuthInfo query(int authId) throws SQLException {

        return dao.query(authId);
    }

    @Override
    public AuthInfo query(String authItem) throws SQLException {

        return dao.query(authItem);
    }

    @Override
    public ArrayList<AuthInfo> query(int page, int limit) throws SQLException {

        int start, length;

        start = (page * limit) - limit + 1; //每一页的起始位置

        length = limit;

        if (start < 1)  //小于1的话会触发一个错误
            start = 1;  //但是理论上page和limit是由table表格生成的参数

        ArrayList<AuthInfo> list = dao.query(start, length);

        return list;
    }

    @Override
    public void updateAuthInfo(AuthInfo authInfo) throws SQLException {
        dao.updateAuthInfo(authInfo);
    }
}
