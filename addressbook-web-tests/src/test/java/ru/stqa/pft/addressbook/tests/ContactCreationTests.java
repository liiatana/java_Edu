package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.appmanager.ContactHelper;
import ru.stqa.pft.addressbook.model.NewContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void contactCreationTests() {

    app.getNavigationManager().gotoAddNewPage();
    app.getContactHelper().createNewContact(new NewContactData("1610qqq", "l1", "USA", "7845", "4",
            "sdhfjh@dfjhgkj.tw", "sdhj-gf@sdjkl.ru", "world","CreateGr"));
    app.getNavigationManager().gotoHome();

  }


}
