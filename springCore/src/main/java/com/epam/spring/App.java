package com.epam.spring;

import com.epam.spring.model.entity.Client;
import com.epam.spring.model.entity.event.Event;
import com.epam.spring.model.entity.event.EventType;
import com.epam.spring.model.logger.EventLogger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

public class App {
    private Client client;
    private EventLogger eventLogger;
    private Map<EventType, EventLogger> loggers;

    private void logEvent(Event event, EventType eventType){
        EventLogger logger = loggers.get(eventType);
        if (logger == null){
            logger = eventLogger;
        }
        event.setMsg(event.getMsg().replaceAll(client.getId(), client.getFullName()));
        logger.logEvent(event);
    }

    public App(Client client, EventLogger eventLogger, Map<EventType, EventLogger> loggers) {
        this.client = client;
        this.eventLogger = eventLogger;
        this.loggers = loggers;
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        App app = (App) applicationContext.getBean("app");

        Event event = (Event) applicationContext.getBean("event");
        event.setMsg("some event for user 1 \n");
        app.logEvent(event, EventType.INFO);
        event.setMsg("some event for user 2 \n");
        app.logEvent(event, EventType.ERROR);

        applicationContext.close();
    }
}
