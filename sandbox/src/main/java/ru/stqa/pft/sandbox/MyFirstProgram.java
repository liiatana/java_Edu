package ru.stqa.pft.sandbox;

public class MyFirstProgram {
  public static void main(String[] args) {
    //String some="tester";
    //System.out.println("Hello,"+some+ "!");
    hello("Tester");
    hello("world");

    Square s=new Square(6.9);
    double s1 = s.area();
    System.out.println("Площадь квадрата со стороной " + s.l + " равна " + s1);

    Rectangle r=new Rectangle(7.3,8.0);
       System.out.println("Площадь прямоугольника со сторонами: " +r.a +" и "+ r.b+ " равна " + r.area());
  }

  public static void hello(String some) {

    System.out.println("Hello," + some + "!");
    //System.out.println("Hello,world!");
  }

  public static double distance(Point p1, Point p2){
    return Math.sqrt(Math.pow((p1.x-p2.x), 2)-Math.pow((p1.y-p2.y), 2));
  }

}
