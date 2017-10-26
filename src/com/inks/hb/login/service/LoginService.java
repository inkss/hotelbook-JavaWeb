package com.inks.hb.login.service;

import com.inks.hb.login.pojo.Login;

import java.sql.SQLException;

public interface LoginService {

    /**
     * 根据name和pwd返回判断结果
     *
     * @param name 登录名
     * @param pwd 登录密码
     * @return 判断结果
     * @throws SQLException 数据库错误
     */
    public int queryByName(String name, String pwd) throws SQLException;

    /**
     * 根据name返回Login对象
     *
     * @param name 登录名
     * @return  Login对象
     * @throws SQLException 数据库错误
     */
    public Login queryLogin(String name) throws SQLException;

}