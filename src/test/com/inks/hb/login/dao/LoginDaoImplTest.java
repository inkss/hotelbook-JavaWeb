package com.inks.hb.login.dao;


import com.inks.hb.login.pojo.Login;
import org.junit.Test;

import java.sql.SQLException;

public class LoginDaoImplTest {

    private LoginDao dao = new LoginDaoImpl();

    @Test
    public void queryByName()  {

        Login login = null;
        try {
            login = dao.queryByName("1221");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //System.out.println(login.toString());
    }

}