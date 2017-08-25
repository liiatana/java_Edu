package ru.stqa.pft.sandbox;

public class MyFirstProgram {
  public static void main(String[] args) {

    Point p1 = new Point(2, 3);
    Point p2 = new Point(6, 8);

     System.out.println("Расстояние между точками с координатами:(" + p1.x + "," + p2.x + ") и (" + p2.x + "," + p2.y + ") составляет " + distance(p1, p2));

    p2.distance(p1, p2);
  }

   public static double distance(Point p1, Point p2) {
     return Math.sqrt(Math.pow((p1.x - p2.x), 2) + Math.pow((p1.y - p2.y), 2));
   }


}