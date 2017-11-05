package com.inks.hb.login.dao;


import com.inks.hb.login.pojo.Login;
import org.junit.Test;

public class LoginDaoImplTest {

    private LoginDao dao = new LoginDaoImpl();

    @Test
    public void queryByName() throws Exception {

        Login login = dao.queryByName("1221");

        System.out.println(login.toString());
    }

}