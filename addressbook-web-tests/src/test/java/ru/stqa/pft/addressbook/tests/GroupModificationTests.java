package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.NewContactData;

import java.util.List;

public class GroupModificationTests extends TestBase {

  @Test
  public void groupModificationTests() {
    app.getNavigationManager().gotoGroupPage();
    //int before= app.getGroupHelper().getGroupCount();


    if (!app.getGroupHelper().findAnyGroup()) {
      app.getGroupHelper().createGroup(new GroupData("grMODl1", "test2", "test3"));

    };
    List<GroupData> before=app.getGroupHelper().getGroupList();
    app.getGroupHelper().selectGroup(before.size() - 1);
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillGroupForm(new GroupData("test11", "newHeader1", "newFooter1"));
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();
    //int after= app.getGroupHelper().getGroupCount();
    //Assert.assertEquals(after,before);
    List<GroupData> after=app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(),before.size());
  }


}
