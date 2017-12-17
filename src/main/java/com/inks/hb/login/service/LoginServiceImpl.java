package com.inks.hb.login.service;

import com.inks.hb.common.MD5;
import com.inks.hb.login.dao.LoginDao;
import com.inks.hb.login.pojo.Login;

import java.sql.SQLException;
import java.util.ArrayList;

public class LoginServiceImpl implements LoginService {

    private LoginDao dao = new LoginDao();

    private MD5 md5 = new MD5();

    @Override
    public int queryByName(String name, String pwd) throws SQLException {
        Login loginQuery = new Login(name, pwd);
        Login login = (Login) dao.query(loginQuery);
        int check = 0;  //密码错误
        if (login.getLoginId() == 0)
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

        //密码转MD5加密存储
        String pwd = login.getLoginPwd();
        login.setLoginPwd(md5.getMD5(pwd));

        try {
            dao.insertData(login);
        } catch (SQLException e) {
            return -1;
        }
        return 1;
    }

    @Override
    public int deleteLogin(int loginId) {
        Login login = new Login();
        login.setLoginId(loginId);

        try {
            dao.deleteData(login);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
        return 1;
    }

    @Override
    public int updateLogin(Login login) {

        String pwd = login.getLoginPwd();
        login.setLoginPwd(md5.getMD5(pwd));

        try {
            dao.updateData(login);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
        return 1;
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

}