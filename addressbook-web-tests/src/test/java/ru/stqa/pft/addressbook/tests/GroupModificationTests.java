package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.NewContactData;

public class GroupModificationTests extends TestBase {

  @Test
  public void groupModificationTests() {
    app.getNavigationManager().gotoGroupPage();
    int before= app.getGroupHelper().getGroupCount();
    app.getGroupHelper().selectGroup(before - 1);
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillGroupForm(new GroupData("test11", "newHeader1", "newFooter1"));
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();
    int after= app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after,before);
  }


}
