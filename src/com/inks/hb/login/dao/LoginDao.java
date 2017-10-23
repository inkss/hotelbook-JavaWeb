package com.inks.hb.login.dao;

import com.inks.hb.login.pojo.Login;

import java.sql.SQLException;

public interface LoginDao {

    /**
     * @param loginName emm
     * @return Login对象
     * @throws SQLException 数据库错误
     */
    public Login queryByName(String loginName) throws SQLException;

}
