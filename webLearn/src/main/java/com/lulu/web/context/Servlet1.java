package com.lulu.web.context;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.Objects;

public class Servlet1 extends HttpServlet {

    /**
     * web容器启动时会为每个web程序创建一个对应的ServletContext，它代表当前web应用：
     * 1. 共享数据
     * 2. 获取初始化参数
     * 3. 请求转发
     * 4. 读资源文件
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String str = req.getParameter("username");
        str = Objects.isNull(str)? "lulu" : str;
        this.getServletContext().setAttribute("username", str + ": " + new Date());
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/helloServlet");//转发的请求路径
        dispatcher.forward(req, resp);//请求转发
    }
}
