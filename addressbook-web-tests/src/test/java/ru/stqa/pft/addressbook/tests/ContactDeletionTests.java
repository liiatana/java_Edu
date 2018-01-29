package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.NewContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase {

  @Test(enabled = false)
  public void contactDeletionTests() {

    if (!app.getContactHelper().findAnyContact()) {
      app.getNavigationManager().gotoAddNewPage();
      app.getContactHelper().createNewContact(new NewContactData("new1610", "l1", "USA", "7845", "4",
              "sdhfjh@dfjhgkj.tw", "sdhj-gf@sdjkl.ru", "world", "CreateGr"));
      app.getNavigationManager().gotoHome();
    }

    List<NewContactData> before=app.getContactHelper().getContactList();
    app.getContactHelper().selectContacts(before.size()-1);
    app.getContactHelper().deleteSelectedContacts();
    app.getNavigationManager().gotoHomeMenuLevel();

    List<NewContactData> after=app.getContactHelper().getContactList();

    Assert.assertEquals(after.size(),before.size()-1);

    before.remove(before.size()-1);
    Assert.assertEquals(before,after);


  }


}
