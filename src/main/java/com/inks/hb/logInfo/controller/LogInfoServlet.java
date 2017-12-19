package com.inks.hb.logInfo.controller;

import com.google.gson.Gson;
import com.inks.hb.common.PojotoGson;
import com.inks.hb.logInfo.pojo.LogInfo;
import com.inks.hb.logInfo.service.LogInfoService;
import com.inks.hb.logInfo.service.LogInfoServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "LogInfoServlet", value = "/LogInfoServlet")
public class LogInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        int page = Integer.parseInt(request.getParameter("page")); // 当前页码
        int limit = Integer.parseInt(request.getParameter("limit")); // 每页的数据量
        int make = Integer.parseInt(request.getParameter("make"));

        // 调用service
        LogInfoService service = new LogInfoServiceImpl();

        // 默认输出信息
        String code = "0"; //状态码
        String msg = "数据查询正常"; //状态信息
        String count; //数据总数
        ArrayList<LogInfo> list; //数据内容
        if (make == 1) { //删除
            int logId = Integer.parseInt(request.getParameter("logId"));
            service.deleteLogInfo(logId);
        }

        count = String.valueOf(service.queryLogInfoNum());
        list = service.query(page, limit);

        PrintWriter out = response.getWriter();
        out.print(new Gson().toJson(new PojotoGson(code, msg, count, list)));
    }
}
