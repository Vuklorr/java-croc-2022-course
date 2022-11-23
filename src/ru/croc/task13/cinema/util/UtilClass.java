package ru.croc.task13.cinema.util;
import java.util.Collection;

public class UtilClass {

    /**
     * Возвращает максимальное значение из колекции
     *
     * @param values - список значений
     * @return - максимальное значение
     */
    public static int getMax(Collection<Integer> values) {
        int max = 0;
        for (Integer i : values) {
            if(i > max) {
                max = i;
            }
        }
        return max;
    }
}