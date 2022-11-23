package ru.croc.task13.cinema;

import ru.croc.task13.cinema.util.UtilClass;

import java.io.FileNotFoundException;
import java.util.*;

public class RecommendationAlgorithm {

    /**
     * Список просмотренных фильмов пользователем
     */
    private List<String> clientsFilmList = new ArrayList<>();

    /**
     * Находит рекомендованный фильм
     *
     * @param clientsFilmString - Фильмы, которые посмотрел пользователь
     * @return название рекомендованного фильма
     */
    public String recommendedFilm(String clientsFilmString) throws FileNotFoundException {
        Cinema cinema = new Cinema();
        setClientsFilmList(clientsFilmString);
        List<List<String>> listRecommendedFilm = new ArrayList<>();

        for(List<String> clientsFilms : cinema.getBrowsingHistory()) {
            filmsMatch(clientsFilms, listRecommendedFilm);
        }

        String keyRecommendationFilm = getKeyRecommendationFilm(listRecommendedFilm);

        if(keyRecommendationFilm == null) {
            return "Рекомендованных фильмов нет.";
        }

        return cinema.getFilms().get(keyRecommendationFilm);
    }

    /**
     * Преобразует строку в список.
     *
     * @param clientsFilmString - фильмы, которые посмотрел пользователь
     */
    private void setClientsFilmList(String clientsFilmString) {
        clientsFilmList = List.of(clientsFilmString.split(","));
    }

    /**
     * Находит фильмы, которые хотя бы наполовину совпадают с просмотрами клиента + удаляет фильмы,
     * которые пользователь уже посмотрел.
     *
     * @param clientList - список фильмов пользователя
     * @param listFilmsMatch - список фильмов, которые еще не посмотрел пользователь
     */
    private void filmsMatch(List<String> clientList, List<List<String>> listFilmsMatch) {
        int countMatch = 0;
        Iterator<String> filmIterator = clientList.iterator();

        while(filmIterator.hasNext()) {
            String nextFilm = filmIterator.next();
            if (clientsFilmList.contains(nextFilm)) {
                countMatch++;
                filmIterator.remove();
            }
        }

        if (countMatch > (clientsFilmList.size() / 2) && !clientList.isEmpty()) { //хотя бы наполовину совпадают
            listFilmsMatch.add(clientList);
        }
    }

    /**
     * Взять ключ самого просматриваемого фильма.
     *
     * @param listFilm - список фильмов, которые еще не посмотрел пользователь
     * @return - ключ самого просматриваемого фильма
     */
    private String getKeyRecommendationFilm(List<List<String>> listFilm) {
        HashMap<String, Integer> maxRecommendation = new HashMap<>();

        for(List<String> list : listFilm) {
            for(String film : list) {
                if(maxRecommendation.containsKey(film)) {
                    int temp = maxRecommendation.get(film);
                    temp += 1;
                    maxRecommendation.replace(film, temp);
                } else {
                    maxRecommendation.put(film, 1);
                }
            }
        }
        int max = UtilClass.getMax(maxRecommendation.values());

        for(String key : maxRecommendation.keySet()) {
            if(maxRecommendation.get(key).equals(max)) {
                return key;
            }
        }
        return null;
    }
}
