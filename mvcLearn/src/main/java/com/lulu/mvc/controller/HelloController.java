package com.lulu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/hello")
public class HelloController {

    // @RequestMapping注解：处理请求和控制器方法之间的映射关系
    // @RequestMapping注解的value属性可以通过请求地址匹配请求，/表示的当前工程的上下文路径
    // localhost:8080/springMVC/
    @RequestMapping(value = {"/index", "/first"},
            method = {RequestMethod.GET, RequestMethod.POST},
            headers = {"Host=localhost:8080"})
    public String index() {
        //设置视图名称
        return "index";
    }

    @GetMapping("/target")
    public String toTarget() {
        return "target";
    }

    @RequestMapping(value = "restfulMethod/{id}/{name}")
    public String restfulMethod(@PathVariable("id") Integer id, @PathVariable("name") String name) {
        System.out.println("id: " + id + ", name: " + name);
        return "target";
    }
}
