package com.inks.hb.login.controller;

import com.google.gson.Gson;
import com.inks.hb.common.MD5;
import com.inks.hb.login.pojo.Login;
import com.inks.hb.login.service.LoginService;
import com.inks.hb.login.service.LoginServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "UpdatePwdServlet", value = "/UpdatePwdServlet")
public class UpdatePwdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        // 调用service
        LoginService service = new LoginServiceImpl();
        MD5 md5 = new MD5();

        // 获得姓名
        String loginName = request.getParameter("loginName");
        String loginPwd = request.getParameter("loginPwd");  //转成MD5存储

        Login login;
        int check = -1;

        try {
            login = service.queryLogin(loginName);
            System.out.println(login);
            login.setLoginPwd(loginPwd);
            System.out.println(login);
            check = service.updateLogin(login);
            System.out.println(check);
            System.out.println(service.queryLogin(loginName));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        out.print(gson.toJson(check));
    }
}
