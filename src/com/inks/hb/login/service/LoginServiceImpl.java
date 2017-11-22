package com.inks.hb.login.service;

import com.inks.hb.login.dao.LoginDao;
import com.inks.hb.login.pojo.Login;

import java.sql.SQLException;

public class LoginServiceImpl implements LoginService {

    private LoginDao dao = new LoginDao();

    @Override
    public int queryByName(String name, String pwd) throws SQLException {

        Login loginQuery = new Login(name, pwd);
        Login login = (Login) dao.query(loginQuery);

        int check = 0;  //密码错误
        if (login.getLoginAdmin() == -1)
            check = -1; //账户不存在
        else if (login.getLoginPwd().equals(pwd))
            check = 1;  //登录成功

        return check;
    }

    @Override
    public Login queryLogin(String name) throws SQLException {

        Login loginQuery = new Login();
        loginQuery.setLoginName(name);

        return (Login) dao.query(loginQuery);
    }
}