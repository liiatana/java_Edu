package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.HashSet;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePrecondition(){

    if (app.db().groups().size()==0){
      app.goTo().groupPage() ;
      app.group().create(new GroupData().withName("newGrforMody"));

    };
  }

  @Test(enabled=true)
  public void groupModificationTests() {

    Groups before=app.db().groups();
    GroupData updatedGroup=before.iterator().next();
    GroupData group=new GroupData()
            .withId (updatedGroup.getId()).withName("newName1");

    app.goTo().groupPage() ;
    app.group().modify( group);
    assertThat(app.group().count(), equalTo(before.size() ));

    Groups after=app.db().groups();

    //assertThat(after.size(), equalTo(before.size()));
    assertThat(after,equalTo(before.without(updatedGroup).withAdded(group)));

  }

}
