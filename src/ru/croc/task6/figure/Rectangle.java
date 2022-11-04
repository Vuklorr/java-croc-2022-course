package src.ru.croc.task6.figure;

import src.ru.croc.task6.figure.api.Figure;

public class Rectangle extends Figure {
    private String name;
    private Point left;
    private Point right;

    public Rectangle(String name, Point left, Point right) {
        this.name = name;
        this.left = left;
        this.right = right;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Point getLeft() {
        return left;
    }

    public void setLeft(Point left) {
        this.left = left;
    }

    public Point getRight() {
        return right;
    }

    public void setRight(Point right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return name + " (" + left.getX() + ", " + left.getY() + "), (" + right.getX() + ", " + right.getY() + ")";
    }

    /**
     * Метод, проверяющий принадлежит ли точка окружности
     * вычисляется по формуле x1 <= x <= x2 && y1 <= y <= y2, где x1,y1 - координаты левого угла, x2,y2 - правого
     * @param x
     * @param y
     * @return true - если принадлежит
     */
    @Override
    public boolean pointBelong(int x, int y) {
        return (left.getX() <= x && x <= right.getX()) && (left.getY() <= y && y <= right.getY());
    }


    @Override
    public void move(int dx, int dy) {
        left.setX(left.getX() + dx);
        left.setY(left.getY() + dy);
        right.setX(right.getX() + dx);
        right.setY(right.getY() + dy);
    }
}
