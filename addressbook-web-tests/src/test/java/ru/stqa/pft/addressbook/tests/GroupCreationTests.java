package ru.stqa.pft.addressbook.tests;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
import org.slf4j.Logger; //это класс из которого нам нужен логгер
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;


import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTests extends TestBase {

 // Logger logger= LoggerFactory.getLogger(GroupCreationTests.class);

  @DataProvider
  public java.util.Iterator <Object[]> validGroupsFromXML() throws IOException {
    // это чтение из csv файла
    /*List<Object[]> list=new ArrayList< Object[]>();
    BufferedReader reader=new BufferedReader(  new FileReader(new File("src\test\resources\test.csv")));
    String line=reader.readLine();
    while(line!=null){
      String[] split = line.split(";");
      list.add(new Object[] {new GroupData()
              .withName (split[0])
              .withHeader(split[1])
              .withFooter(split[2])});
      line=reader.readLine();


    }
  return list.iterator();*/

    //это чтение из xml файла
    List<Object[]> list=new ArrayList< Object[]>();
    try(BufferedReader reader=new BufferedReader(  new FileReader(new File("src\\test\\resources\\test.xml")))) {
      String line = reader.readLine();
      String xml = "";
      while (line != null) {
        xml += line;
        line = reader.readLine();
      }
      XStream xstream = new XStream();
      xstream.processAnnotations(GroupData.class);
      List<GroupData> groups = (List<GroupData>) xstream.fromXML(xml);
      return groups.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
    }

  }

  @DataProvider
  public java.util.Iterator <Object[]> validGroupsFromJSON() throws IOException {

    List<Object[]> list=new ArrayList< Object[]>();
    try(BufferedReader reader=new BufferedReader(  new FileReader(new File("src\\test\\resources\\test.json")))) {
      String line = reader.readLine();
      String json = "";
      while (line != null) {
        json += line;
        line = reader.readLine();
      }
      Gson gson = new Gson();
      //gson.fromJson(json, GroupData.class);//писать в кач-ве второго параметра GroupData.class можно,
      // но это будет только один объект, а нам нужен список таких объектов. А написать List нельзя((( не работаеть..
      // поэтому не шибюко понятное действие должно выглядеть так:
      List<GroupData> groups = gson.fromJson(json, new TypeToken<List<GroupData>>() {
      }.getType()); //это аналогично List<GroupData>.class

      return groups.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();// вот это заворот каждого объекта в массив из одного элемента, так надо для TestNG
    }
  }

  @Test(dataProvider = "validGroupsFromJSON")
  //создание группы в адресной книге
  public void testGroupCreation( GroupData newGroup) {


    app. goTo().groupPage();
    Groups before = app.group().all();

    app.group().create(newGroup);
    assertThat(app.group().count(), equalTo(before.size()+1 ));
    Groups after = app.group().all();

    assertThat(after.size(), equalTo(before.size() + 1));
    newGroup.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt());

    //before.add(newGroup);
    //Assert.assertEquals(new HashSet<Object>(after), new HashSet<Object>(before));//HashSet  создает неупорядоченное множество. преобразут наши оба списка в множества
    assertThat(after, equalTo(before.withAdded(newGroup)));


  }






  @Test
  //проверка, что нельзщя создать группу с "плохим имененем"( с апострофом в данном случае)
  public void testBadGroupCreation() {


    app. goTo().groupPage();
    Groups before = app.group().all();
    GroupData newGroup = new GroupData()
            .withName ("апос'троф");

    app.group().create(newGroup);

    assertThat(app.group().count(), equalTo(before.size() ));
    Groups after = app.group().all();
    assertThat(after, equalTo(before));
  }


}
