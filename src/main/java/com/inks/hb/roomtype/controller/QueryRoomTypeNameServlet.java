package com.inks.hb.roomtype.controller;

import com.google.gson.Gson;
import com.inks.hb.roomtype.service.RoomTypeService;
import com.inks.hb.roomtype.service.RoomTypeServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "QueryRoomTypeNameServlet", value = "/QueryRoomTypeNameServlet")
public class QueryRoomTypeNameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        // 调用service
        RoomTypeService service = new RoomTypeServiceImpl();

        String newName = request.getParameter("new"); //获得姓名
        String oldName = request.getParameter("old");

        // 转换为json字符串格式
        Gson gson = new Gson();
        out.print(gson.toJson(service.queryRepeat(newName, oldName)));
    }
}
