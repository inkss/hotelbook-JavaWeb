package com.inks.hb.login.service;

import java.sql.SQLException;

public interface LoginService {

    public int queryByName(String name, String pwd) throws SQLException;

}