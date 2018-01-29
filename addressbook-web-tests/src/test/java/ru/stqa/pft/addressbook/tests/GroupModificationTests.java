package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.NewContactData;

import java.util.HashSet;
import java.util.List;

public class GroupModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePrecondition(){
    app.getNavigationManager().gotoGroupPage();
    if (!app.getGroupHelper().findAnyGroup()) {
      app.getGroupHelper().createGroup(new GroupData("grMODl1", "test2", "test3"));

    };
  }

  @Test
  public void groupModificationTests() {


    List<GroupData> before=app.getGroupHelper().getGroupList();

    GroupData group=new GroupData(before.get( before.size()-1).getId(), "test11", "newHeader1", "newFooter1");
    int index=before.size();

    app.getGroupHelper().modifyGroup(before, group);
    //int after= app.getGroupHelper().getGroupCount();
    //Assert.assertEquals(after,before);
    List<GroupData> after=app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(),before.size());

    before.remove(before.size() - 1);
    before.add(group);
    Assert.assertEquals(new HashSet<Object>(after),new HashSet<Object>(before));//HashSet  создает неупорядоченное множество. преобразут наши оба списка в множества
  }




}
