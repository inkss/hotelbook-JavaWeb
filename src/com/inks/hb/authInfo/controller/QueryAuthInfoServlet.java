package com.inks.hb.authInfo.controller;

import com.google.gson.Gson;
import com.inks.hb.authInfo.pojo.AuthINfotoJson;
import com.inks.hb.authInfo.pojo.AuthInfo;
import com.inks.hb.authInfo.service.AuthService;
import com.inks.hb.authInfo.service.AuthServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = "/QueryAuthInfoServlet",name = "/QueryAuthInfoServlet")
public class QueryAuthInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 设置编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        // 响应输出流
        PrintWriter out = response.getWriter();

        // 调用service
        AuthService service = new AuthServiceImpl();

        // 当前页码
        int page = Integer.parseInt(request.getParameter("page"));

        // 每页的数据量
        int limit = Integer.parseInt(request.getParameter("limit"));

        try {
            ArrayList<AuthInfo> list = service.query(page,limit);

            String count = String.valueOf(service.queryAuthInfoNum());

            AuthINfotoJson authINfotoJson = new AuthINfotoJson("0","权限表",count,list);

            //转换为json字符串格式
            Gson gson = new Gson();

            out.print(gson.toJson(authINfotoJson));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
