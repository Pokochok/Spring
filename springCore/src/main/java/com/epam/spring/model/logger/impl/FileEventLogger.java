package com.epam.spring.model.logger.impl;

import com.epam.spring.model.entity.event.Event;
import com.epam.spring.model.logger.EventLogger;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileEventLogger implements EventLogger {
    private String fileName;
    private File file;

    public FileEventLogger() {
    }

    public FileEventLogger(String fileName) {
        this.fileName = fileName;
    }

    public void init() throws IOException{
        this.file = new File(fileName);
        if (!file.canWrite()){
            throw new IOException("File isn't  accessible");
        }
    }

    @Override
    public void logEvent(Event event) {
        try {
            FileUtils.writeStringToFile(new File(fileName), event.getMsg(), "UTF-8", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
