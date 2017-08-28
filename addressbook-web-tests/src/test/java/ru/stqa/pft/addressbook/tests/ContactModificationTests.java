package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.NewContactData;

public class ContactModificationTests extends TestBase {

  @Test // тест изменения контакта через кнопку Edit(Карандаш)
  public void contactModificationTestByEditClick() {

    app.getContactHelper().initContantactModificationByEditClick();
    fillNewContactInformation(new NewContactData("mody1qqqq", "QAZ", "USA", "7845", "4", "sdhfjh@dfjhgkj.tw", "sdhj-gf@sdjkl.ru", "world"));

  }

  private void fillNewContactInformation(NewContactData contactData) {
    app.getContactHelper().fillContactForm(contactData);
    app.getContactHelper().submitContactModification();
    app.getNavigationManager().gotoHome();
  }

  @Test //тест изменения контакта через промотр карточки контакта
  public void contactModificationByDetails(){

    app.getContactHelper().openContactDetails();
    app.getContactHelper().initContantactModificationByDetails();
    fillNewContactInformation(new NewContactData("Detmody1qqqq", "ZXC", "USA", "7845", "4", "sdhfjh@dfjhgkj.tw", "sdhj-gf@sdjkl.ru", "world"));
  }

}

