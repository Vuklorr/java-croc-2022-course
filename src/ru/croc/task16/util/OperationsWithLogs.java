package ru.croc.task16.util;

import java.io.File;
import java.util.List;
import java.util.Objects;

public class OperationsWithLogs {

    /**
     * Получение фалов с расширинеиями .log и .trace.
     *
     * @param pathDir - путь к директории, в котрой находятся фалы логов
     * @param files - список, в котром хрянятся логи
     */
    public static void getLogFile (String pathDir, List<File> files) {
        File dir = new File(pathDir);

        if(dir.isDirectory()) {
            for(File file : Objects.requireNonNull(dir.listFiles())) {

                if(file.isDirectory()) {
                    getLogFile(file.getPath(), files);
                } else {
                    if(fileLog(file.getPath())) {
                        files.add(file);
                    }
                }
            }
        } else {
            if(fileLog(dir.getPath())) {
                files.add(dir);
            }
        }
    }

    /**
     * Проверка, что файл является логом.
     *
     * @param path - путь файла
     * @return - true в если в названии есть .log или .trace
     */
    private static boolean fileLog(String path) {
        return path.toLowerCase().endsWith(".log") || path.toLowerCase().endsWith(".trace");
    }
}