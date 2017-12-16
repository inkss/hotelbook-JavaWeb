package com.july.hb.checkin.control;

import com.google.gson.Gson;
import com.july.hb.checkin.pojo.CheckinInfo;
import com.july.hb.checkin.service.CheckinService;
import com.july.hb.checkin.service.CheckinServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "InsertCheckinServlet", value = "/InsertCheckinServlet")
public class InsertCheckinServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("application/json; charset=utf-8");

        // 获取前端传递的json数据
        BufferedReader reader = request.getReader();
        String json = reader.readLine();

        // 解析json
        Gson gson = new Gson();
        CheckinInfo checkinInfo = gson.fromJson(json, CheckinInfo.class);

        CheckinService service = new CheckinServiceImpl();
        PrintWriter out = response.getWriter();
        int code = service.insertCheckinInfo(checkinInfo);
        out.print(gson.toJson(code));
    }
}
