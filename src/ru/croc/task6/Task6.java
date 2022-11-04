package src.ru.croc.task6;


import src.ru.croc.task6.annotation.AnnotatedImage;
import src.ru.croc.task6.annotation.Annotation;
import src.ru.croc.task6.figure.Circle;
import src.ru.croc.task6.figure.Point;
import src.ru.croc.task6.figure.Rectangle;
import src.ru.croc.task6.figure.api.Figure;
import src.ru.croc.task6.figure.exeption.IllegalRadiusValue;

public class Task6 {
    public static void main(String[] args) throws IllegalRadiusValue {
        Figure circle = new Circle("C", new Point(100, 100), 10);
        Figure circleMov = new Circle("C", new Point(2, 4), 2);
        Figure rectangle = new Rectangle("R", new Point(100,100), new Point(150, 200));
        Figure rectangleMov = new Rectangle("R", new Point(0,0), new Point(2, 2));

        Annotation tree = new Annotation(circle, "Tree");
        Annotation moveCircle = new Annotation(circleMov, "Move Circle");
        Annotation car = new Annotation(rectangle, "Car");
        Annotation moveRectangle = new Annotation(rectangleMov, "Move Rectangle");

        AnnotatedImage annotatedImage = new AnnotatedImage("path", tree, moveCircle, car, moveRectangle);

        System.out.println(tree.toString());
        System.out.println(moveCircle.toString());
        System.out.println(car.toString());
        System.out.println(moveRectangle.toString());
        System.out.println();


        System.out.println(annotatedImage.findByLabel("Car").toString());
        System.out.println(annotatedImage.findByPoint(3,3).toString());
        System.out.println(annotatedImage.findByPoint(125,150).toString());
        System.out.println();

        circleMov.move(1,-2);
        rectangleMov.move(1, -2);

        System.out.println(moveCircle.toString());
        System.out.println(moveRectangle.toString());


    }
}
