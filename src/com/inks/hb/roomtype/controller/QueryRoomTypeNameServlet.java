package com.inks.hb.roomtype.controller;

import com.google.gson.Gson;
import com.inks.hb.roomtype.service.RoomTypeService;
import com.inks.hb.roomtype.service.RoomTypeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "/QueryRoomTypeNameServlet",value = "/QueryRoomTypeNameServlet")
public class QueryRoomTypeNameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        // 调用service
        RoomTypeService service = new RoomTypeServiceImpl();

        String typeName = request.getParameter("typeName"); //获得姓名

        try {
            Gson gson = new Gson();
            out.print(gson.toJson(service.queryRepeat(typeName)));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
