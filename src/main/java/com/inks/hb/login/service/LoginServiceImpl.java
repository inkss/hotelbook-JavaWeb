package com.inks.hb.login.service;

import com.inks.hb.login.dao.LoginDao;
import com.inks.hb.login.pojo.Login;

import java.sql.SQLException;
import java.util.ArrayList;

public class LoginServiceImpl implements LoginService {

    private LoginDao dao = new LoginDao();

    @Override
    public int queryByName(String name, String pwd) throws SQLException {
        Login loginQuery = new Login(name, pwd);
        Login login = (Login) dao.query(loginQuery);
        System.out.println(loginQuery);
        System.out.println(login);

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

    @Override
    public int insertLogin(Login login) {
        return 0;
    }

    @Override
    public int deleteLogin(String loginId) {
        return 0;
    }

    @Override
    public int updateLogin(Login login) {
        return 0;
    }

    @Override
    public ArrayList query(int page, int limit) {
        int start = (page * limit) - limit + 1; //每一页的起始位置

        if (start < 1)  //小于1的话会触发一个错误
            start = 1;  //但是理论上page和limit是由table表格生成的参数

        try {
            return dao.query(start, limit);
        } catch (SQLException e) {
            System.out.println(e.getErrorCode() + e.getMessage());
            return null;
        }
    }

    @Override
    public int queryLoginNum() {
        try {
            return dao.queryDataNum();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int queryRepeat(String newName, String oldName) {
        return 0;
    }
}