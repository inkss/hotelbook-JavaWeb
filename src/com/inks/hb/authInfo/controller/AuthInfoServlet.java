package com.inks.hb.authInfo.controller;

import com.google.gson.Gson;
import com.inks.hb.authInfo.pojo.AuthInfo;
import com.inks.hb.authInfo.service.AuthService;
import com.inks.hb.authInfo.service.AuthServiceImpl;
import com.inks.hb.common.PojotoGson;

import javax.servlet.ServletException;
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
 * 通过前端传入的make标志，本servlet完成了三项功能：
 * 1. make = 1 返回指定范围内的表信息
 * 2. make = 2 根据权限名称返回查询结果 一条数据
 * 3. make = 3 根据权限ID修改权限属性值 返回修改前数据
 * 如查询过程中出现异常，统一返回'数据查询出现异常'
 * 返回数据为pojotoGson类型
 */
@WebServlet(value = "/AuthInfoServlet", name = "/AuthInfoServlet")
public class AuthInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 设置编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        // 响应输出流
        PrintWriter out = response.getWriter();

        // 当前页码
        int page = Integer.parseInt(request.getParameter("page"));

        // 每页的数据量
        int limit = Integer.parseInt(request.getParameter("limit"));

        // 状态标志 make 0重载 1新增 2修改 3搜索 4删除
        int make = Integer.parseInt(request.getParameter("make"));

        // 调用service
        AuthService service = new AuthServiceImpl();

        String code = ""; //状态码
        String msg = ""; //状态信息
        String count = ""; //数据总数
        ArrayList<AuthInfo> list = null; //数据内容

        try {
            code = "0";
            msg = "数据查询正常";
            if (make == 0) {  //初始化表格
                list = service.query(page, limit);
                count = String.valueOf(service.queryAuthInfoNum());

            } else if (make == 3) {  //搜索表格
                // 权限名称
                String authItem = request.getParameter("authItem");
                AuthInfo authInfo = service.query(authItem);
                //System.out.println(authInfo.toString());
                list = new ArrayList<>();
                list.add(authInfo);
                count = "1";
            } else if (make == 2) { //修改值
                int authId = Integer.parseInt(request.getParameter("authId"));
                String authItem = request.getParameter("authItem");
                String isRead = request.getParameter("isRead");
                String isWrite = request.getParameter("isWrite");
                String isChange = request.getParameter("isChange");
                String isDelete = request.getParameter("isDelete");
                AuthInfo authInfo = new AuthInfo(authId, authItem, isRead, isWrite, isChange, isDelete);
                service.updateAuthInfo(authInfo);
                list = service.query(page, limit);
                count = String.valueOf(service.queryAuthInfoNum());
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
