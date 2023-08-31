package com.lulu.mvcannotation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping("/testHello")
    public String testHello() {
        return "index";
    }
}
