package ru.croc.task14.test;

import org.testng.annotations.Test;
import ru.croc.task14.spam.api.BlackListFilter;

import java.util.*;
import java.util.function.Predicate;

import static org.testng.Assert.assertEquals;

public class BlackListFilterTest {

    @Test
    private void simpleListString() {
        List<String> blackList = new ArrayList<>(Arrays.asList("дом", "ром", "ком"));
        List<String> comments = new ArrayList<>(Arrays.asList("1", "ром", "2"));
        BlackListFilter<String, List<String>> filter = new BlackListFilter<>() {};

        Predicate<String> predicate = comment -> {
            String[] words = comment
                    .replaceAll("\\p{Punct}|\\s|\\n", " ") //все знаки препинания заменить на пробел
                    .toLowerCase() // привести к нижнему регистру
                    .split(" "); //разбить комментарий на отдельные слова

            for (String word : words) {
                if(blackList.contains(word)) {
                    return true;
                }
            }
            return false;
        };

        List<String> clear = filter.filterComments(comments, predicate);

        assertEquals(comments.size(), 3);
        assertEquals(clear.size(), 2);
    }

    @Test
    private void simpleListInteger() {

    }
}
