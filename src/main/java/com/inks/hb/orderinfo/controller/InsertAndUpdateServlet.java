package com.inks.hb.orderinfo.controller;

import com.google.gson.Gson;
import com.inks.hb.login.pojo.Login;
import com.inks.hb.orderinfo.pojo.OrderInfo;
import com.inks.hb.orderinfo.service.OrderInfoService;
import com.inks.hb.orderinfo.service.OrderInfoServiceImpl;
import com.inks.hb.roomtype.pojo.RoomType;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "InsertAndUpdateServlet", value = "/InsertAndUpdateServlet")
public class InsertAndUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        OrderInfoService service = new OrderInfoServiceImpl();

        String orderId = request.getParameter("orderId");  //1
        String orderName = request.getParameter("orderName");  //2
        String orderPhone = request.getParameter("orderPhone"); //3
        String orderIDcard = request.getParameter("orderIDcard");  //4
        RoomType typeId = new RoomType(request.getParameter("typeId")); //5
        String arrireDate = request.getParameter("arrireDate"); //6
        String leaveDate = request.getParameter("leaveDate"); //7
        String orderState = request.getParameter("orderState"); //8
        String checkNum = request.getParameter("checkNum"); //9
        String roomId = ""; //10
        String price = request.getParameter("price"); //11
        String checkPrice = request.getParameter("checkPrice"); //12
        String discountReason = request.getParameter("discountReason"); //14
        String addBed = request.getParameter("addBed"); //15
        String addBedPrice = request.getParameter("addBedPrice"); //16
        String orderMoney = request.getParameter("orderMoney"); //17
        String remark = request.getParameter("remark"); //18
        Login operatorId = new Login(request.getParameter("operatorId")); //19
        int make = Integer.parseInt(request.getParameter("make")); // 20 标志啊

        int discount;

        try { //对折扣值为空的处理
            discount = Integer.parseInt(request.getParameter("discount")); //13
        } catch (NumberFormatException e) {
            discount = 0;
        }

        OrderInfo orderInfo = new OrderInfo(orderId, orderName, orderPhone, orderIDcard, typeId, arrireDate, leaveDate, orderState, checkNum, roomId, price, checkPrice, discount, discountReason, addBed, addBedPrice, orderMoney, remark, operatorId);

        int code = -1; //返回的状态

        if (make == 1) { //1.新增
            code = service.insertOrderInfo(orderInfo);
        } else if (make == 2) { //修改
            code = service.updateOrderInfo(orderInfo);
        }


        //make=1 -> 1:插入成功 0：存在同名项 -1:插入失败
        //make=2 -> 1:修改成功 -1;修改失败
        Gson gson = new Gson();
        out.print(gson.toJson(code));
    }
}
