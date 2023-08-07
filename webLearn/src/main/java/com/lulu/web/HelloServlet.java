package com.lulu.web;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("refresh", "5");
        // 通过getServletConfig 得到 ServletConfig 对象，
        // 这个getServletConfig 是 GenericServlet中的方法
        // 通过查看HttpServlet 可知，HttpServlet 继承于GenericServlet
        // GenericServlet 实现了Servlet 接口，同时也实现了ServletConfig 接口
        ServletConfig config = getServletConfig();
        // 获取初始化参数，也就是<init-param>
        // 通过servletConfig.getInitParameterNames() 获取<param-name>
        Enumeration<String> names = config.getInitParameterNames();
        while (names.hasMoreElements()) {
            String s = names.nextElement();
            String value = config.getInitParameter(s);
            System.out.println(s + ": " + value);
        }
        //ServletContext context = servletConfig.getServletContext();
        PrintWriter writer = resp.getWriter();
        writer.println("hell world");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        /*等价于下面
        resp.setHeader("Location", "/context/servlet1");
        resp.setStatus(302);
        */
        resp.sendRedirect("/context/servlet1");
    }
}
