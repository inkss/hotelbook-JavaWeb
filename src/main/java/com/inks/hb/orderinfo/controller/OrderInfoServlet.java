package com.inks.hb.orderinfo.controller;

import com.google.gson.Gson;
import com.inks.hb.common.PojotoGson;
import com.inks.hb.orderinfo.pojo.OrderInfo;
import com.inks.hb.orderinfo.pojo.OrderToTable;
import com.inks.hb.orderinfo.service.OrderInfoService;
import com.inks.hb.orderinfo.service.OrderInfoServiceImpl;
import com.inks.hb.roomtype.service.RoomTypeService;
import com.inks.hb.roomtype.service.RoomTypeServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "OrderInfoServlet", value = "/OrderInfoServlet")
public class OrderInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        int page = Integer.parseInt(request.getParameter("page")); // 当前页码
        int limit = Integer.parseInt(request.getParameter("limit")); // 每页的数据量
        int make = Integer.parseInt(request.getParameter("make")); //状态标志

        // 调用service
        OrderInfoService service = new OrderInfoServiceImpl();
        RoomTypeService roomTypeService = new RoomTypeServiceImpl();

        // 默认输出信息
        String code = "0"; //状态码
        String msg = "数据查询正常"; //状态信息
        String count; //数据总数
        ArrayList<OrderInfo> list = new ArrayList<>(); //数据内容
        ArrayList<OrderToTable> toTablesList = new ArrayList<>(); //转成可使用
        OrderToTable toTable;

        //单个全局属性
        String orderId; //预定单号
        String select; //查询值

        //获取对应状态属性
        if (make == 1 || make == 2) { //1和2这部分完全是相同的
            select = request.getParameter("select");
            list = service.queryOrder(make, select);
            count = String.valueOf(list.size());
            msg = "结果如下";
        } else if (make == 4) {
            orderId = request.getParameter("orderId");
            if (service.deleteOrderInfo(orderId) == -1) {
                msg = "删除失败";
                code = "-1";
            }
            count = String.valueOf(service.queryOrderInfoNum());
        } else {
            list = service.query(page, limit);
            count = String.valueOf(service.queryOrderInfoNum());
        }

        for (OrderInfo orderInfo : list) { //转换成前端界面可接收的类型 主要是转 房间类型 和操作员
            toTable = new OrderToTable(orderInfo.getOrderId(), orderInfo.getOrderName(), orderInfo.getOrderPhone()
                    , orderInfo.getOrderIDcard(), orderInfo.getArrireDate(), orderInfo.getLeaveDate()
                    , roomTypeService.query(orderInfo.getTypeId().getTypeId()).getTypeName()
                    , orderInfo.getCheckNum(), orderInfo.getPrice(), orderInfo.getCheckPrice()
                    , orderInfo.getDiscount(), orderInfo.getDiscountReason(), orderInfo.getAddBed()
                    , orderInfo.getAddBedPrice(), orderInfo.getOrderMoney(), orderInfo.getOrderState()
                    , orderInfo.getRemark(), orderInfo.getOperatorId().getLoginName());
            toTablesList.add(toTable);
        }

        PojotoGson pojotoGson = new PojotoGson(code, msg, count, toTablesList);
        Gson gson = new Gson();
        out.print(gson.toJson(pojotoGson));
    }
}
