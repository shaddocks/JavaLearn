package com.lulu.mvc.controller.errorresolver;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@ControllerAdvice将当前类标识为异常处理的组件
@ControllerAdvice
public class AnnotationResolverController {


    //@ExceptionHandler用于设置所标识方法处理的异常
    @ExceptionHandler(ArithmeticException.class)
    public String handleArithmeticException(Exception ex, Model model){
        model.addAttribute("exception", ex);
        return "error";
    }

}
