package com.inks.hb.login.dao;

import com.inks.hb.login.pojo.Login;

import java.sql.SQLException;

public interface LoginDao {

    /**
     * 根据登录名称查询 登录界面使用
     * 返回Login对象
     *
     * @param loginName emm
     * @return Login对象
     * @throws SQLException 数据库错误
     */
    Login queryByName(String loginName) throws SQLException;

}
