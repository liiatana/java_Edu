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
    app.goTo().groupPage() ;
    if (app.group().all().size()==0) {
      app.group().create(new GroupData().withName("newGrforMody"));

    };
  }

  @Test
  public void groupModificationTests() {


    Groups before=app.group().all();

    GroupData updatedGroup=before.iterator().next();

    GroupData group=new GroupData()
            .withId (updatedGroup.getId()).withName("newName1");

    app.group().modify( group);


    Groups after=app.group().all();
    /*Assert.assertEquals(after.size(),before.size());

    before.remove(updatedGroup);
    before.add(group);
    Assert.assertEquals(new HashSet<Object>(after),new HashSet<Object>(before));//HashSet  создает неупорядоченное множество. преобразут наши оба списка в множества
  */
    assertThat(after.size(), equalTo(before.size()));
    assertThat(after,equalTo(before.without(updatedGroup).withAdded(group)));

  }




}
