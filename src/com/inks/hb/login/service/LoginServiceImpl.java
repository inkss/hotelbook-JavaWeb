package com.inks.hb.login.service;

import com.inks.hb.login.dao.LoginDao;
import com.inks.hb.login.dao.LoginDaoImpl;
import com.inks.hb.login.pojo.Login;

import java.sql.SQLException;

public class LoginServiceImpl implements LoginService{

    private LoginDao loginDao = new LoginDaoImpl();

    @Override
    public int queryByName(String name,String pwd) throws SQLException {

        Login login = loginDao.queryByName(name);

        System.out.println(login.toString());

        //判断用代码放在业务层

        int check = 0;  //密码错误
        if (login.getLoginAdmin() == -1)
            check = -1; //账户不存在
        else if (login.getLoginPwd().equals(pwd))
            check = 1;  //登录成功

        return check;
    }
}