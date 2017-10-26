package com.inks.hb.common;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*") //拦截所有请求
public class CommonFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        // 转换为子接口类型
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        HttpSession session = request.getSession();

        //获得用户请求的URL
        String url = request.getRequestURI();
        boolean check = false;

        //应该做到只拦截.html和.jsp请求
        if (url.endsWith(".jsp") || url.endsWith(".html"))
            check = true;

        if (check) {
            System.out.println("当前请求：" + url);
            System.out.printf("===> 【过滤判定：");
        }
        if (!url.equals("/") && check) {
            if (session.getAttribute("LoginName") != null) {
                System.out.println("---->通过】\n");
                chain.doFilter(request,response);
            } else {
                System.out.println("---->未通过!】\n");
                response.sendRedirect("/");
            }
        }
        else {
            chain.doFilter(request, response);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
