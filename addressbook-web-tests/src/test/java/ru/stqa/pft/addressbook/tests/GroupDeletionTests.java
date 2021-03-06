package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;


import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePrecondition(){
    app.goTo().groupPage();
    if (app.db().groups().size()==0) {
           app.group().create(new GroupData().withName("newName1Del").withHeader("newHeaderDel").withFooter("newFooterDel"));
    };
  }

  @Test
  public void testGroupDeletion() {


    Groups before=app.db().groups();
    GroupData deletedGroup=before.iterator().next();

    app.group().delete(deletedGroup);
    assertThat(app.group().count(), equalTo(before.size()-1 ));
    Groups after=app.db().groups();
    assertThat(after.size(), equalTo(before.size() - 1));
    assertThat(after, equalTo(before.without(deletedGroup)));

  }




}
