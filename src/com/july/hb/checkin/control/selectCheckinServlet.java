package com.july.hb.checkin.control;

import com.google.gson.Gson;
import com.july.hb.checkin.service.CheckinService;
import com.july.hb.checkin.service.CheckinServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "selectCheckinServlet",value = "/selectCheckinServlet")
public class selectCheckinServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        // 响应输出流
        PrintWriter out = response.getWriter();

        CheckinService service = new CheckinServiceImpl();


        ArrayList list = service.billInfo(1, service.queryCheckinNum());
        //转换为json字符串格式
        Gson gson = new Gson();
        out.print(gson.toJson(list));
    }
}
