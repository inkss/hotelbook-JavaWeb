package com.july.hb.checkin.control;

import com.google.gson.Gson;
import com.july.hb.checkin.service.CheckinService;
import com.july.hb.checkin.service.CheckinServiceImpl;
import com.july.hb.common.PojotoGson;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "CheckinServlet",value = "/CheckinServlet")
public class CheckinServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws  IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws  IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        Gson gson = new Gson();
        out.print(gson.toJson(doMyServlet(request)));
    }

    private PojotoGson doMyServlet(HttpServletRequest request) {

        int page = Integer.parseInt(request.getParameter("page")); //当前页码
        int limit = Integer.parseInt(request.getParameter("limit")); //每页的数据量
        int make = Integer.parseInt(request.getParameter("make")); //状态标志

        // 调用service
        CheckinService service = new CheckinServiceImpl();

        // 默认输出信息
        String code = "0"; //状态码
        String msg = "数据查询正常"; //状态信息
        String count; //数据总数
        ArrayList list; //数据内容

        if (make == 1) { //删除
            String checkId = request.getParameter("checkId");
            code = String.valueOf(service.deleteCheckinInfo(checkId));
        }

        count = String.valueOf(service.queryCheckinNum());
        list = service.query(page,limit);

        return new PojotoGson(code, msg, count, list);
    }
}
