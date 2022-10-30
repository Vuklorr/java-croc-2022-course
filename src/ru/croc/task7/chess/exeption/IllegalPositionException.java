package src.ru.croc.task7.chess.exeption;

import src.ru.croc.task7.chess.Board;

public class IllegalPositionException extends Exception {
    private final int x;
    private final int y;

    public IllegalPositionException(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String getMessage() {
        return x + "," + y + "! Позиция дожна быть от 0 до 7";
    }
}
