package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class GroupCreationTests extends TestBase {

  @Test
  //создание группы в адресной книге
  public void testGroupCreation() {

    GroupData newGroup = new GroupData("CreateGr", "test2", null);
    int maxId = 0;

    app.getNavigationManager().gotoGroupPage();
    //int before= app.getGroupHelper().getGroupCount();
    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().createGroup(newGroup);
    /*app.getGroupHelper().initGroupCreation();
    app.getGroupHelper().fillGroupForm(new GroupData("test444121", "test2", null));
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupPage();*/

    // int after= app.getGroupHelper().getGroupCount();

    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() + 1);

    for (GroupData id : after) {
      if (id.getId() > maxId) {
        maxId = id.getId();
      }
      ;
    }
    ;

    newGroup.setId(maxId);
    before.add(newGroup);
    Assert.assertEquals(new HashSet<Object>(after), new HashSet<Object>(before));//HashSet  создает неупорядоченное множество. преобразут наши оба списка в множества


  }


}
