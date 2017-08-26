package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTest {

  @Test
  public void testPoint1(){
    Point p1=new Point(1.0,3);
    Point p2=new Point(5,0);
    Assert.assertEquals(p1.distance(p1,p2),5.0);
  }
}
