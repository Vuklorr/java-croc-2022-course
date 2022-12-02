package ru.croc.task13.test;

import org.testng.annotations.Test;
import ru.croc.task13.cinema.RecommendationAlgorithm;

import java.io.FileNotFoundException;

import static org.testng.Assert.assertEquals;

public class TestTask13 {
    private final RecommendationAlgorithm recommendationAlgorithm = new RecommendationAlgorithm();
    @Test
    private void test1() throws FileNotFoundException {
        String films = "2,4";
        String nameRecommendedFilm = recommendationAlgorithm.recommendedFilm(films);
        assertEquals(nameRecommendedFilm, "Дюна");
    }

    @Test
    private void test2() throws FileNotFoundException {
        String films = "2,2,2,2,2,2,2,2,3,3,3,3,3,3,3";
        String nameRecommendedFilm = recommendationAlgorithm.recommendedFilm(films);
        assertEquals(nameRecommendedFilm, "Мстители: Финал");
    }

    @Test
    private void test3() throws FileNotFoundException {
        String films = "4,5,6";
        String nameRecommendedFilm = recommendationAlgorithm.recommendedFilm(films);
        assertEquals(nameRecommendedFilm, "Рекомендованных фильмов нет.");
    }

    @Test
    private void test4() throws FileNotFoundException {
        String films = "6,6,6,6,6,6,6";
        String nameRecommendedFilm = recommendationAlgorithm.recommendedFilm(films);
        assertEquals(nameRecommendedFilm, "Рекомендованных фильмов нет.");
    }

    @Test
    private void test5() throws FileNotFoundException {
        String films = "";
        String nameRecommendedFilm = recommendationAlgorithm.recommendedFilm(films);
        assertEquals(nameRecommendedFilm, "Рекомендованных фильмов нет.");
    }
}
