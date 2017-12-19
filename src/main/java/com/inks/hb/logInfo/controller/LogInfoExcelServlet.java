package com.inks.hb.logInfo.controller;

import com.inks.hb.common.ExportExcel;
import com.inks.hb.logInfo.pojo.LogInfo;
import com.inks.hb.logInfo.service.LogInfoService;
import com.inks.hb.logInfo.service.LogInfoServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

@WebServlet(name = "LogInfoExcelServlet", value = "/LogInfoExcelServlet")
public class LogInfoExcelServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        LogInfoService service = new LogInfoServiceImpl();

        ArrayList<LogInfo> infoArrayList;
        infoArrayList = service.query(1, service.queryLogInfoNum());

        String[] headers = {"日志编号", "内容", "用户编号", "用户名称", "日期"};
        String fileName = "日志信息";

        ExportExcel<LogInfo> ee = new ExportExcel<>();
        ee.exportExcel(headers, infoArrayList, fileName, response);
    }
}
