package com.inks.hb.roomtype.controller;

import com.google.gson.Gson;
import com.inks.hb.common.PojotoGson;
import com.inks.hb.roomtype.pojo.RoomType;
import com.inks.hb.roomtype.service.RoomTypeService;
import com.inks.hb.roomtype.service.RoomTypeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "/RoomTypeServlet", value = "/RoomTypeServlet")
public class RoomTypeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        int page = Integer.parseInt(request.getParameter("page")); // 当前页码
        int limit = Integer.parseInt(request.getParameter("limit")); // 每页的数据量
        int make = Integer.parseInt(request.getParameter("make"));

        // 调用service
        RoomTypeService service = new RoomTypeServiceImpl();

        // 默认输出信息
        String code = "0"; //状态码
        String msg = "数据查询正常"; //状态信息
        String count = ""; //数据总数
        ArrayList<RoomType> list = new ArrayList<>(); //数据内容

        //单个全局属性
        String typeId; //类型编号
        String typeName; //类型名称
        String price; //价格
        String splicPrice; //拼房价格
        int exceedance; //可超预定数
        String isSplice; //是否可拼房
        RoomType roomType = null;

        try {
            // 状态标志 make 0重载 1新增 2修改 3搜索 4删除

            if (make == 1 || make == 2) { //1和2这部分完全是相同的
                typeId = request.getParameter("typeId");
                typeName = request.getParameter("typeName");
                price = request.getParameter("price");
                splicPrice = request.getParameter("splicPrice");
                exceedance = Integer.parseInt(request.getParameter("exceedance"));
                isSplice = request.getParameter("isSplice");
                roomType = new RoomType(typeId, typeName, price, splicPrice, exceedance, isSplice);
            }

            switch (make) {
                case 1:
                    service.insertRoomType(roomType);
                    break;
                case 2:
                    service.updateRoomType(roomType);
                    break;
                case 3:
                    typeId = request.getParameter("typeId");
                    roomType = service.query(typeId);
                    list.clear();   //清空list
                    list.add(roomType);
                    break;
                case 4:
                    typeId = request.getParameter("typeId");
                    service.deleteRoomType(typeId);
                    break;
            }
            if (make != 3) {
                list = service.query(page, limit);
                count = String.valueOf(service.queryRoomTypeNum());
            } else {
                if (roomType.getTypeName() == null)
                    count = "0";
                else
                    count = "1";
            }
        } catch (SQLException e) {
            code = "1";
            msg = "数据查询出现异常";
            e.printStackTrace();
        } finally {
            PojotoGson pojotoGson = new PojotoGson(code, msg, count, list);
            Gson gson = new Gson();
            out.print(gson.toJson(pojotoGson));
        }
    }
}
