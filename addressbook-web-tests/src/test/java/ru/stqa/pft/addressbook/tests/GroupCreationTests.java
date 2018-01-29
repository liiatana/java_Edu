package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;


import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class GroupCreationTests extends TestBase {

  @Test
  //создание группы в адресной книге
  public void testGroupCreation() {




    app.goTo().groupPage();


    List<GroupData> before = app.group().list();
    Comparator<? super GroupData> byId=(g1,g2)->Integer.compare(g1.getId(),g2.getId());
    before.sort(byId);

    GroupData newGroup = new GroupData().withName ("CreateGr").withId(before.get( before.size()-1).getId()+1);

    app.group().create(newGroup);
       List<GroupData> after = app.group().list();
    //
    Assert.assertEquals(after.size(), before.size() + 1);

    /*
    int maxId = 0;
    for (GroupData id : after) {//1ый способ поиска максимального элемента
      if (id.getId() > maxId) {
        maxId = id.getId();
      }
      ;
    }
    ;*/

    /*Comparator<? super GroupData> byId= (Comparator<GroupData>) (o1, o2) -> Integer.compare(o1.getId(),o2.getId());//2-3ый способ поиска максимального элемента(только с java8)
    maxId = after.stream().max(byId).get().getId();*/

   // newGroup.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(),o2.getId())).get().getId());
   // newGroup.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(),o2.getId())).get().getId());

    before.add(newGroup);
    Assert.assertEquals(new HashSet<Object>(after), new HashSet<Object>(before));//HashSet  создает неупорядоченное множество. преобразут наши оба списка в множества


  }


}
