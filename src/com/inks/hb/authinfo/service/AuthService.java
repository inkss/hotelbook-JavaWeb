package com.inks.hb.authinfo.service;

import com.inks.hb.authinfo.pojo.AuthInfo;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * AuthService
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
     * 根据权限ID查询权限表
     *
     * @param authId ID
     * @return 权限表，如果无结果，返回空参构造对象
     * @throws SQLException 数据库
     */
    AuthInfo query(int authId) throws SQLException;

    /**
     * 根据权限名称查询权限表
     *
     * @param authItem 权限项目
     * @return 权限表，如果无结果，返回空参构造对象
     * @throws SQLException 数据库
     */
    AuthInfo query(String authItem) throws SQLException;

    /**
     * 分页查询权限表中数据
     * page和limit参数是有layui框架的table传递过来的
     *
     * @param page  当前页码
     * @param limit 每页的数据量
     * @return 返回请求页数的数据
     * @throws SQLException 数据库
     */
    ArrayList query(int page, int limit) throws SQLException;

    /**
     * 根据ID修改权限表属性
     *
     * @param authInfo 完整权限对象
     * @throws SQLException 数据库
     */
    void updateAuthInfo(AuthInfo authInfo) throws SQLException;

}
