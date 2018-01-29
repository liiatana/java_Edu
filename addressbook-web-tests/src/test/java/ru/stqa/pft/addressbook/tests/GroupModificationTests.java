package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class GroupModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePrecondition(){
    app.goTo().groupPage() ;
    if (app.group().list().size()==0) {
      app.group().create(new GroupData().withName("newGrforDel"));

    };
  }

  @Test
  public void groupModificationTests() {


    List<GroupData> before=app.group().list();

    GroupData group=new GroupData()
            .withId (before.get( before.size()-1).getId()).withName("newName18888");
    int index=before.size();

    app.group().modify(before, group);
    //int after= app.getGroupHelper().getGroupCount();
    //Assert.assertEquals(after,before);
    List<GroupData> after=app.group().list();
    Assert.assertEquals(after.size(),before.size());

    before.remove(before.size() - 1);
    before.add(group);
    Assert.assertEquals(new HashSet<Object>(after),new HashSet<Object>(before));//HashSet  создает неупорядоченное множество. преобразут наши оба списка в множества
  }




}
