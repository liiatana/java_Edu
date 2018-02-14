package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.NewContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePrecondition() {
    skipIfNotFixed(799);// пропустить тест , если не починен баг
    if (app.db().contacts().size()==0) {
      app.goTo().AddNewPage();

      NewContactData newContact = new NewContactData()
              .withFirstName("helppFirstName")
              .withLastName("helplastname");

      app.contact().createNew(newContact);
      app.goTo().Home();
  }
  }

  @Test(enabled = true)
  public void contactDeletionTests() {


    Contacts before=app.db().contacts();

    NewContactData deletedContact=before.iterator().next();
    app.contact().delete(deletedContact);
    app.goTo() .HomeMenuLevel();

    Contacts after=app.db().contacts();

    assertThat(after.size(), equalTo(before.size() - 1));
    assertThat(after, equalTo(before.without(deletedContact)));


  }

}
