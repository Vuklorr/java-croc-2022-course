package src.ru.croc.task5.figure;

import src.ru.croc.task5.figure.api.Figure;
import src.ru.croc.task5.figure.exeption.IllegalRadiusValue;

public class Circle extends Figure {
    private String name;
    private Point centre;
    private int radius = 1;

    public Circle(String name, Point centre, int radius) throws IllegalRadiusValue {
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

}
