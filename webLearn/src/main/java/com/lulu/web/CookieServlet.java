package com.lulu.web;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class CookieServlet extends HttpServlet {

    //Cookie是禁止使用空格字符的，因此format字符串中的空格被识别为非法字符
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        //自己的cookie只有一个，还有一些其他的cookie
        Cookie[] cookies = req.getCookies();
        PrintWriter writer = resp.getWriter();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd.hh:mm:ss");

        if (Objects.nonNull(cookies) && cookies.length != 0) {
            writer.write(URLEncoder.encode("上次访问时间是", StandardCharsets.UTF_8));
            for (Cookie cookie: cookies) {
                if ("time".equals(cookie.getName())) {
                    writer.write(": " + cookie.getValue());
                    return;
                }
            }
        } else {
            writer.write(URLEncoder.encode("第一次访问", StandardCharsets.UTF_8));
        }
        //响应cookie
        Cookie cookie = new Cookie("time", format.format(new Date()));
        //有效期
        cookie.setMaxAge(5 * 60);
        resp.addCookie(cookie);
    }
}
