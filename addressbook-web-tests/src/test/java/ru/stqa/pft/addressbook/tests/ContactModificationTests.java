package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.NewContactData;

public class ContactModificationTests extends TestBase {

  @Test (enabled=false) // тест изменения контакта через кнопку Edit(Карандаш)
  public void contactModificationTestByEditClick() {

    app.getContactHelper().initContantactModificationByEditClick();
    fillNewContactInformation((new NewContactData("mody1qqqq", "QAZ", "USA", "7845", "4", "sdhfjh@dfjhgkj.tw", "sdhj-gf@sdjkl.ru", "world",null)));

  }

  private void fillNewContactInformation(NewContactData contactData) {
    app.getContactHelper().fillContactForm(contactData,false);
    app.getContactHelper().submitContactModification();
    app.getNavigationManager().gotoHome();
  }

  @Test (enabled=false)//тест изменения контакта через промотр карточки контакта
  public void contactModificationByDetails() {

    app.getContactHelper().openContactDetails();
    app.getContactHelper().initContantactModificationByDetails();
    fillNewContactInformation(new NewContactData("Detmody1qqqq", "ZXC", "USA", "7845", "4", "sdhfjh@dfjhgkj.tw", "sdhj-gf@sdjkl.ru", "world","test11"));
  }

  public void createNewContact() {
    app.getNavigationManager().gotoAddNewPage();
    app.getContactHelper().fillContactForm(new NewContactData("1610", "l1", "USA", "7845", "4", "sdhfjh@dfjhgkj.tw", "sdhj-gf@sdjkl.ru", "world","test11"),true);
    app.getContactHelper().submitContactCreation();
    app.getNavigationManager().gotoHome();
  }
}

