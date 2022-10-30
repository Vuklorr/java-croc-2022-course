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
    public String dataToString() {
        return name + " (" + left.getX() + ", " + left.getY() + "), (" + right.getX() + ", " + right.getY() + ")";
    }

    @Override
    public Point getPoint() {
        return left;
    }


    @Override
    public void move(int dx, int dy) {
        left.setX(left.getX() + dx);
        left.setY(left.getY() + dy);
        right.setX(right.getX() + dx);
        right.setY(right.getY() + dy);
    }
}
