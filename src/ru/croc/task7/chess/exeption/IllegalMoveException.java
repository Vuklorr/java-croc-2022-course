package src.ru.croc.task7.chess.exeption;

import src.ru.croc.task7.chess.ChessPosition;

public class IllegalMoveException extends Exception {
    private final ChessPosition currentPosition;
    private final ChessPosition nextPosition;

    public IllegalMoveException(ChessPosition currentPosition, ChessPosition nextPosition) {
        this.currentPosition = currentPosition;
        this.nextPosition = nextPosition;
    }

    @Override
    public String getMessage() {
        return "конь так не ходит: " + currentPosition + " -> " + nextPosition;
    }
}
