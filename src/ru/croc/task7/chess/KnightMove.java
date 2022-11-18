package ru.croc.task7.chess;

import ru.croc.task7.chess.exeption.IllegalMoveException;
import ru.croc.task7.chess.exeption.IllegalPositionException;

public class KnightMove {
    private final ChessPosition[] chessPositions;

    public KnightMove(ChessPosition[] chessPositions) {
        this.chessPositions = chessPositions;
    }

    public String move() throws IllegalMoveException, IllegalPositionException {
        ChessPosition currentPosition = new ChessPosition(chessPositions[0]);

        for(int i = 1; i < chessPositions.length; i++) {
            if(KnightMove.checkPos(currentPosition, chessPositions[i])) {
                currentPosition = chessPositions[i];
            } else {
                throw new IllegalMoveException(currentPosition, chessPositions[i]);
            }
        }
        return "OK";
    }

    private static boolean checkPos (ChessPosition current, ChessPosition next) {
        return (Math.abs(current.getX() - next.getX()) == 1 && Math.abs(current.getY() - next.getY()) == 2)
                || (Math.abs(current.getX() - next.getX()) == 2 && Math.abs(current.getY() - next.getY()) == 1);
    }
}
