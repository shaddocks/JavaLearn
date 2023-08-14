package com.lulu.mvc.controller;

import com.lulu.mvc.bean.UserParam;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/param")
public class ParamController {

    @RequestMapping("/")
    public String index() {
        return "param/testParam";
    }

    @RequestMapping("testServletAPI")
    public String testServletAPI(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username: " + username + ", password: " + password);
        return "target";
    }

    @RequestMapping("/testControllerParam")
    public String testControllerParam(
            @RequestParam(value = "username", required = false, defaultValue = "hello") String username,
            Integer password,
            @RequestHeader("host") String host,
            @CookieValue("JSESSIONID") String cookie) {
        System.out.println("username: " + username + ", password: " + password);
        System.out.println("host: " + host);
        System.out.println("cookieId: " + cookie);
        return "target";
    }

    @RequestMapping("/testControllerPOJO")
    public String testControllerPOJO(UserParam user) {
        System.out.println(user);
        return "target";
    }
}
