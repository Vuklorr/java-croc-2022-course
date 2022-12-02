package ru.croc.task13.cinema.util;
import java.util.Collection;

public class UtilClass {

    /**
     * Возвращает максимальное значение из колекции.
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

    /**
     * Половина фильмов, которые посмотрел пользователь.
     *
     * @param countClientsFilms - общее число просмотренных фильмов
     * @return - половина просмотренных фильмов
     */
    public static int getHalfClientsFilms(int countClientsFilms) {
        return countClientsFilms % 2 == 0
               ? countClientsFilms / 2
               : countClientsFilms / 2 + 1;
    }
}