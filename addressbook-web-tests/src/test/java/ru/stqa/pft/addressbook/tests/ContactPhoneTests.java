package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.NewContactData;

public class ContactPhoneTests extends TestBase{

  @BeforeMethod
  public void ensurePrecondition() {
    if (!app.contact().findAny()) {
      app.goTo().AddNewPage();

      NewContactData newContact = new NewContactData()
              .withFirstName("NNN")
              .withLastName("LLL")
              .withMobile("777")
              .withHomePhone("888")
              .withWorkPhone("999");

      app.contact().createNew(newContact);
      app.goTo().Home();
    }}

  @Test
  public void testContactsPhone(){

    app.goTo().Home();
    Contacts before = app.contact().all();
    NewContactData contact=before.iterator().next();
    NewContactData contactDataFromEditForm=app.contact().infoFromEditForm(contact.getId());



  }
}
