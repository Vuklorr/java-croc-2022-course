package ru.croc.task13;

import ru.croc.task13.cinema.RecommendationAlgorithm;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task13 {
    public static void main(String[] args) throws FileNotFoundException {
        RecommendationAlgorithm recommendationAlgorithm = new RecommendationAlgorithm();
        Scanner in = new Scanner(System.in);
        System.out.println(recommendationAlgorithm.recommendedFilm(in.nextLine()));
        in.close();
    }
}