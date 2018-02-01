package ru.stqa.pft.addressbook.tests;


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
    list.add(new Object[] {"test1","h1","f1"});
    list.add(new Object[] {"test2","h2","f2"});
    list.add(new Object[] {"test3","h3","f3"});
    return list.iterator();

  }

  @Test(dataProvider = "validGroups")
  //создание группы в адресной книге
  public void testGroupCreation( String name,String header,String footer) {


    app. goTo().groupPage();
    Groups before = app.group().all();

    GroupData newGroup = new GroupData()
            .withName (name)
            .withHeader(header)
            .withFooter(footer);

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
