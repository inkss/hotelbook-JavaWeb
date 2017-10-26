package com.inks.hb.common;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 作用 退出系统时 清除session
 * 之所以单独写这个，是为了在js中直接发ajax请求
 * 前端主页直接套用了框架，改装成jsp页面不知道会不会出问题
 * 索性直接提供可以直接被js直接使用的命令
 *
 */
@WebServlet(value = "/ExitSystemServlet",name = "/ExitSystemServlet")
public class ExitSystemServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        if (session.getAttribute("LoginName") != null)
            session.removeAttribute("LoginName");
        System.out.println("当前session已清空\n");
    }
}
