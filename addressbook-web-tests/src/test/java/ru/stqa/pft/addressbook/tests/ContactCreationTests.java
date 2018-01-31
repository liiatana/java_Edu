package ru.stqa.pft.addressbook.tests;
import org.testng.annotations.Test;

import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.NewContactData;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @Test(enabled = true)
  public void contactCreationTests() {


    Contacts before = app.contact().all();

    app.goTo().AddNewPage();

    NewContactData newContact = new NewContactData()
            .withFirstName("Имя")
            .withLastName("Фамилия")
            //.withGroup("newName1")
            //.withId(before.stream().mapToInt((g)->g.getId()).max().getAsInt()+1)
            .withAddress("add1");
    app.contact().createNew(newContact);
    app.goTo().Home();

    Contacts after = app.contact().all();

    assertThat(after.size(), equalTo(before.size() + 1));
   // newContact.setGroup(null);
    //newContact.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt());
    ;
    assertThat(after, equalTo(before.withAdded(newContact.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt()))));
            //эта дрянь не работает- и непонятному почему


    }


}
