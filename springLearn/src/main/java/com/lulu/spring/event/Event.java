package com.lulu.spring.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

public class Event<T> extends ApplicationEvent {

    @Getter
    private T event;

    public Event(Object source) {
        super(source);
    }

    public Event(Object source, T event) {
        this(source);
        this.event = event;
    }

    @Override
    public String toString() {
        return "Event{" +
                "event=" + event + ", " +
                "timestamp=" + getTimestamp() +
                '}';
    }
}
