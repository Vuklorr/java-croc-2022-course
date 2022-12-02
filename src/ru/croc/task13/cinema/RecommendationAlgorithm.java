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
        List<List<String>> recommendedFilmsList = new ArrayList<>();

        for(List<String> clientsFilms : cinema.getBrowsingHistory()) {
            List<String> similarFilms = filmsMatch(clientsFilms);
            if(!(similarFilms == null)) {
                recommendedFilmsList.add(similarFilms);
            }
        }

        String keyRecommendationFilm = getKeyRecommendationFilm(recommendedFilmsList);

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
     * @param filmList - список фильмов пользователя
     * @return filmList - список рекомендованных фильмов
     */
    private List<String> filmsMatch(List<String> filmList) {
        Set<String> filmsMatchSet = new HashSet<>();
        Set<String> clientsFilmSet = new HashSet<>(clientsFilmList);

        for (String film : filmList) {
            if (clientsFilmList.contains(film)) {
                filmsMatchSet.add(film);
            }
        }

        int halfClientsFilms = UtilClass.getHalfClientsFilms(clientsFilmSet.size()); //взять половину просмотренных пользователем фильмов
        if (filmsMatchSet.size() >= halfClientsFilms) { //хотя бы наполовину совпадают
            filmList.removeAll(filmsMatchSet); //удалить те, которые пользователь уже посмотрел
            return filmList;
        }
        return null;
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
