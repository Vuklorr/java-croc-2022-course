package ru.croc.task1;

import java.util.Scanner;

public class Task1 {
    static class Point {
        double x;
        double y;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Point a = new Point();
        Point b = new Point();
        Point c = new Point();

        System.out.print("Введите координату х вершины №1: ");
        a.x = in.nextInt();
        System.out.print("Введите координату y вершины №1: ");
        a.y = in.nextInt();

        System.out.print("Введите координату х вершины №2: ");
        b.x = in.nextInt();
        System.out.print("Введите координату y вершины №2: ");
        b.y = in.nextInt();

        System.out.print("Введите координату х вершины №3: ");
        c.x = in.nextInt();
        System.out.print("Введите координату y вершины №3: ");
        c.y = in.nextInt();

        double lenAB = Math.sqrt((b.x - a.x) * (b.x - a.x) + (b.y - a.y) * (b.y - a.y)); //длина вектора AB
        double lenAC = Math.sqrt((c.x - a.x) * (c.x - a.x) + (c.y - a.y) * (c.y - a.y)); //длина вектора AС
        double lenCB = Math.sqrt((b.x - c.x) * (b.x - c.x) + (b.y - c.y) * (b.y - c.y)); //длина вектора CB
        double p = (lenAB + lenAC + lenCB) / 2; //нахождение полупериметра
        double s = Math.sqrt(p * (p - lenAB) * (p - lenAC) * (p - lenCB)); //нахождение площади по формуле Герона

        System.out.printf("Площадь треугольника: %.1f\n",s);
        
    }
}
