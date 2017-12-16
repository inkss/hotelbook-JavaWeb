package com.july.hb.billInfo.control;

import com.google.gson.Gson;
import com.july.hb.billInfo.pojo.BillInfo;
import com.july.hb.billInfo.service.BillService;
import com.july.hb.billInfo.service.BillServiceImpl;
import com.july.hb.checkin.pojo.CheckinInfo;
import com.july.hb.checkin.service.CheckinService;
import com.july.hb.checkin.service.CheckinServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "InsertBillInfoServlet", value = "/InsertBillInfoServlet")
public class InsertBillInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("application/json; charset=utf-8");

        // 获取前端传递的json数据
        BufferedReader reader = request.getReader();
        String json = reader.readLine();

        // 解析json
        Gson gson = new Gson();
        CheckinInfo checkinInfo = gson.fromJson(json, CheckinInfo.class);
        CheckinService checkinService = new CheckinServiceImpl();
        CheckinInfo checkin = checkinService.query(checkinInfo.getCheckId());
        if (!checkin.getCheckState().equals("结算")) {
            checkin.setPrice(checkinInfo.getPrice());
            checkin.setDiscount(checkinInfo.getDiscount());
            checkin.setMoney(checkinInfo.getMoney());
            checkin.setOrderMoney(checkinInfo.getOrderMoney());
            checkin.setCheckMoney(checkinInfo.getCheckMoney());
            checkin.setCheckoutDate(checkinInfo.getCheckoutDate());
            checkin.setCheckState("结算");
            checkin.setIsCheck("是");
            checkinService.updateCheckinInfo(checkin);
        }

        BillInfo billInfo = new BillInfo();
        Date day = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyMMddHHmm");
        billInfo.setBillId(Integer.parseInt(df.format(day)));
        billInfo.setCheckId(checkinInfo.getCheckId());
        billInfo.setCostMoney(checkinInfo.getCheckMoney());
        billInfo.setCostDate(checkinInfo.getCheckoutDate());
        billInfo.setRemark(checkinInfo.getRemark());

        BillService service = new BillServiceImpl();

        PrintWriter out = response.getWriter();
        int code = service.insertBillInfo(billInfo);
        out.print(gson.toJson(code));
    }
}
