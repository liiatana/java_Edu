package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.NewContactData;

public class ContactModificationTests extends TestBase {

  @Test // тест изменения контакта через кнопку Edit(Карандаш)
  public void contactModificationTestByEditClick() {

    app.getContactHelper().initContantactModificationByEditClick();
    app.getContactHelper().fillContactForm(new NewContactData("mody1qqqq", "QAZ", "USA", "7845", "4", "sdhfjh@dfjhgkj.tw", "sdhj-gf@sdjkl.ru", "world"));
    app.getContactHelper().submitContactModification();
    app.getNavigationManager().gotoHome();

  }

  @Test //тест изменения контакта через промотр карточки контакта
  public void contactModificationByDetails(){

    app.getContactHelper().openContactDetails();
    app.getContactHelper().initContantactModificationByDetails();
    app.getContactHelper().fillContactForm(new NewContactData("Detmody1qqqq", "ZXC", "USA", "7845", "4", "sdhfjh@dfjhgkj.tw", "sdhj-gf@sdjkl.ru", "world"));
    app.getContactHelper().submitContactModification();
    app.getNavigationManager().gotoHome();
  }

}

