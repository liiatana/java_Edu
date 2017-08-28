package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {

  @Test
  public void contactDeletionTests(){
    app.getContactHelper().selectContacts("5");
    app.getContactHelper().deleteSelectedContacts();
    app.getNavigationManager().gotoHomeMenuLevel();

  }
}
