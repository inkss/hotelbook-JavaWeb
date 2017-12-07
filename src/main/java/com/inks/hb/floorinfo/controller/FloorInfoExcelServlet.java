package com.inks.hb.floorinfo.controller;

import com.inks.hb.common.ExportExcel;
import com.inks.hb.floorinfo.pojo.FloorInfo;
import com.inks.hb.floorinfo.service.FloorInfoService;
import com.inks.hb.floorinfo.service.FloorInfoServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

@WebServlet(name = "FloorInfoExcelServlet", value = "/FloorInfoExcelServlet")
public class FloorInfoExcelServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

        FloorInfoService service = new FloorInfoServiceImpl();

        ArrayList<FloorInfo> infoArrayList = null;
        infoArrayList = service.query(1, service.queryFloorInfoNum());

        String[] headers = {"楼层编号", "楼层名称"};
        String fileName = "楼层信息";

        ExportExcel<FloorInfo> ee = new ExportExcel<>();
        ee.exportExcel(headers, infoArrayList, fileName, response);
    }
}
