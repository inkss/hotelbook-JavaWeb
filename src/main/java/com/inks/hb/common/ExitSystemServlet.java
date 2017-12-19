package com.inks.hb.common;

import com.inks.hb.logInfo.pojo.LogInfo;
import com.inks.hb.logInfo.service.LogInfoService;
import com.inks.hb.logInfo.service.LogInfoServiceImpl;
import com.inks.hb.login.pojo.Login;
import com.inks.hb.login.service.LoginService;
import com.inks.hb.login.service.LoginServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.SQLException;

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
            String loginName = request.getSession().getAttribute("LoginName").toString();
            session.removeAttribute("LoginName");
            //写入退出记录
            LoginService service = new LoginServiceImpl();
            Login login = null;
            try {
                login = service.queryLogin(loginName);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            LogInfo logInfo = new LogInfo("退出", login.getLoginId(), loginName);
            LogInfoService logInfoService = new LogInfoServiceImpl();
            logInfoService.insertLogInfo(logInfo);

        }
    }
}
