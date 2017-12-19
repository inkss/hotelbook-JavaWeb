package com.inks.hb.login.controller;

import com.google.gson.Gson;
import com.inks.hb.common.PojotoGson;
import com.inks.hb.logInfo.service.LogInfoServiceImpl;
import com.inks.hb.login.pojo.Login;
import com.inks.hb.login.service.LoginService;
import com.inks.hb.login.service.LoginServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "LoginTableServlet", value = "/LoginTableServlet")
public class LoginTableServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        int page = Integer.parseInt(request.getParameter("page")); // 当前页码
        int limit = Integer.parseInt(request.getParameter("limit")); // 每页的数据量
        int make = Integer.parseInt(request.getParameter("make")); //状态标志

        LoginService service = new LoginServiceImpl();

        String code = "0"; //状态码
        String msg = "数据查询正常"; //状态信息
        String count; //数据总数
        ArrayList list; //数据内容

        if (make == 4) { //删除
            int loginId = Integer.parseInt(request.getParameter("loginId"));
            new LogInfoServiceImpl().deleteByName(loginId);
            service.deleteLogin(loginId);
        }

        list = service.query(page, limit);
        count = String.valueOf(service.queryLoginNum());


        PojotoGson pojotoGson = new PojotoGson(code, msg, count, list);
        Gson gson = new Gson();
        out.print(gson.toJson(pojotoGson));
    }
}
