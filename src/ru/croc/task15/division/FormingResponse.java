package ru.croc.task15.division;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class FormingResponse {

    /**
     * Находит время формирования запроса.
     *
     * @return - максимальная общая продолжительность формирования ответа
     */
    public int timeFormingResponse() throws FileNotFoundException {
        File file = new File("src/ru/croc/task15/division/file/application");
        Scanner in = new Scanner(file);
        Map<String, Integer> divisions = new HashMap<>();
        int maxOverallDuration = -1;

        while (in.hasNextLine()) {
            String[] data = in.nextLine().split(",");
            int overallDuration = Integer.parseInt(data[2]);

            if (!data[1].equals("-")) { // если не родитель
                overallDuration += divisions.get(data[1]); // прибавить продолжительность обработки родителя
            }
            divisions.put(data[0], overallDuration);

            if (overallDuration > maxOverallDuration) {
                maxOverallDuration = overallDuration;
            }
        }
        in.close();

        return maxOverallDuration;
    }
}