package com.epam.spring.model.logger.impl;

import com.epam.spring.model.entity.event.Event;
import com.epam.spring.model.logger.EventLogger;

public class ConsoleEventLogger implements EventLogger {
    public void logEvent(Event event){
        System.out.println(event);
    }
}
