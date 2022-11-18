package ru.croc.task2;

public class Task2 {
    public static void main(String[] args) {
        double b = Double.parseDouble(args[0]);
        String[] units = new String[] {"B", "KB","MB", "GB", "TB", "PB"}; //единицы измерения

        int i = 0;
        while (b >= 1024.0) {
            b /= 1024.0;
            i++;
            if(i == units.length - 1) {
                break;
            }
        }
        System.out.printf("%.1f %s\n", b, units[i]);
    }
}
