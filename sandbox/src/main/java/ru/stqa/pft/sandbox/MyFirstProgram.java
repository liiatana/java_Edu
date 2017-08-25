package ru.stqa.pft.sandbox;

public class MyFirstProgram {
  public static void main(String[] args) {
    //String some="tester";
    //System.out.println("Hello,"+some+ "!");
    hello("Tester");
    hello("world");
    double l = 6.2;
    double s = area(l);
    System.out.println("Площадь квадрата со стороной " + l + " равна " + s);

    double a = 6.2;
    double b = 6.4;
    System.out.println("Площадь прямоугольника со сторонами: " +a +" и "+ b+ " равна " + area(a,b));
  }

  public static void hello(String some) {

    System.out.println("Hello," + some + "!");
    //System.out.println("Hello,world!");
  }

  public static double area(double l) {
    return l * l;
  }


  public static double area(double a, double b) {
    return a * b;
  }


}
