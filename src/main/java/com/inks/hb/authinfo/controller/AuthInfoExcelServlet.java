package com.inks.hb.authinfo.controller;

import com.inks.hb.authinfo.pojo.AuthInfo;
import com.inks.hb.authinfo.service.AuthService;
import com.inks.hb.authinfo.service.AuthServiceImpl;
import com.inks.hb.common.ExportExcel;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "AuthInfoExcelServlet", value = "/AuthInfoExcelServlet")
public class AuthInfoExcelServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

        AuthService service = new AuthServiceImpl();

        ArrayList<AuthInfo> infoArrayList = null;
        try {
            infoArrayList = service.query(1, service.queryAuthInfoNum());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String[] headers = {"权限ID", "权限名称", "可读", "可写", "可改", "可删"};
        String fileName = "权限信息";

        ExportExcel<AuthInfo> ee = new ExportExcel<>();
        ee.exportExcel(headers, infoArrayList, fileName, response);
    }
}
