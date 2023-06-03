package ru.stqa.pft.sandbox;

public class MyFirstProgram {

    public static void main(String[] args) {
        System.out.println("Hello, world!");
        Point p1= new Point(2,1);
        Point p2= new Point(5,6);

        System.out.println("Расстояние между точками=" + distance(p2, p1 ));
    }

    public static double distance(Point p1,Point p2 ) {

        return Math.sqrt((p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y) * (p2.y - p1.y));
    }
}

