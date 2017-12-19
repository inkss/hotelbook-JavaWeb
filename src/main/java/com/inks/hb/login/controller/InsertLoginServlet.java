package com.inks.hb.login.controller;

import com.google.gson.Gson;
import com.inks.hb.login.pojo.Login;
import com.inks.hb.login.service.LoginService;
import com.inks.hb.login.service.LoginServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "InsertLoginServlet", value = "/InsertLoginServlet")
public class InsertLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("application/json; charset=utf-8");

        // 获取前端传递的json数据
        BufferedReader reader = request.getReader();
        String json = reader.readLine();

        // 解析json
        Gson gson = new Gson();
        Login login = gson.fromJson(json, Login.class);

        LoginService service = new LoginServiceImpl();
        int code = service.insertLogin(login);

        PrintWriter out = response.getWriter();
        out.print(gson.toJson(code));
    }
}
