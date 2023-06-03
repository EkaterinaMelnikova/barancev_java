package ru.stqa.pft.sandbox;

public class MyFirstProgram {

    public static void main(String[] args) {
        System.out.println("Hello, world!");
        Point p1= new Point(2, 1);
        Point p2= new Point(5,6);



        double distance = p2.distance(p1);

        System.out.println("Расстояние между точками=" + distance);
    }


}

