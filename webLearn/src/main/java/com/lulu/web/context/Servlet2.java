package com.lulu.web.context;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

public class Servlet2 extends HttpServlet {

    /**
     * web服务器接收到客户端的http请求，针对这个请求分别创建一个代表请求的HttpServletRequest对象，
     * 代表响应的HttpServletResponse对象。获取客户端参数找一，响应客户端数据找二。
     * 两者的使用方法百度
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
        Object username = this.getServletContext().getAttribute("username");
        PrintWriter writer = resp.getWriter();
        writer.println(username);
    }
}
