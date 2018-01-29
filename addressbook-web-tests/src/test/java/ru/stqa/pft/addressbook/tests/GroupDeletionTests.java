package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class GroupDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePrecondition(){
    app.getNavigationManager().gotoGroupPage();
    if (!app.getGroupHelper().findAnyGroup()) {
      app.getGroupHelper().createGroup(new GroupData("grMODl1", "test2", "test3"));

    };
  }

  @Test
  public void testGroupDeletion() {

      List<GroupData> before=app.getGroupHelper().getGroupList();

    app.getGroupHelper().selectGroup(before.size()-1);
    app.getGroupHelper().deleteSelectedGroups();
    app.getGroupHelper().returnToGroupPage();
    //int after = app.getGroupHelper().getGroupCount();
    //Assert.assertEquals(after, before - 1);
    List<GroupData> after=app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(),before.size()-1);

    before.remove(before.size()-1);
    Assert.assertEquals(before,after);

  }


}
