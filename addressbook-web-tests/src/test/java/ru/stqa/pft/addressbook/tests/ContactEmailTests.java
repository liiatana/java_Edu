package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.NewContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactEmailTests extends TestBase{
  @BeforeMethod
  public void ensurePrecondition() {
    if (!app.contact().findAny()) {
      app.goTo().AddNewPage();

      NewContactData newContact = new NewContactData()
              .withFirstName("NNN")
              .withLastName("LLL")
              .withMobile("777")
              .withHomePhone("888")
              .withWorkPhone("999")
              .withEmail("e1@11.ru")
              .withEmail2("e22@21.ru")
              .withEmail3("e3@13331.ru");

      app.contact().createNew(newContact);
      app.goTo().Home();
    }}

  @Test
  public void testContactEmails(){

    app.goTo().Home();
    Contacts before = app.contact().all();
    NewContactData contact=before.iterator().next();
    NewContactData contactDataFromEditForm=app.contact().infoFromEditForm(contact.getId());
    assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactDataFromEditForm)));

  }

  private String mergeEmails(NewContactData contactDataFromEditForm) {
    return Arrays.asList(contactDataFromEditForm.getEmail(),contactDataFromEditForm.getEmail2(),contactDataFromEditForm.getEmail3())
            .stream()
            .filter((s)->!equals(""))
            .collect(Collectors.joining("\n"))  ;

  }



}
