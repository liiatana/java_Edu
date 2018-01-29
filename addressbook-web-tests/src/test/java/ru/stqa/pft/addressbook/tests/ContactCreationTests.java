package ru.stqa.pft.addressbook.tests;
import org.testng.annotations.Test;

import org.testng.Assert;

import ru.stqa.pft.addressbook.appmanager.ContactHelper;
import ru.stqa.pft.addressbook.model.NewContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test(enabled = false)
  public void contactCreationTests() {

    NewContactData newContact= new NewContactData("1ффф610qqq", "l1", "USA", "7845", "4",
            "sdhfjh@dfjhgkj.tw", "sdhj-gf@sdjkl.ru", "world","CreateGr");

    List<NewContactData> before=app.getContactHelper().getContactList();
    app.goTo().gotoAddNewPage();


    app.getContactHelper().createNewContact(newContact);
    app.goTo().gotoHome();

    List<NewContactData> after=app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);

    newContact.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(),o2.getId())).get().getId());
    before.add(newContact);

    Comparator<? super NewContactData> byId=new Comparator<NewContactData>() {
      @Override
      public int compare(NewContactData o1, NewContactData o2) {
        if (o1.getId()> o2.getId()){


        };

        return 0;
      }
    };
    after.stream().sorted(byId);

  }


}
