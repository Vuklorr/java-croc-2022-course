package src.ru.croc.task5.figure;

import src.ru.croc.task5.figure.api.Figure;

public class Circle implements Figure {
    private String name;
    private Point centre;
    private int radius = 1;

    public Circle(String name, Point centre, int radius) {
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

    public void setRadius(int radius) {
        if(radius < 1) {
            System.out.println("Радиус меньше 1!");
        } else {
            this.radius = radius;
        }
    }

    @Override
    public String dataToString() {
        return name + " (" + centre.getX() + ", " + centre.getY() + "), " + radius;
    }

}
