package com.inks.hb.orderinfo.controller;

import com.google.gson.Gson;
import com.inks.hb.orderinfo.pojo.OrderInfo;
import com.inks.hb.orderinfo.pojo.OrderToTable;
import com.inks.hb.orderinfo.service.OrderInfoServiceImpl;
import com.inks.hb.roomtype.service.RoomTypeServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "QueryOrderInfoServlet", value = "/QueryOrderInfoServlet")
public class QueryOrderInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        // 获取值
        String orderId = request.getParameter("orderId");

        OrderInfo orderInfo = new OrderInfoServiceImpl().query(orderId);

        OrderToTable toTable = new OrderToTable(orderInfo.getOrderId(), orderInfo.getOrderName(), orderInfo.getOrderPhone()
                , orderInfo.getOrderIDcard(), orderInfo.getArrireDate(), orderInfo.getLeaveDate()
                , new RoomTypeServiceImpl().query(orderInfo.getTypeId().getTypeId()).getTypeId()
                , orderInfo.getCheckNum(), orderInfo.getPrice(), orderInfo.getCheckPrice()
                , orderInfo.getDiscount(), orderInfo.getDiscountReason(), orderInfo.getAddBed()
                , orderInfo.getAddBedPrice(), orderInfo.getOrderMoney(), orderInfo.getOrderState()
                , orderInfo.getRemark(), orderInfo.getOperatorId().getLoginName());

        Gson gson = new Gson();
        out.print(gson.toJson(toTable));
    }
}
