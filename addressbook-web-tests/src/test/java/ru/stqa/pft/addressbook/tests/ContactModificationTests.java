package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.NewContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePrecondition() {
   /* if (!app.contact().findAny()) { // старые предусловия при получени списка контактов через GUI
      app.goTo().AddNewPage();

      NewContactData newContact = new NewContactData()
              .withFirstName("yes")
              .withLastName("no");

      app.contact().createNew(newContact);
      app.goTo().Home();
    }*/

   // при работе через БД
    if(app.db().groups().size()==0){
      app.goTo().AddNewPage();
      NewContactData newContact = new NewContactData()
              .withFirstName("yes")
              .withLastName("no");

      app.contact().createNew(newContact);
      app.goTo().Home();

    }

    }


  @Test (enabled=true) // тест изменения контакта через кнопку Edit(Карандаш)
  public void contactModificationTestByEditClick() {

    //Contacts before=app.contact().all();
    Contacts before=app.db().contacts();
    NewContactData modifiedContact=before.iterator().next();

    NewContactData newContactInfo= new NewContactData()
            .withFirstName("newFName")
            .withLastName("newLName")
            .withAddress("newAdd")
            .withAddress2("sfds")
            .withMobile("222")
            .withWorkPhone("333")
            .withHomePhone("444")
            .withEmail2("ddddddddd")
            .withEmail("ddddddddd")
            .withEmail3("ddddddddd")
            //.wi
            .withId(modifiedContact.getId());

    app.contact().initContantactModificationByEditClick(newContactInfo.getId());
    app.contact().modifyByEditClick(newContactInfo);

    app.goTo().Home();

    Contacts after=app.db().contacts();

    assertThat(after.size(), equalTo(before.size() ));

    assertThat(after, equalTo(before.without(modifiedContact).withAdded(newContactInfo)));
    //эта дрянь не работает- и непонятному почему-- все рабботает( забыла метод eqyals in NewContactData
    System.out.println("Jr");

  }
}

