package ru.stqa.pft.sandbox;

import org.testng.annotations.Test;

public class PointTests {

    @Test
    public void testDistance (){    /*название тестового метода*/
     Point p1= new Point (5, 10)   ; /*создаем новую точку*/
     Point p2= new Point (5, 10)   ;

     assert p2.distance(p1) == 0;
    }
}
