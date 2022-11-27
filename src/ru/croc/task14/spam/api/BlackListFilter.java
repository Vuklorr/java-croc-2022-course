package ru.croc.task14.spam.api;

import java.util.Iterator;
import java.util.function.Predicate;

public interface BlackListFilter <T, E extends Iterable <T>> {

    default E filterComments(E comments, Predicate<T> predicate) { //FIXME удалять из копии comments
        Iterator<T> commentIterator = comments.iterator();

        while (commentIterator.hasNext()) {
            T comment = commentIterator.next();
            if(predicate.test(comment)) {
                commentIterator.remove();
            }
        }
        return comments;
    }
}
