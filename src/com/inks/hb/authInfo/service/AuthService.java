package com.inks.hb.authInfo.service;

import com.inks.hb.authInfo.pojo.AuthInfo;

import java.sql.SQLException;
import java.util.ArrayList;

public interface AuthService {

    /**
     * 分页查询权限表中数据
     *
     *
     * @param page 当前页码
     * @param limit 每页的数据量
     * @return 返回请求页数的数据
     * @throws SQLException 数据库
     */
    ArrayList<AuthInfo> query(int page, int limit) throws SQLException;

    /**
     * 查询AuthInfo表的长度
     *
     * @return 权限表长度
     * @throws SQLException 数据库
     */
    int queryAuthInfoNum() throws SQLException;
}
