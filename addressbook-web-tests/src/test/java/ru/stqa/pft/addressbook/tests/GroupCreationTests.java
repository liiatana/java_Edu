package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;



import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTests extends TestBase {

  @Test
  //создание группы в адресной книге
  public void testGroupCreation() {


    app. goTo().groupPage();
    Groups before = app.group().all();

    GroupData newGroup = new GroupData()
            .withName ("CreateGr");

    app.group().create(newGroup);
    assertThat(app.group().count(), equalTo(before.size()+1 ));
    Groups after = app.group().all();

   // Assert.assertEquals(after.size(), before.size() + 1);
    assertThat(after.size(), equalTo(before.size() + 1));
    newGroup.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt());

    //before.add(newGroup);
    //Assert.assertEquals(new HashSet<Object>(after), new HashSet<Object>(before));//HashSet  создает неупорядоченное множество. преобразут наши оба списка в множества
    assertThat(after, equalTo(before.withAdded(newGroup)));

  }


  @Test
  //проверка, что нельзщя создать группу с "плохим имененем"( с апострофом в данном случае)
  public void testBadGroupCreation() {


    app. goTo().groupPage();
    Groups before = app.group().all();
    GroupData newGroup = new GroupData()
            .withName ("апос'троф");

    app.group().create(newGroup);

    assertThat(app.group().count(), equalTo(before.size() ));
    Groups after = app.group().all();
    assertThat(after, equalTo(before));
  }


}
