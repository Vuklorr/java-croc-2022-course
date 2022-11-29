package ru.croc.task16.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class MergingLogs {

    /**
     * Выводит все логи в консоль в порядке возрастания по времени. Время в POSIX
     *
     * @param pathDir - путь начальной директории
     */
    public static void mergingLog(String pathDir) throws FileNotFoundException {
        List<File> files = new ArrayList<>();
        List<String> listLog = new ArrayList<>();

        OperationWithLogs.getLogFile(pathDir, files);
        for(File file : files) {
            OperationWithLogs.addLog(file, listLog);
        }
        listLog.sort(String::compareTo);
        listLog.forEach(System.out::println);
    }
}