package com.lulu.spring;

import com.lulu.spring.config.JavaConfig;
import com.lulu.spring.controller.CountryController;
import com.lulu.spring.event.Event;
import com.lulu.spring.event.EventPublisher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(JavaConfig.class)
public class AnnotationTest {

    @Autowired
    public CountryController controller;
    @Autowired
    EventPublisher publisher;

    @Test
    public void test01() {
        System.out.println(controller.getCountryById("AR"));
    }

    /**
     * notify
     */
    @Test
    public void test02() {
        publisher.publishEvent(new Event<>(this, "lulu"));
    }
}
