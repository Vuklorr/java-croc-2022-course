package ru.croc.task12.tests;

import org.testng.annotations.Test;
import ru.croc.task12.spam.RemoveSpam;

import java.util.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class RemoveSpamTest {

    private final Set<String> blackList = new HashSet<>(Arrays.asList("дом", "ром", "ком"));

    @Test
    private void emptyList() {
        List<String> comments = new ArrayList<>();
        RemoveSpam removeSpam = new RemoveSpam();
        removeSpam.filterComments(comments, blackList);
        assertTrue(comments.isEmpty());
    }

    @Test
    private void isEmpty() {
        List<String> comments = new ArrayList<>(List.of("ком"));
        RemoveSpam removeSpam = new RemoveSpam();
        removeSpam.filterComments(comments, blackList);
        assertTrue(comments.isEmpty());
    }

    @Test
    private void notInBlackList() {
        String[] comment = {"Привет",
                "мой cом",
                "Нет больше сил",
                "Много дел дел много",
                "этот Ваш кот всем надоел",
                "Сон убивает"};
        List<String> comments = new ArrayList<>(List.of(comment));
        RemoveSpam removeSpam = new RemoveSpam();
        removeSpam.filterComments(comments, blackList);
        assertEquals(comments.size(), 6);
    }

    @Test
    private void inBlackList() {
        String[] comment = {"Привет",
                            "мой ром",
                            "Нет больше сил",
                            "КОМ",
                            "Много дел дел много",
                            "этот Ваш дом всем надоел",
                            "РоМ  убивает"};
        List<String> comments = new ArrayList<>(List.of(comment));
        RemoveSpam removeSpam = new RemoveSpam();
        removeSpam.filterComments(comments, blackList);
        assertEquals(comments.size(), 3);
    }

    @Test
    private void inBlackListWithPunctuation() {
        String[] comment = {"ПРивет.",
                "Это мой ром.",
                "Нет, больше сил.",
                "КОМ!",
                "Много, дел! дел? много.",
                "этот Ваш дом!!! всем надоел!",
                "РоМ-убивает."};
        List<String> comments = new ArrayList<>(List.of(comment));
        RemoveSpam removeSpam = new RemoveSpam();
        removeSpam.filterComments(comments, blackList);
        assertEquals(comments.size(), 3);
    }

    @Test
    private void inBlackListWithBreakLine() {
        String[] comment = {"При\n вет",
                "Это\n мой ром",
                "Нет больше \n сил",
                "\nКОМ",
                "Много \n дел \nмного дел",
                "этот ваш \nдом всем надоел",
                "РоМ\n убивает"};
        List<String> comments = new ArrayList<>(List.of(comment));
        RemoveSpam removeSpam = new RemoveSpam();
        removeSpam.filterComments(comments, blackList);
        assertEquals(comments.size(), 3);
    }

    @Test
    private void inBlackListMix() {
        String[] comment = {"При\n вет!",
                "Это\n мой ром!!!",
                "Нет больше \n сил.",
                "\nКОМ!???",
                "Много \n дел! \nмного дел.",
                "этот ваш \n!дом! всем надоел",
                "РоМ-\n убивает"};
        List<String> comments = new ArrayList<>(List.of(comment));
        RemoveSpam removeSpam = new RemoveSpam();
        removeSpam.filterComments(comments, blackList);
        assertEquals(comments.size(), 3);
    }
}