package com.inks.hb.roomtype.controller;

import com.google.gson.Gson;
import com.inks.hb.roomtype.pojo.RoomType;
import com.inks.hb.roomtype.service.RoomTypeService;
import com.inks.hb.roomtype.service.RoomTypeServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "InsertRoomTypeServlet", value = "/InsertRoomTypeServlet")
public class InsertRoomTypeServlet extends HttpServlet {
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
        RoomType roomType = gson.fromJson(json, RoomType.class);

        //主键ID没有想好暂时就用时间吧
        Date day = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyMMddHHmmss");
        roomType.setTypeId("RT" + df.format(day));

        // 调用service
        RoomTypeService service = new RoomTypeServiceImpl();
        PrintWriter out = response.getWriter();

        int code = service.insertRoomType(roomType);

        //code 1:插入成功 0：存在同名项 -1:插入失败
        out.print(gson.toJson(code));
    }
}
