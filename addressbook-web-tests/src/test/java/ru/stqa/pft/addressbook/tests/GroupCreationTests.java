package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;


import java.util.Comparator;
import java.util.HashSet;

import java.util.Set;

public class GroupCreationTests extends TestBase {

  @Test
  //создание группы в адресной книге
  public void testGroupCreation() {


    app. goTo().groupPage();

    Set<GroupData> before = app.group().all();

    GroupData newGroup = new GroupData().withName ("CreateGr").withId( before.stream().mapToInt((g)->g.getId()).max().getAsInt()+1);

    app.group().create(newGroup);
    Set<GroupData> after = app.group().all();

    Assert.assertEquals(after.size(), before.size() + 1);

    before.add(newGroup);
    Assert.assertEquals(new HashSet<Object>(after), new HashSet<Object>(before));//HashSet  создает неупорядоченное множество. преобразут наши оба списка в множества


  }


}
