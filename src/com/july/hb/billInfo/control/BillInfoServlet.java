package com.july.hb.billInfo.control;

import com.google.gson.Gson;
import com.july.hb.billInfo.service.BillService;
import com.july.hb.billInfo.service.BillServiceImpl;
import com.july.hb.common.PojotoGson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "BillInfoServlet",value = "/BillInfoServlet")
public class BillInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        PrintWriter out = response.getWriter();
        out.print(new Gson().toJson(doMyServlet(request)));
    }

    private PojotoGson doMyServlet(HttpServletRequest request) {

        int page = Integer.parseInt(request.getParameter("page")); //当前页码
        int limit = Integer.parseInt(request.getParameter("limit")); //每页的数据量
        int make = Integer.parseInt(request.getParameter("make")); //状态标志

        // 调用service
        BillService service = new BillServiceImpl();

        // 默认输出信息
        String code = "0"; //状态码
        String msg = "数据查询正常"; //状态信息
        String count; //数据总数
        ArrayList list; //数据内容

        if (make == 1) { //删除
            int billId = Integer.parseInt(request.getParameter("billId"));
            code = String.valueOf(service.deleteBillInfo(billId));
        }

        count = String.valueOf(service.queryBillNum());
        list = service.query(page,limit);

        return new PojotoGson(code, msg, count, list);
    }
}
