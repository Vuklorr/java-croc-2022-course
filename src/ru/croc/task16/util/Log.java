package ru.croc.task16.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Log {
    private final BufferedReader reader;
    private String lastLine;
    private long lastTime;

    public Log(File file) throws IOException {
        reader = new BufferedReader(new FileReader(file));
        readLine();
    }

    public void readLine() throws IOException {
        do {
            lastLine = reader.readLine();
            if (lastLine == null) return;
        }
        while (lastLine.isBlank());
        lastTime = Long.parseLong(lastLine.split(" ")[0]);
    }

    public String getLastLine() {
        return lastLine;
    }

    public long getLastTime() {
        return lastTime;
    }

    public void close() throws IOException {
        reader.close();
    }
}