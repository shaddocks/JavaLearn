package com.lulu.mvc.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("/scope")
public class ScopeController {

    @RequestMapping("/")
    public String index() {
        return "scope/index";
    }

    @RequestMapping("/testRequestByServletAPI")
    public String testRequestByServletAPI(HttpServletRequest request) {
        request.setAttribute("testRequestScope", "testRequestByServletAPI");
        //相当于转发
        return "scope/success";
    }

    @RequestMapping("/testModeAndView")
    public ModelAndView testModeAndView() {
        ModelAndView modelAndView = new ModelAndView();
        //处理模型数据，即向请求域request共享数据
        modelAndView.addObject("testRequestScope", "testModeAndView");
        //设置视图名称
        modelAndView.setViewName("scope/success");
        return modelAndView;
    }

    @RequestMapping("/testModel")
    public String testModel(Model model) {
        model.addAttribute("testRequestScope", "testModel");
        return "scope/success";
    }

    @RequestMapping("/testMap")
    public String testMap(Map<String, Object> map) {
        map.put("testRequestScope", "testMap");
        return "scope/success";
    }

    @RequestMapping("/testModelMap")
    public String testModelMap(ModelMap map) {
        map.put("testRequestScope", "testModelMap");
        return "scope/success";
    }

    @RequestMapping("/testSession")
    public String testSession(HttpSession session) {
        session.setAttribute("testRequestScope", "testSession");
        return "scope/success";
    }

    @RequestMapping("/testApplication")
    public String testApplication(HttpSession session) {
        ServletContext context = session.getServletContext();
        context.setAttribute("testRequestScope", "testApplication");
        return "scope/success";
    }
}
