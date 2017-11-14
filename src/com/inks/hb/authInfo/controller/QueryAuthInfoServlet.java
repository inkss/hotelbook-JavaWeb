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

/**
 * 分页查询权限表
 */
@WebServlet(value = "/QueryAuthInfoServlet", name = "/QueryAuthInfoServlet")
public class QueryAuthInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 设置编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        // 响应输出流
        PrintWriter out = response.getWriter();

        // 当前页码
        int page = Integer.parseInt(request.getParameter("page"));

        // 每页的数据量
        int limit = Integer.parseInt(request.getParameter("limit"));

        // 状态标示 1：全部表格 2：搜索权限名称
        int make = Integer.parseInt(request.getParameter("make"));

        // 调用service
        AuthService service = new AuthServiceImpl();

        String code = ""; //状态码
        String msg = ""; //状态信息
        String count = ""; //数据总数
        ArrayList<AuthInfo> list = null; //数据内容

        try {
            code = "0";
            msg = "数据查询正常";
            if (make == 1) {  //初始化表格
                list = service.query(page, limit);
                count = String.valueOf(service.queryAuthInfoNum());
            } else if (make == 2) {  //重载表格
                // 权限名称
                String authItem = request.getParameter("authItem");
                AuthInfo authInfo = service.query(authItem);
                System.out.println(authInfo.toString());
                list = new ArrayList<>();
                list.add(authInfo);
                count = "1";
            }

        } catch (SQLException e) {
            code = "1";
            msg = "数据查询出现异常";
            e.printStackTrace();
        } finally {
            PojotoJson pojotoJson = new PojotoJson(code, msg, count, list);
            Gson gson = new Gson();
            out.print(gson.toJson(pojotoJson));
        }
    }
}
