package ru.croc.task14.spam.api;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Predicate;

public interface BlackListFilter <T> {

    /**
     * Удаляет комментарии, в которых содержатся слова из черного списка.
     *
     * @param comments - список комментраиев
     * @param predicate - предикат с условием фильтрования
     * @return - очищенные комментарии
     */
    default Iterable<T> filterComments(Iterable<T> comments, Predicate<T> predicate) {
        Iterator<T> commentsIterator = comments.iterator();
        Collection<T> clearComments = new ArrayList<>();

        while (commentsIterator.hasNext()) {
            T comment = commentsIterator.next();

            if(!predicate.test(comment)) {
                clearComments.add(comment);
            }
        }
        return clearComments;
    }
}