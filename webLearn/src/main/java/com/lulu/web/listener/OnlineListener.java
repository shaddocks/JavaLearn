package com.lulu.web.listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.Objects;

@WebListener
public class OnlineListener implements HttpSessionListener {

    //创建session监听
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        ServletContext context = se.getSession().getServletContext();
        Integer count = (Integer) context.getAttribute("onlineCount");
        if (Objects.isNull(count)) {
            context.setAttribute("onlineCount", 1);
        } else {
            context.setAttribute("onlineCount", count + 1);
        }
    }

    //销毁session监听
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        ServletContext context = se.getSession().getServletContext();
        HttpSessionListener.super.sessionDestroyed(se);
        Integer count = (Integer) context.getAttribute("onlineCount");
        if (Objects.isNull(count)) {
            context.setAttribute("onlineCount", 0);
        } else {
            context.setAttribute("onlineCount", count - 1);
        }
    }
}
