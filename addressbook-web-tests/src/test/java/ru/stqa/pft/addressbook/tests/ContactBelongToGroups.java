package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;
import ru.stqa.pft.addressbook.model.NewContactData;
import static org.hamcrest.CoreMatchers.equalTo;

import java.util.Date;

public class ContactBelongToGroups extends TestBase {

  @BeforeMethod
  public void ensurePrecondition() {
    if (app.db().contacts().size() == 0) {
      app.goTo().AddNewPage();

      NewContactData newContact = new NewContactData()
              .withFirstName("helppFirstName")
              .withLastName("helplastname");

      app.contact().createNew(newContact);
      app.goTo().Home();
    }
  }

  @Test(enabled = true)
  public void addContactToGroupsTests() {


    Groups allGroups = app.db().groups();
    Contacts allContacts = app.db().contacts();

    NewContactData contact=allContacts .iterator().next();

    if (contact.getGroups().size()==app.db().groups().size()){
      app. goTo().groupPage();
      app.group().create(new GroupData().withName("grForTestaaaa"));
      allGroups = app.db().groups();

    }

      allGroups.removeAll(contact.getGroups());
      GroupData addedGroup=allGroups.iterator().next();
      app.goTo().HomeMenuLevel();

      app.contact().addToGroup(contact, addedGroup);

      NewContactData newContactInfo=app.db().contactById(contact.getId());

    MatcherAssert.assertThat(newContactInfo.getGroups().size(), CoreMatchers.equalTo(contact.getGroups().size()+1));
    MatcherAssert.assertThat(newContactInfo.getGroups(), CoreMatchers.equalTo(contact.getGroups().withAdded(addedGroup)));


  }
}