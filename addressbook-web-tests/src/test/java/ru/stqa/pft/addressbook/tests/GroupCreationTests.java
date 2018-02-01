package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTests extends TestBase {

  @DataProvider
  public java.util.Iterator <Object[]> validGroups(){
    List<Object[]> list=new ArrayList< Object[]>();
    list.add(new Object[] {new GroupData()
            .withName ("tests1")
            .withHeader("hs1")
            .withFooter("fs1")});

    return list.iterator();

  }

  @Test(dataProvider = "validGroups")
  //создание группы в адресной книге
  public void testGroupCreation( GroupData newGroup) {


    app. goTo().groupPage();
    Groups before = app.group().all();

    app.group().create(newGroup);
    assertThat(app.group().count(), equalTo(before.size()+1 ));
    Groups after = app.group().all();

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
