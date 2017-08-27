package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

  @Test
  //создание группы в адресной книге
  public void testGroupCreation() {
    gotoGroupPage();
    initGroupCreation();
    fillGroupForm(new GroupData("test11", "test2", "test3"));
    submitGroupCreation();
    returnToGroupPage();
  }

}
