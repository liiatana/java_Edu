package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.NewContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void contactCreationTests() {

    app.getNavigationManager().gotoAddNewPage();
    app.getContactHelper().fillContactForm(new NewContactData("1610", "l1", "USA", "7845", "4", "sdhfjh@dfjhgkj.tw", "sdhj-gf@sdjkl.ru", "world","test11"),true);
    app.getContactHelper().submitContactCreation();
    app.getNavigationManager().gotoHome();
  }
}
