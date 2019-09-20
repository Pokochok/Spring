package com.epam.spring.model.logger.impl;

import com.epam.spring.model.entity.event.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.util.List;

@Component("cacheFileEventLogger")
public class CacheFileEventLogger extends FileEventLogger {
    private int cacheSize;
    private List<Event> cache;

    @Autowired
    public CacheFileEventLogger(String fileName, int cacheSize) {
        super(fileName);
        this.cacheSize = cacheSize;
    }

    @Override
    public void logEvent(Event event) {
        cache.add(event);
        if (cache.size() >= cacheSize) {
            writesEventsFromCache();
            cache.clear();
        }
    }

    private void writesEventsFromCache(){
        while(cache.iterator().hasNext()){
            super.logEvent(cache.iterator().next());
        }
    }

    @PreDestroy
    public void destroy(){
        if (!cache.isEmpty()){
            writesEventsFromCache();
        }
    }
}
