package ru.stqa.pft.sandbox;

public class Point {
  public double x;
  public double y;

  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public double distance(double aX, Double aY) {
    double result = Math.sqrt(Math.pow(this.x - aX, 2) + Math.pow(this.y - aY, 2));
    System.out.println("Расстояние между точками с координатами:(" + this.x + "," + this.y + ") и (" + aX + "," + aY + ") составляет " + result);
    return result;
  }
}