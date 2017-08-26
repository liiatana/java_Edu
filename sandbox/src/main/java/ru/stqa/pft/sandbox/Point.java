package ru.stqa.pft.sandbox;

public class Point {
  public double x;
  public double y;

  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public static double distance(Point p1, Point p2) {
    double result = Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p2.y - p1.y, 2));
    System.out.println("Расстояние между точками с координатами:(" + p1.x + "," + p2.x + ") и (" + p2.x + "," + p2.y + ") составляет " + result);
    return result;
  }
}