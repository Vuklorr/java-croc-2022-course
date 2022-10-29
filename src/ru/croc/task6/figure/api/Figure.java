package src.ru.croc.task6.figure.api;

import src.ru.croc.task6.figure.Point;

public abstract class Figure implements Movable {
    public abstract String dataToString();
    public  abstract Point getPoint();
}
