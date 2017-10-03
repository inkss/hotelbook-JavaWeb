package inks.hb.login.service;

import inks.hb.login.dao.LoginDao;
import inks.hb.login.dao.LoginDaoImpl;
import inks.hb.login.model.Login;

import java.sql.SQLException;

public class LoginServiceImpl implements LoginService{

    private LoginDao loginDao = new LoginDaoImpl();

    @Override
    public Login queryByName(String name) throws SQLException {
        return loginDao.queryByName(name);
    }
}
