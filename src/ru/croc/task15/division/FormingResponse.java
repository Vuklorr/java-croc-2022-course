package ru.croc.task15.division;

import ru.croc.task15.division.util.ParseFile;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class FormingResponse {

    /**
     * Находит время формирования запроса.
     *
     * @return - время запроса в часах
     */
    public int timeFormingResponse() throws FileNotFoundException {
        List<Division> divisionsList = new ArrayList<>();
        ParseFile.parseFile("src/ru/croc/task15/division/file/application", divisionsList);
        int max = getDivisionOverallDuration(divisionsList.get(0));

        for(int i = 1; i < divisionsList.size(); i++) {
            int overallDuration = getDivisionOverallDuration(divisionsList.get(i));
            if(overallDuration > max) {
                max = overallDuration;
            }
        }
        return max;
    }

    /**
     * Возвращает общее время, за которое подразделение обрабатывает заявку.
     *
     * @param division - подразделение
     * @return - время обработки заявки в часах
     */

    private int getDivisionOverallDuration(Division division) {
        return getDivisionOverallDuration(division, 0);
    }

    /**
     * Рекурсивный метод нахождения полной обработки заявки.
     *
     * @param division - подразделение
     * @param count - время обработки
     * @return время обработки заявки
     */
    private int getDivisionOverallDuration(Division division, int count) {
        count += division.getProcessingTime();
        if(division.getParent() == null) {
            return count;
        }
        return getDivisionOverallDuration(division.getParent(), count);
    }
}
