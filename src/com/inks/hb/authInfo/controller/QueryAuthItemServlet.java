package com.inks.hb.authInfo.controller;

import com.google.gson.Gson;
import com.inks.hb.authInfo.pojo.AuthInfo;
import com.inks.hb.authInfo.service.AuthService;
import com.inks.hb.authInfo.service.AuthServiceImpl;
import com.inks.hb.common.PojotoJson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "QueryAuthItemServlet")
public class QueryAuthItemServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 设置编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        // 响应输出流
        PrintWriter out = response.getWriter();

        // 获取权限名称
        String authItem = request.getParameter("authItem");

        // 调用service
        AuthService service = new AuthServiceImpl();

        try {
            AuthInfo authInfo = service.query(authItem);
            Gson gson = new Gson();
            out.print(gson.toJson(authInfo));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
