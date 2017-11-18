package com.inks.hb.common;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * 作用 退出系统时 清除session、cookie
 * 之所以单独写这个，是为了在js中直接发ajax请求
 * 前端主页直接套用了WIN10-UI框架，改装成jsp页面会出现一些莫名其妙的问题
 * 索性直接提供可以直接被js直接使用的命令，发请求调用
 * 清除cookie的方法很具有借鉴意义。
 * cookie表：
 * 1. "/login.jsp" ： loginName、loginNickName、loginAdmin
 * 2. “/MAIN/main.html : isLogin
 */
@WebServlet(value = "/ExitSystemServlet", name = "/ExitSystemServlet")
public class ExitSystemServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        Cookie cookies[] = request.getCookies();

        // 当前servlet在'/'目录下，所以下面的删除cookie只能删除当前域下的
        for (int i = 0; cookies != null && i < cookies.length; i++) {
            Cookie cookie = cookies[i];
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }

        // 其余域下的cookie删除方法
        // 思路是创建一个同名cookie，指定域setPath
        // 然后设置age为0，表示立即删除
        // 最后再通过response添加进去，因为同名的原因，所以会直接覆盖
        Cookie cookie = new Cookie("isLogin", "");
        cookie.setPath("/MAIN");
        cookie.setMaxAge(0);
        response.addCookie(cookie);

        if (session.getAttribute("LoginName") != null) {
            //System.out.println("已清除---> LoginName的session值\n");
            session.removeAttribute("LoginName");

        }
    }
}
