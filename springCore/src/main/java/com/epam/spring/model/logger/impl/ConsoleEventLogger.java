package com.epam.spring.model.logger.impl;

import com.epam.spring.model.entity.event.Event;
import com.epam.spring.model.logger.EventLogger;
import org.springframework.stereotype.Component;

@Component("consoleEventLogger")
public class ConsoleEventLogger implements EventLogger {
    public void logEvent(Event event){
        System.out.println(event);
    }
}
