package ru.croc.task6.figure;

import ru.croc.task6.figure.api.Figure;
import ru.croc.task6.figure.exeption.IllegalRadiusValue;

public class Circle extends Figure {
    private String name;
    private Point centre;
    private int radius = 1;

    public Circle(String name, Point centre, int radius) throws IllegalRadiusValue{
        this.name = name;
        this.centre = centre;
        setRadius(radius);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Point getCentre() {
        return centre;
    }

    public void setCentre(Point centre) {
        this.centre = centre;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) throws IllegalRadiusValue {
        if(radius < 1) {
            throw new IllegalRadiusValue(radius);
        } else {
            this.radius = radius;
        }
    }

    @Override
    public String toString() {
        return name + " (" + centre.getX() + ", " + centre.getY() + "), " + radius;
    }

    /**
     * Метод, проверяющий принадлежит ли точка окружности
     * вычисляется по формуле (x - x0)^2 + (y - y0)^ <= r^2, где x0,y0 - координаты центра
     * @param x
     * @param y
     * @return true - если принадлежит
     */
    @Override
    public boolean pointBelong(int x, int y) {
        return (x - centre.getX()) * (x - centre.getX())
                + (y - centre.getY()) * (y - centre.getY()) <= (radius * radius);
    }

    @Override
    public void move(int dx, int dy) {
        centre.setX(centre.getX() + dx);
        centre.setY(centre.getY() + dy);
    }
}
