package com.epam.spring.model.logger;

import com.epam.spring.model.entity.event.Event;

public interface EventLogger {
    void logEvent(Event event);
}
