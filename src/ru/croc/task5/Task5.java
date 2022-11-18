package ru.croc.task5;

import ru.croc.task5.annotation.AnnotatedImage;
import ru.croc.task5.annotation.Annotation;
import ru.croc.task5.figure.Circle;
import ru.croc.task5.figure.Point;
import ru.croc.task5.figure.Rectangle;
import ru.croc.task5.figure.api.Figure;
import ru.croc.task5.figure.exeption.IllegalRadiusValue;

public class Task5 {
    public static void main(String[] args) throws IllegalRadiusValue {
        Figure circle = new Circle("C", new Point(100, 100), 10);
        Figure rectangle = new Rectangle("R", new Point(100,100), new Point(150, 200));
        Annotation tree = new Annotation(circle, "Tree");
        Annotation car = new Annotation(rectangle, "Car");
        AnnotatedImage annotatedImage = new AnnotatedImage("path", tree, car);

        System.out.println(tree.toString());
        System.out.println(car.toString());
    }
}
