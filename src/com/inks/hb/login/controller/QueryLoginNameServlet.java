package inks.hb.login.controller;

import com.google.gson.Gson;
import inks.hb.login.dao.LoginDao;
import inks.hb.login.dao.LoginDaoImpl;
import inks.hb.login.model.Login;
import inks.hb.login.service.LoginService;
import inks.hb.login.service.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(value = "/QueryLoginNameServlet", name = "/QueryLoginNameServlet")
public class QueryLoginNameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 设置编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        // 响应输出流
        PrintWriter out = response.getWriter();

        // 调用service
        LoginService service = new LoginServiceImpl();

        // 获得姓名
        String loginName = request.getParameter("loginName");

        //System.out.printf("\nServlet得到的loginName值为：" + loginName);

        try {
            //LoginDao dao = new LoginDaoImpl();
            //Login login1 = new Login(1, "5", "5666", 6);
            //Login login2 = dao.queryByName(loginName);
            Login login = service.queryByName(loginName);
            System.out.println(login.toString());

            //转换为json字符串格式
            Gson gson = new Gson();

            out.print(gson.toJson(login));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
