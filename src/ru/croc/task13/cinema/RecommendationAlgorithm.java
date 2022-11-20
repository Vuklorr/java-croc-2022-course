package ru.croc.task13.cinema;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class RecommendationAlgorithm {

    public String recommendedFilms(String clientsFilmString) throws FileNotFoundException {
        Cinema cinema = new Cinema();
        List<String> clientsFilmList = new ArrayList<>(List.of(clientsFilmString.split(",")));
        List<String> listOfMatchingFilm = new ArrayList<>();

        for(List<String> clientList : cinema.getBrowsingHistory()) { //отобрать клиентов, у которых просмотры схожи
            if(filmsMatch(clientList, clientsFilmList)) {
                listOfMatchingFilm.add(clientList.toString());

            }
        }


        return "";
    }

    private boolean filmsMatch(List<String> clientList, List<String> clientsFilmList) {
        int countMatch = 0;
        for(String film : clientsFilmList) {
            if(clientList.contains(film)) {
                countMatch++;
                clientList.remove(film);
            }
        }

        return countMatch >= (clientsFilmList.size() / 2);
    }

    private void deleteViewedFilms(List<String> listFilm, List<String> clientsFilmList) {

    }
}
