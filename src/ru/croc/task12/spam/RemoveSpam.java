package ru.croc.task12.spam;

import ru.croc.task12.spam.api.BlackListFilter;

import java.util.List;
import java.util.Set;

public class RemoveSpam implements BlackListFilter {
    @Override
    public void filterComments(List<String> comments, Set<String> blackList) {
        comments.removeIf(comment -> isSpamComment(comment, blackList));
    }

    /**
     * Проверка есть ли запрещенное слово в комментарии.
     *
     * @param comment - комментарий
     * @param blackList - список запрещенных слов
     * @return true - если есть запрещенное слово
     */
    private boolean isSpamComment(String comment, Set<String> blackList) {
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
    }
}