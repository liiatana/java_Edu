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
           // .withId( before.stream().mapToInt((g)->g.getId()).max().getAsInt()+1);

    app.group().create(newGroup);
    Groups after = app.group().all();

   // Assert.assertEquals(after.size(), before.size() + 1);
    assertThat(after.size(), equalTo(before.size() + 1));
    newGroup.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt());

    //before.add(newGroup);
    //Assert.assertEquals(new HashSet<Object>(after), new HashSet<Object>(before));//HashSet  создает неупорядоченное множество. преобразут наши оба списка в множества
    assertThat(after, equalTo(before.withAdded(newGroup)));

  }


}
