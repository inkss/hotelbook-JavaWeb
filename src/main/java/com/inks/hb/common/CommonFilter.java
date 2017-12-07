package com.inks.hb.common;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 过滤器，拦截所有请求。
 * 仅当session中包含登录成功后的登录名后才放行请求
 */
@WebFilter(value = "/*", filterName = "CommonFilter") //拦截所有请求
public class CommonFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        // 转换为子接口类型
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        //设置响应报头允许当前应用被跨域请求（CROS）
        response.setHeader("Access-Control-Allow-Origin", "*");

        HttpSession session = request.getSession();

        // 获得用户请求的URL
        String url = request.getRequestURI();
        boolean check = false;

        // 因为是全局过滤，所以会对所有请求进行过滤，诸如css、js、png等等
        // 所以应该做到只拦截.html和.jsp请求，对请求地址的末尾进行判断
        // 修订 servlet加入拦截过滤范围
        if (url.endsWith(".jsp") || url.endsWith(".html") || url.endsWith("Servlet"))
            check = true;

        // 判断登录请求的servlet不过滤
        if (url.endsWith("/hb/QueryLoginNameServlet"))
            check = false;

        if (!url.equals("/hb") && check) {
            // 判断session中此值是否存在
            if (session.getAttribute("LoginName") != null) {
                //System.out.println("---->通过】");
                chain.doFilter(request, response); //放行
            } else {
                //System.out.println("---->未通过!】");
                response.sendRedirect("/hb"); //跳转回根目录
            }
        } else {
            // 非html和jsp请求一律不管
            chain.doFilter(request, response);
        }


        // 请求响应结束之后调用统一关闭连接方法
        DBUtil.close();
    }

    public void init(FilterConfig config) {

    }

}
