package com.inks.hb.login.service;

import com.inks.hb.login.pojo.Login;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoginServiceImplTest {

    @Test
    public void queryByName() {
    }

    @Test
    public void queryLogin() {
    }

    @Test
    public void insertLogin() {

        Login login = new Login("admin","123456","测试账户");

        int code = new LoginServiceImpl().insertLogin(login);
        System.out.println("code: " + code);
    }

    @Test
    public void deleteLogin() {
    }

    @Test
    public void updateLogin() {
    }

    @Test
    public void query() {
    }

    @Test
    public void queryLoginNum() {
    }
}