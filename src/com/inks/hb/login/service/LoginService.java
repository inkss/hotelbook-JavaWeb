package inks.hb.login.service;

import inks.hb.login.model.Login;

import java.sql.SQLException;

public interface LoginService {

    public Login queryByName(String name) throws SQLException;

}
