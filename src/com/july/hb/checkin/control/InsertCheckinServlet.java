package com.july.hb.checkin.control;

import com.google.gson.Gson;
import com.july.hb.checkin.pojo.CheckinInfo;
import com.july.hb.checkin.service.CheckinService;
import com.july.hb.checkin.service.CheckinServiceImpl;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class InsertCheckinServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        CheckinService service = new CheckinServiceImpl();

        String checkID = request.getParameter("checkID");
        String checkName = request.getParameter("checkName");
        String checkPhone = request.getParameter("checkPhone");
        String checkIDcard = request.getParameter("checkIDcard");
        String typeId =  request.getParameter("typeId");
        String arrireDate  = request.getParameter("arrireDate ");
        String leaveDate  = request.getParameter("leaveDate");
        String price = request.getParameter("price");
        String checkMoney = request.getParameter("checkMoney");
        String ifCheckout = request.getParameter("ifCheckout");
        String orderMoney = request.getParameter("orderMoney");


        //CheckinInfo checkinInfo = new CheckinInfo(checkID, checkName, checkPhone, checkIDcard, typeId, arrireDate, leaveDate, price, checkMoney, ifCheckout, orderMoney);

        //int code = service.insertCheckinInfo(checkinInfo);

        //code 1:插入成功 0：存在同名项 -1:插入失败
        Gson gson = new Gson();
        //out.print(gson.toJson(code));
    }
}
