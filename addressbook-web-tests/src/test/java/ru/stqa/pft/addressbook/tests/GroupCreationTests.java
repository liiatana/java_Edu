package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.NewContactData;

public class GroupCreationTests extends TestBase {

  @Test
  //создание группы в адресной книге
  public void testGroupCreation() {


    app.getNavigationManager().gotoGroupPage();
    int before= app.getGroupHelper().getGroupCount();
    app.getGroupHelper().createGroup(new GroupData("CreateGr", "test2", null));
    /*app.getGroupHelper().initGroupCreation();
    app.getGroupHelper().fillGroupForm(new GroupData("test444121", "test2", null));
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupPage();*/

    int after= app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after,before+1);
  }


}
