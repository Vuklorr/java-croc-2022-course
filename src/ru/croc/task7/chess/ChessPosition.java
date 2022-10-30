package src.ru.croc.task7.chess;

import src.ru.croc.task7.chess.exeption.IllegalPositionException;

public class ChessPosition {
    private int x;
    private int y;

    public ChessPosition(int x, int y) throws IllegalPositionException {
        setX(x);
        setY(y);
    }

    public ChessPosition(ChessPosition chessPosition) throws IllegalPositionException {
        setX(chessPosition.getX());
        setY(chessPosition.getY());
    }

    public int getX() {
        return x;
    }

    public void setX(int x) throws IllegalPositionException {
        if (x < 0 || x > 8) {
            throw new IllegalPositionException(x, y);
        }
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) throws IllegalPositionException {
        if (y < 0 || y > 7) {
            throw new IllegalPositionException(x, y);
        }
        this.y = y;
    }

    @Override
    public String toString() {
        return String.valueOf(Board.getColumn()[x]) + Board.getRow()[y];
    }

    public static ChessPosition parse(String position) throws IllegalPositionException {
        int column = ChessPosition.findColumn(position.charAt(0));
        int row = Integer.parseInt(String.valueOf(position.charAt(1))) - 1;

        return new ChessPosition(column, row);
    }

    private static int findColumn(char ch) {
        for(int i = 0; i < Board.getColumn().length; i++) {
            if(ch == Board.getColumn()[i]) {
                return i;
            }
        }
        return -1;
    }
}
