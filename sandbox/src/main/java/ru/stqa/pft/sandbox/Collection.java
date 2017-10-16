package ru.stqa.pft.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collection {

  public static void main(String[] args){

    /*String[] langs= new String[4];
    langs[0]="java";
    langs[1]="c#";
    langs[0]="pyton";
    langs[0]="php";*/

    String[] langs= {"java","c#","python","php"};// аналогично закомментированному выше

    /*for(int i=0;i<langs.length;i++){
      System.out.println("язык "+ langs[i]);
    }*/

    for(String l:langs){ // аналогично циклу выше
      System.out.println("язык "+ l);
    }

    List<String> lans= new ArrayList<String>();//инициализация массива через классы java
    // добавление элементов в коллекцию
    lans.add("java");
    lans.add("c#");
    lans.add("python");
    lans.add("php");
    for(String l:lans){ // аналогично циклу выше
      System.out.println("язык(из list) "+ l);
    }

    List<String> lans1= Arrays.asList("java","c#","python","php");// инициализация элементов коллекции (аналог определения списокм), вместо строк 28-31(добаление в коллекцию)
    for(int i=0;i<lans1.size();i++){
      System.out.println("язык (asList)"+ lans1.get(i));
    }


  }

}
