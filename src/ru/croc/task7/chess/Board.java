package ru.croc.task7.chess;

public class Board {
    private static final char[] COLUMN = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
    private static final int[] ROW = {1, 2, 3, 4, 5, 6, 7, 8};

    public static char[] getColumn() {
        return COLUMN;
    }

    public static int[] getRow() {
        return ROW;
    }
}
