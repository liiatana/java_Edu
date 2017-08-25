package ru.stqa.pft.sandbox;

public class MyFirstProgram {
  public static void main(String[] args) {
    //String some="tester";
    //System.out.println("Hello,"+some+ "!");
    hello("Tester");
    hello("world");

    Square s=new Square(6.9);
    //s.l = 6.2;
    double s1 = area(s);
    System.out.println("Площадь квадрата со стороной " + s.l + " равна " + s1);

    Rectangle r=new Rectangle(7.3,8.0);
   // r.a = 6.2;
    //r.b = 6.7;
    System.out.println("Площадь прямоугольника со сторонами: " +r.a +" и "+ r.b+ " равна " + area(r));
  }

  public static void hello(String some) {

    System.out.println("Hello," + some + "!");
    //System.out.println("Hello,world!");
  }

  public static double area(Square s) {
    return s.l * s.l;
  }


  public static double area(Rectangle r) {
    return r.a * r.b;
  }


}
