package com.july.hb.billInfo.control;

import com.july.hb.billInfo.pojo.BillInfo;
import com.july.hb.billInfo.service.BillService;
import com.july.hb.billInfo.service.BillServiceImpl;
import com.july.hb.common.ExportExcel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ToExcelServlet",value = "/ToExcelServlet")
public class ToExcelServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] headers = {"账单编号", "入住单号", "消费金额", "消费时间", "备注"};
        String fileName = "结算单信息";

        BillService service = new BillServiceImpl();

        ExportExcel<BillInfo> ee = new ExportExcel<>();
        ee.exportExcel(headers, service.query(1, service.queryBillNum()), fileName, response);
    }
}
