package com.lulu.spring.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class EventListener<T> implements ApplicationListener<Event<T>> {
    @Override
    public void onApplicationEvent(Event<T> event) {
        System.out.println("接口收到事件 " + event.toString());
    }

    @org.springframework.context.event.EventListener({Event.class})
    //@TransactionalEventListener
    public void listener(Event<T> event) {
        System.out.println("注解收到事件 " + event.toString());
    }
}
