package com.lulu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view")
public class ViewController {

    @RequestMapping("/")
    public String index() {
        return "view/index";
    }


    @RequestMapping("/testThymeleafView")
    public String testThymeleafView() {
        return "view/success";
    }

    @RequestMapping("/testForward")
    public String testForward() {
        return "forward:/view/testThymeleafView";
    }

    @RequestMapping("/testRedirect")
    public String testRedirect() {
        return "redirect:/view/testThymeleafView";
        //下一个Tab: Control + Tab
        //前一个Tab: Control + Shift + Tab
    }
}
