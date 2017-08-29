package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class EquationTests {

  @Test
  public void test0(){//квадратное уравнение без корней
    Equation r= new Equation(1,1,1);
    Assert.assertEquals(r.rooNum(),0);
  }

  @Test
  public void test1(){//квадратное уравнение с одним корнем(два равных корня)
    Equation r= new Equation(1,2,1);
    Assert.assertEquals(r.rooNum(),1);
  }

  @Test
  public void test2(){//квадратное уравнение с двумя разными корнями
    Equation r= new Equation(1,10,1);
    Assert.assertEquals(r.rooNum(),2);
  }
  @Test
  public void test3(){//линейное уравнение корнем с!=0
    Equation r= new Equation(0,10,1);
    Assert.assertEquals(r.rooNum(),1);
  }
  @Test
  public void test4(){//линейное уравнение корнем при с=0
    Equation r= new Equation(0,10,0);
    Assert.assertEquals(r.rooNum(),1);
  }
  @Test
  public void test6(){//уравнение с бесконечным множеством корней
    Equation r= new Equation(0,0,0);
    Assert.assertEquals(r.rooNum(),-1);
  }

  @Test
  public void test5(){//уравнение не имеет смысла при с!=0, например для с=5 уравнение приведется к виду 5=0
    Equation r= new Equation(0,0,1);
    Assert.assertEquals(r.rooNum(),-2);
  }



}
