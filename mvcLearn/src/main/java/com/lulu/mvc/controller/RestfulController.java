package com.lulu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/rest")
public class RestfulController {

    @RequestMapping("/")
    public String index() {
        return "rest/testRestful";
    }

    /*
    使用Restful模拟用户的增删改查
    /user get
    /user/1 get
    /user post
    /user/1 delete
    /user put
     */
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String getAllUser() {
        System.out.println("get all user");
        return "target";
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String getUserById(@PathVariable("id") String id) {
        System.out.println("user's id: " + id);
        return "target";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String insertUser(@RequestParam("username") String username, @RequestParam("password") String password) {
        System.out.println("username: " + username + ", password: " + password);
        return "target";
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public String alterUser(@RequestParam("username") String username, @RequestParam("password") String password) {
        System.out.println("username: " + username + ", password: " + password);
        return "target";
    }

}
