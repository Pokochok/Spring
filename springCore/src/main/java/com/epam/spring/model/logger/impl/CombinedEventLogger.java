package com.epam.spring.model.logger.impl;

import com.epam.spring.model.entity.event.Event;
import com.epam.spring.model.logger.EventLogger;

import java.util.Collection;

public class CombinedEventLogger implements EventLogger {
    private Collection<EventLogger> loggers;

    public CombinedEventLogger(Collection loggers) {
        this.loggers = loggers;
    }

    @Override
    public void logEvent(Event event) {
        loggers.forEach(logger -> logger.logEvent(event));
    }
}
