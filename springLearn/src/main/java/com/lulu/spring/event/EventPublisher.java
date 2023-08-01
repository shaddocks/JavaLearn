package com.lulu.spring.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

//ApplicationContext 已经继承了 ApplicationEventPublisher ，因此可以直接使用发布事件
@Component
public class EventPublisher implements ApplicationEventPublisher {

    ApplicationEventPublisher publisher;

    @Autowired
    public void setPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public void publishEvent(Object event) {
        System.out.println("发布事件");
        publisher.publishEvent(event);
    }
}
