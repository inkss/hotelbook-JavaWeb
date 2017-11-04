package com.inks.hb.login.dao;

import com.inks.hb.login.pojo.Login;

import java.sql.SQLException;

/**
 * LoginDao函数表
 * -------------
 * 1. Login queryByName(String loginName)
 */
public interface LoginDao {

    /**
     * 根据登录名称查询 登录界面使用
     * 返回Login对象
     *
     * @param loginName 用户登录名
     * @return Login对象
     * @throws SQLException 数据库
     */
    Login queryByName(String loginName) throws SQLException;

}
