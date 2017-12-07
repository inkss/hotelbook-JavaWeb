package com.inks.hb.floorinfo.controller;

import com.google.gson.Gson;
import com.inks.hb.floorinfo.service.FloorInfoService;
import com.inks.hb.floorinfo.service.FloorInfoServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 新增操作时判断数据库中已经拥有此角色
 */
@WebServlet(name = "QueryFloorNameServlet", value = "/QueryFloorNameServlet")
public class QueryFloorNameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        // 调用service
        FloorInfoService service = new FloorInfoServiceImpl();

        String newName = request.getParameter("new"); //获得姓名
        String oldName = request.getParameter("old");
        // 转换为json字符串格式
        Gson gson = new Gson();
        out.print(gson.toJson(service.queryRepeat(newName, oldName)));
    }
}
