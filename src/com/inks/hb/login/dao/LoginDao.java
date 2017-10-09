package inks.hb.login.dao;

import inks.hb.login.model.Login;

import java.sql.SQLException;

public interface LoginDao {

    /**
     * @param loginName emm
     * @return Login对象
     * @throws SQLException 数据库错误
     */
    public Login queryByName(String loginName) throws SQLException;

}
