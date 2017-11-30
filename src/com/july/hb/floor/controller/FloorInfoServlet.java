package com.july.hb.floor.controller;

import com.google.gson.Gson;
import com.july.hb.common.PojotoGson;
import com.july.hb.floor.pojo.FloorInfo;
import com.july.hb.floor.service.FloorInfoService;
import com.july.hb.floor.service.FloorInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * 与表格相关的全部操作
 * 状态标志： make 0重载 1新增 2修改 3搜索 4删除
 */
@WebServlet(name = "/FloorInfoServlet", value = "/FloorInfoServlet")
public class FloorInfoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        int page = Integer.parseInt(request.getParameter("page")); //当前页码
        int limit = Integer.parseInt(request.getParameter("limit")); //每页的数据量
        int make = Integer.parseInt(request.getParameter("make")); //状态标志

        // 调用service
        FloorInfoService service = new FloorInfoServiceImpl();

        // 默认输出信息
        String code = "0"; //状态码
        String msg = "数据查询正常"; //状态信息
        String count = ""; //数据总数
        ArrayList list = new ArrayList<>(); //数据内容
        ArrayList<FloorInfo> searchList = new ArrayList<>(); //数据内容

        //单个全局属性
        int floorId = 0;
        String floorName = "";
        FloorInfo floorInfo = new FloorInfo();

        //获取对应状态属性
        if (make == 1 || make == 3) {
            floorName = request.getParameter("floorName");
        } else if (make == 2) {
            floorId = Integer.parseInt(request.getParameter("floorId"));
            floorName = request.getParameter("floorName");
            floorInfo = new FloorInfo(floorId, floorName);
        } else if (make == 4) {
            floorId = Integer.parseInt(request.getParameter("floorId"));
        }

        // 状态标志 make 0重载 1新增 2修改 3搜索 4删除
        switch (make) {
            case 1:
                if (service.insertFloorInfo(floorName) == -1) {
                    msg = "插入异常";
                    code = "-1";
                }
                break;
            case 2:
                if (service.updateFloorInfo(floorInfo) == -1) {
                    msg = "修改异常";
                    code = "-1";
                }
                break;
            case 3:
                list = service.query(1, service.queryFloorInfoNum());
                searchList.clear();
                for (Object temp : list) {
                    floorInfo = (FloorInfo) temp;
                    if(floorName.equals(floorInfo.getFloorName())) {
                        searchList.add(floorInfo);
                    }
                } break;
            case 4:
                if (service.deleteFloorInfo(floorId) == -1) {
                    msg = "删除失败";
                    code = "-1";
                }
                break;
        }

        if (make != 3) {
            list = service.query(page, limit);
            count = String.valueOf(service.queryFloorInfoNum());
        } else { //这部分算是对3搜索的特殊处理，放这儿和放case里一样的。
            int size = searchList.size();
            if (size == 0) {
                msg = "查无此项";
                code = "-1";
            } else {
                list = searchList;
                count =  Integer.toString(size);
            }
        }

        PojotoGson pojotoGson = new PojotoGson(code, msg, count, list);
        Gson gson = new Gson();
        out.print(gson.toJson(pojotoGson));
    }
}
