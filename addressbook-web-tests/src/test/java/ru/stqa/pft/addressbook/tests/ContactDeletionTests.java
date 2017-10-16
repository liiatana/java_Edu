package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.NewContactData;

public class ContactDeletionTests extends TestBase {

  @Test
  public void contactDeletionTests() {

    if (!app.getContactHelper().findAnyContact()) {
      app.getNavigationManager().gotoAddNewPage();
      app.getContactHelper().createNewContact(new NewContactData("new1610", "l1", "USA", "7845", "4",
              "sdhfjh@dfjhgkj.tw", "sdhj-gf@sdjkl.ru", "world", "CreateGr"));
      app.getNavigationManager().gotoHome();
    }
    app.getContactHelper().selectContacts();
    app.getContactHelper().deleteSelectedContacts();
    app.getNavigationManager().gotoHomeMenuLevel();

  }


}
