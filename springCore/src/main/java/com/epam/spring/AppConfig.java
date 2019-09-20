package com.epam.spring;

import com.epam.spring.model.entity.event.Event;
import com.epam.spring.model.logger.EventLogger;
import com.epam.spring.model.logger.impl.CacheFileEventLogger;
import com.epam.spring.model.logger.impl.ConsoleEventLogger;
import com.epam.spring.model.logger.impl.FileEventLogger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean(name = "consoleEventLogger")
    public EventLogger getConsoleEventLogger(){
        return new ConsoleEventLogger();
    }

    @Bean(name = "fileEventLogger", value = "src/main/resources/log.txt")
    public EventLogger getFileEventLogger(){
        return new FileEventLogger();
    }

    @Bean(name = "cacheFileEventLogger", value = "5")
    public EventLogger getCacheFileEventLogger(){
        return new CacheFileEventLogger("", 2);
    }
}
