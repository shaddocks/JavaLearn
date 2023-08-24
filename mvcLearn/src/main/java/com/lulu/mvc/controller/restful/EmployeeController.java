package com.lulu.mvc.controller.restful;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
@RequestMapping("/restful")
public class EmployeeController {

    private EmployeeDao dao;

    @Autowired
    public void setDao(EmployeeDao dao) {
        this.dao = dao;
    }


    //可用view-controller替换这个
    @RequestMapping("/")
    public String index() {
        return "restful/index";
    }

    @GetMapping("/employee")
    public String getAllEmployee(ModelMap map) {
        Collection<Employee> employees = dao.getAll();
        map.addAttribute("employees", employees);
        return "restful/employee_list";
    }

    @DeleteMapping("/employee/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id) {
        dao.delete(id);
        return "redirect:/restful/employee";
    }

    @PostMapping (value = "/employee")
    public String addEmployee(Employee employee) {
        dao.save(employee);
        return "redirect:/restful/employee";
    }

    @GetMapping("/employee/{id}")
    public String getEmployeeById(@PathVariable("id") Integer id, Model model) {
        Employee employee = dao.get(id);
        model.addAttribute("employee", employee);
        return "restful/employee_update";
    }

    @PutMapping("/employee")
    public String updateEmployee(Employee employee) {
        dao.save(employee);
        return "redirect:/restful/employee";
    }

}
