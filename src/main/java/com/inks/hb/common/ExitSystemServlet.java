package com.inks.hb.common;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 * 作用 退出系统时 清除session
 */
@WebServlet(value = "/ExitSystemServlet", name = "ExitSystemServlet")
public class ExitSystemServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();

        if (session.getAttribute("LoginName") != null) {
            //System.out.println("已清除---> LoginName的session值\n");
            session.removeAttribute("LoginName");

        }
    }
}
