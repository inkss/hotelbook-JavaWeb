package com.inks.hb.floorInfo.controller;

import com.google.gson.Gson;
import com.inks.hb.floorInfo.service.FloorInfoService;
import com.inks.hb.floorInfo.service.FloorInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * 新增操作时判断数据库中已经拥有此角色
 */
@WebServlet(name = "/QueryFloorNameServlet",value = "/QueryFloorNameServlet")
public class QueryFloorNameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 设置编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        // 响应输出流
        PrintWriter out = response.getWriter();

        // 调用service
        FloorInfoService service = new FloorInfoServiceImpl();

        // 获得姓名
        String floorName = request.getParameter("floorName");

        try {
            int check = service.queryRepeat(floorName);
            // 转换为json字符串格式
            Gson gson = new Gson();
            out.print(gson.toJson(check));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
