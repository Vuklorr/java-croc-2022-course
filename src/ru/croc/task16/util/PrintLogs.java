package ru.croc.task16.util;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class PrintLogs {

    /**
     * Выводит все логи в консоль в порядке возрастания по времени. Время в POSIX
     *
     * @param pathDir - путь начальной директории
     */
    public static void printLogsMerged(String pathDir) throws IOException {
        List<File> files = new ArrayList<>();
        Queue<Log> logQueue = new PriorityQueue<>(Comparator.comparingLong(Log::getLastTime));

        OperationsWithLogs.getLogFile(pathDir, files);
        for(File file : files) {
            logQueue.add(new Log(file));
        }

        while (!logQueue.isEmpty()) {
            Log log = logQueue.poll();
            String logLine = log.getLastLine();
            if(logLine != null) {
                System.out.println(logLine);
                log.readLine();
                logQueue.add(log);
            }
            else {
                log.close();
            }
        }
    }
}