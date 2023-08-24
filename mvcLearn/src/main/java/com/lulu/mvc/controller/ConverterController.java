package com.lulu.mvc.controller;

import com.lulu.mvc.bean.UserParam;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@Controller
@RequestMapping("/converter")
public class ConverterController {

    @PostMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String requestBody) {
        System.out.println(requestBody);
        return "converter/success";
    }

    @PostMapping("/testRequestEntity")
    public String testRequestEntity(RequestEntity<String> requestEntity) {
        System.out.println(requestEntity.getHeaders());
        System.out.println(requestEntity.getBody());
        return "converter/success";
    }

    @GetMapping("/testResponse")
    public void testResponseBody(HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        writer.println("hello response");
    }

    @GetMapping("/testResponseBody")
    @ResponseBody
    public UserParam testResponseBody() {
        //return "success";
        return new UserParam();
    }

    @RequestMapping("/testAjax")
    @ResponseBody
    public String testAjax(String username, String password){
        System.out.println("username:"+username+",password:"+password);
        return "hello,ajax";
    }
}
