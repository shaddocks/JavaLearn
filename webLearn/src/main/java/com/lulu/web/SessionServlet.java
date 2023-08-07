package com.lulu.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/sessionServlet")
public class SessionServlet extends HttpServlet {

    //依赖cookie关联
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        HttpSession session = req.getSession();
        PrintWriter writer = resp.getWriter();

        if (!session.isNew()) {
            writer.write((String) session.getAttribute("name"));
        } else {
            session.setAttribute("name", "lulu");
        }
    }
}
