package com.inks.hb.orderinfo.controller;

import com.inks.hb.common.ExportExcel;
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
import java.util.ArrayList;

@WebServlet(name = "OrderInfoExcelServlet", value = "/OrderInfoExcelServlet")
public class OrderInfoExcelServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

        OrderInfoService service = new OrderInfoServiceImpl();
        RoomTypeService roomTypeService = new RoomTypeServiceImpl();

        ArrayList<OrderInfo> infoArrayList = service.query(1, service.queryOrderInfoNum());

        ArrayList<OrderToTable> list = new ArrayList<>(); //转成可使用

        OrderToTable toTable;

        for (OrderInfo orderInfo : infoArrayList) { //转换成前端界面可接收的类型 主要是转 房间类型 和操作员
            toTable = new OrderToTable(orderInfo.getOrderId(), orderInfo.getOrderName(), orderInfo.getOrderPhone()
                    , orderInfo.getOrderIDcard(), orderInfo.getArrireDate(), orderInfo.getLeaveDate()
                    , roomTypeService.query(orderInfo.getTypeId().getTypeId()).getTypeName()
                    , orderInfo.getCheckNum(), orderInfo.getPrice(), orderInfo.getCheckPrice()
                    , orderInfo.getDiscount(), orderInfo.getDiscountReason(), orderInfo.getAddBed()
                    , orderInfo.getAddBedPrice(), orderInfo.getOrderMoney(), orderInfo.getOrderState()
                    , orderInfo.getRemark(), orderInfo.getOperatorId().getLoginName());
            list.add(toTable);
        }

        String[] headers = {"预订单号", "预定人", "联系电话", "身份证", "抵店时间", "离店时间", "房间类型", "入住人数", "客房价格", "入住价格", "折扣", "折扣原因", "是否加床", "加床价格", "预收款", "单据状态", "备注", "操作员"};
        String fileName = "预订单信息";

        ExportExcel<OrderToTable> ee = new ExportExcel<>();
        ee.exportExcel(headers, list, fileName, response);
    }
}
