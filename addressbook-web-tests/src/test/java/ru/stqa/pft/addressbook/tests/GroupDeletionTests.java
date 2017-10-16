package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.NewContactData;

public class GroupDeletionTests extends TestBase {

    @Test
    public void testGroupDeletion() {

        app.getNavigationManager().gotoGroupPage();
        /*if (!app.getGroupHelper().isThereAGroup()) {
            +      app.getGroupHelper().createGroup(new GroupData("test1", "test2", "test3"));
            +    }*/
        if( !app.getGroupHelper().findAnyGroup()){
            app.getGroupHelper().createGroup(new GroupData("grDEl1", "test2", "test3"));
        };
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteSelectedGroups();
        app.getGroupHelper().returnToGroupPage();
    }

    public void createNewContact() {
      app.getNavigationManager().gotoAddNewPage();
      app.getContactHelper().fillContactForm(new NewContactData("1610", "l1", "USA", "7845", "4", "sdhfjh@dfjhgkj.tw", "sdhj-gf@sdjkl.ru", "world","test11"),true);
      app.getContactHelper().submitContactCreation();
      app.getNavigationManager().gotoHome();
    }
}
