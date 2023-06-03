package ru.stqa.pft.sandbox;

public class MyFirstProgram {

    public static void main(String[] args) {
        System.out.println("Hello, world!");
        double x2 = 5;
        double x1 = 2;
        double y2 = 6;
        double y1 = 1;
        System.out.println("Расстояние между Х и Y=" + distance(x2, x1, y2, y1));
    }

    public static double distance(double x1, double x2, double y1, double y2) {

        return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }
}

