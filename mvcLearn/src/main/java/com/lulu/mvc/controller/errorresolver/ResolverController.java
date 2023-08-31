package com.lulu.mvc.controller.errorresolver;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/resolver")
public class ResolverController {

    @RequestMapping("/testError")
    public String success() {
        List<Integer> res = null;
        System.out.println(res.get(1));
        return "target";
    }
}
