package src.ru.croc.task8;

import src.ru.croc.task8.util.CountWord;

import java.io.FileNotFoundException;

public class Task8 {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(CountWord.countWord(args[0]));
    }
}
