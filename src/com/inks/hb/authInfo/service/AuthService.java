package com.inks.hb.authInfo.service;

import com.inks.hb.authInfo.pojo.AuthInfo;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * AuthService函数表
 * -------------
 * 1. int queryAuthInfoNum()
 * 2. AuthInfo query(int authId)
 * 3. AuthInfo query(String authItem)
 * 4. ArrayList<AuthInfo> query(int page, int limit)
 */
public interface AuthService {



    /**
     * 查询AuthInfo表的长度
     *
     * @return 权限表长度
     * @throws SQLException 数据库
     */
    int queryAuthInfoNum() throws SQLException;

    /**
     *
     * @param authId ID
     * @return 权限表
     * @throws SQLException 数据库
     */
    AuthInfo query(int authId) throws SQLException;

    /**
     *
     * @param authId ID
     * @return 权限表
     * @throws SQLException 数据库
     */
    AuthInfo query(String authItem) throws SQLException;

    /**
     * 分页查询权限表中数据
     * page和limit参数是有layui框架的table传递过来的
     *
     * @param page 当前页码
     * @param limit 每页的数据量
     * @return 返回请求页数的数据
     * @throws SQLException 数据库
     */
    ArrayList<AuthInfo> query(int page, int limit) throws SQLException;



}
