package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.HashSet;

import java.util.Set;

public class GroupModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePrecondition(){
    app.goTo().groupPage() ;
    if (app.group().all().size()==0) {
      app.group().create(new GroupData().withName("newGrforDel"));

    };
  }

  @Test
  public void groupModificationTests() {


    Set<GroupData> before=app.group().all();

    GroupData updatedGroup=before.iterator().next();

    GroupData group=new GroupData()
            .withId (updatedGroup.getId()).withName("newName1");

    app.group().modify( group);


    Set<GroupData> after=app.group().all();
    Assert.assertEquals(after.size(),before.size());

    before.remove(updatedGroup);
    before.add(group);
    Assert.assertEquals(new HashSet<Object>(after),new HashSet<Object>(before));//HashSet  создает неупорядоченное множество. преобразут наши оба списка в множества
  }




}
