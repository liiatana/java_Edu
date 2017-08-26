package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTest {

  //проверка метода вычисления расстояния из класса Point
  @Test
  public void testPoint1() {
    Point p1 = new Point(1.0, 3);
    Point p2 = new Point(5, 0);

    Assert.assertEquals(p1.distance(p2.x, p2.y), 5.0);

  }
//сравнение работы функции вычисления расстояния  и метода класса Point
  @Test
  public void testPointClassVsFunc() {
    Point objAry[] = new Point[3];
    objAry[0] = new Point(1, 3);
    objAry[1] = new Point(-1, -5);
    objAry[2] = new Point(0, 3.8);

    for (int j = 0; j < 3; j++)
      for (int i = 1; i < 3; i++)
        if (i != j && j < i)
          Assert.assertEquals(objAry[j].distance(objAry[i].x, objAry[i].y), MyFirstProgram.distance(objAry[j], objAry[i]));
  }
}
