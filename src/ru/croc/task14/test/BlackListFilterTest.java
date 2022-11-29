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
        BlackListFilter<String> filter = new BlackListFilter<>() {};
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
        List<String> clearComments = new ArrayList<>(Arrays.asList("1", "2"));

        assertEquals(comments.size(), 3);
        assertEquals(clearComments, filter.filterComments(comments,predicate));
    }

    @Test
    private void simpleListInteger() {
        Set<Integer> blackList = new HashSet<>(Arrays.asList(1,3,5,6));
        Set<Integer> comments = new HashSet<>(Arrays.asList(1,2,3,4,5,6,7));
        BlackListFilter<Integer> filter = new BlackListFilter<>() {};
        Predicate<Integer> predicate = blackList::contains;
        Set<Integer> clearComments = new HashSet<>(Arrays.asList(2,4,7));

        assertEquals(comments.size(), 7);
        assertEquals(clearComments, filter.filterComments(comments,predicate));
    }
}