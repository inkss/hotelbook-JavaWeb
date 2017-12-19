package com.inks.hb.authinfo.controller;

import com.google.gson.Gson;
import com.inks.hb.authinfo.pojo.AuthInfo;
import com.inks.hb.authinfo.service.AuthService;
import com.inks.hb.authinfo.service.AuthServiceImpl;
import com.inks.hb.common.PojotoGson;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * 分页查询权限表
 * 如查询过程中出现异常，统一返回'数据查询出现异常'
 * 返回数据为pojotoGson类型
 */
@WebServlet(value = "/AuthInfoServlet", name = "AuthInfoServlet")
public class AuthInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        int page = Integer.parseInt(request.getParameter("page")); // 当前页码
        int limit = Integer.parseInt(request.getParameter("limit")); // 每页的数据量
        int make = Integer.parseInt(request.getParameter("make"));

        // 调用service
        AuthService service = new AuthServiceImpl();

        // 默认输出信息
        String code = "0"; //状态码
        String msg = "数据查询正常"; //状态信息
        String count = ""; //数据总数
        ArrayList<AuthInfo> list = new ArrayList<>(); //数据内容

        //单个全局属性
        int authId;                  //权限ID
        String authItem = "";        //权限名称
        String isRead;               //可读
        String isWrite;              //可写
        String isChange;             //可改
        String isDelete;             //可删
        AuthInfo authInfo = null;

        try {

            // 状态标志 make 0重载 1新增 2修改 3搜索 4删除
            if (make == 2) {
                authId = Integer.parseInt(request.getParameter("authId"));
                authItem = request.getParameter("authItem");
                isRead = request.getParameter("isRead");
                isWrite = request.getParameter("isWrite");
                isChange = request.getParameter("isChange");
                isDelete = request.getParameter("isDelete");
                authInfo = new AuthInfo(authId, authItem, isRead, isWrite, isChange, isDelete);
            } else if (make == 3) {
                authItem = request.getParameter("authItem");
            }

            switch (make) {
                case 2:
                    service.updateAuthInfo(authInfo);
                    break;
                case 3:
                    authInfo = service.query(authItem);
                    list.clear();
                    list.add(authInfo);
                    break;
            }
            if (make != 3) {
                list = service.query(page, limit);
                count = String.valueOf(service.queryAuthInfoNum());
            } else {
                if (authInfo.getAuthId() == 0) {
                    count = "0";
                } else {
                    count = "1";
                }
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
