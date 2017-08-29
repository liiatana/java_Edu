package ru.stqa.pft.sandbox;

public class Equation {

  private final double a;
  private final double b;
  private final double c;

  private int n;

  public Equation(double a, double b, double c) {


    this.a = a;
    this.b = b;
    this.c = c;

    double d = b * b - 4 * a * c;
/*
    if (d > 0) {
      n = 2;
    } else {
      if (d < 0) {
        n = 0;
      } else n = 1;
    }
*/

  if(a!=0){
    if (d > 0) n = 2;
     else if (d < 0)
        n = 0;
      else n = 1;
    }
    else if (b!=0) n=1;
    else if (c!=0) n=-2;
    else n=-1;
  }


  public int rooNum() {
    return n;
  }
}
