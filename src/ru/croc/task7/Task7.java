package ru.croc.task7;

import ru.croc.task7.chess.ChessPosition;
import ru.croc.task7.chess.KnightMove;
import ru.croc.task7.chess.exeption.IllegalMoveException;
import ru.croc.task7.chess.exeption.IllegalPositionException;

public class Task7 {
    public static void main (String[] args) throws IllegalPositionException, IllegalMoveException {
        ChessPosition[] arrPosition = new ChessPosition[args.length];

        for(int i = 0; i < args.length; i++) {
            arrPosition[i] = ChessPosition.parse(args[i]);
        }

        KnightMove knight = new KnightMove(arrPosition);
        System.out.println(knight.move());
    }
}
