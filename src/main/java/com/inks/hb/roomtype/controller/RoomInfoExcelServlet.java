package com.inks.hb.roomtype.controller;

import com.inks.hb.common.ExportExcel;
import com.inks.hb.roomtype.pojo.RoomType;
import com.inks.hb.roomtype.service.RoomTypeService;
import com.inks.hb.roomtype.service.RoomTypeServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

@WebServlet(name = "RoomInfoExcelServlet", value = "/RoomInfoExcelServlet")
public class RoomInfoExcelServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

        RoomTypeService service = new RoomTypeServiceImpl();

        ArrayList<RoomType> infoArrayList = null;

        infoArrayList = service.query(1, service.queryRoomTypeNum());

        String[] headers = {"类型编号", "类型名称", "价格", "拼房价格", "可超预定数", "是否可拼房"};
        String fileName = "房间类型信息";

        ExportExcel<RoomType> ee = new ExportExcel<>();
        ee.exportExcel(headers, infoArrayList, fileName, response);
    }
}
