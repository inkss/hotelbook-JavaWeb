package com.inks.hb.authinfo.service;

import com.inks.hb.authinfo.dao.AuthInfoDao;
import com.inks.hb.authinfo.dao.AuthInfoDaoImpl;
import com.inks.hb.authinfo.pojo.AuthInfo;

import java.sql.SQLException;
import java.util.List;

public class AuthServiceImpl implements AuthService {

    private AuthInfoDao dao = new AuthInfoDaoImpl();

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
    public List<AuthInfo> query(int page, int limit) throws SQLException {

        int start;

        start = (page * limit) - limit + 1; //每一页的起始位置

        if (start < 1)
            start = 1;

        return dao.query(start, limit);
    }

    @Override
    public void updateAuthInfo(AuthInfo authInfo) throws SQLException {
        dao.updateAuthInfo(authInfo);
    }
}
