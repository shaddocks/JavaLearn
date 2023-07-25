package com.lulu.spring.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Order(1)
public class LogAspect {

    @Pointcut("execution(public * com.lulu.spring.dao..*(..))")
    public void pointCut() {}

    @Before("pointCut()")
    public void beforeMethod(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        String name = joinPoint.getSignature().getName();
        System.out.println(name + "方法前, 参数是: " + Arrays.toString(args));
    }

    @After("pointCut()")
    public void afterMethod() {
        System.out.println("方法后");
    }

    @AfterThrowing(value = "pointCut()", throwing = "exception")
    public void throwMethod(Exception exception) {
        System.out.println("方法异常: " + exception.getMessage());
    }

    @AfterReturning(value = "pointCut()", returning = "returnValue")
    public void returnMethod(Object returnValue) {
        System.out.println("方法返回, 参数: " + returnValue);
    }
}
