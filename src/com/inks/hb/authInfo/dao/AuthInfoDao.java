package com.inks.hb.authInfo.dao;

import com.inks.hb.authInfo.pojo.AuthInfo;

import java.sql.SQLException;
import java.util.ArrayList;

public interface AuthInfoDao {

    /**
     * 插入一条数据到权限表中
     *
     * @param authInfo 完整的authInfo对象
     * @throws SQLException
     */
    void insertAuthInfo(AuthInfo authInfo) throws SQLException;

    /**
     * 查询AuthInfo表的长度
     *
     * @return
     * @throws SQLException
     */
    int queryAuthInfoNum() throws SQLException;

    /**
     * 分页查询权限表中数据
     *
     * @param start 开始位置, 起始坐标为0
     * @param length 返回多少数据
     * @return
     * @throws SQLException
     */
    ArrayList<AuthInfo> query(int start,int length) throws SQLException;
}
