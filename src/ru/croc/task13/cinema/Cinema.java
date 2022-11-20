package ru.croc.task13.cinema;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class Cinema {

    private final HashMap<String, String> films = new HashMap<>();
    private final List<List<String>> browsingHistory = new ArrayList<>();

    public Cinema() throws FileNotFoundException {
        generateFilms();
        generateBrowsingHistory();
    }

    public HashMap<String, String> getFilms() {
        return films;
    }

    public List<List<String>> getBrowsingHistory() {
        return browsingHistory;
    }

    private void generateFilms() throws FileNotFoundException {
        File fileFilms = new File("ru/croc/task13/cinema/fileResource/films");
        Scanner in = new Scanner(new FileInputStream(fileFilms));

        while(in.hasNext()) {
            String str = in.nextLine();
            String key = str.substring(0, str.indexOf(","));
            String name = str.substring(str.indexOf(",") + 1);
            films.put(key, name);
        }
    }

    private void generateBrowsingHistory() throws FileNotFoundException {
        File fileBH = new File("src/ru/croc/task13/cinema/fileResource/browsingHistory");
        Scanner in = new Scanner(new FileInputStream(fileBH));

        while(in.hasNext()) {
            String str = in.nextLine();
            List<String> list = new ArrayList<>(List.of(str.split(",")));
            browsingHistory.add(list);
        }
    }
}