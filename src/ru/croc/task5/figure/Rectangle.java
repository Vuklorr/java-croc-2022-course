package src.ru.croc.task5.figure;

import src.ru.croc.task5.figure.api.Figure;

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


}
