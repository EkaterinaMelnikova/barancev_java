package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

    @Test
    public void testDistance1 (){
     Point p1= new Point (5, 10)   ;
     Point p2= new Point (5, 10)   ;

        Assert.assertEquals( p2.distance(p1) ,0.0);
    }
    @Test
    public void testDistance2 (){
        Point p1= new Point (5, 10)   ;
        Point p2= new Point (5, 10)   ;

        Assert.assertEquals( p2.distance(p1) ,0.1);
    }
    @Test
    public void testDistance3 (){
        Point p1= new Point (0.5, 5.5)   ;
        Point p2= new Point (5, 10)   ;

        Assert.assertEquals( p2.distance(p1) ,6.363961030678928);
    }
    @Test
    public void testDistance4 (){
        Point p1= new Point (0.5, 5.5)   ;
        Point p2= new Point (5, 10)   ;

        Assert.assertEquals( p2.distance(p1) ,0.1);
    }
    @Test
    public void testDistance5 (){
        Point p1= new Point (5, 10)   ;
        Point p2= new Point (-5, -10)   ;

        Assert.assertEquals( p2.distance(p1) ,22.360679774997898);
    }
}
