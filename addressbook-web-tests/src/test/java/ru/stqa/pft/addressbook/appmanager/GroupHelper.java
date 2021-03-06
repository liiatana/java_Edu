package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GroupHelper extends HelperBase {

  public GroupHelper(WebDriver wd) {
    super(wd);
  }


  public void returnToGroupPage() {
    click(By.linkText("group page"));
  }

  public void submitGroupCreation() {
    click(By.name("submit"));
  }

  public void fillGroupForm(GroupData groupData) {
    type(By.name("group_name"), groupData.getName());
    type(By.name("group_header"), groupData.getHeader());
    type(By.name("group_footer"), groupData.getFooter());
  }

  public void initGroupCreation() {
    click(By.name("new"));
  }

  public void deleteSelectedGroups() {
    click(By.name("delete"));
  }

  public void selectGroup(int index) {

    wd.findElements(By.name("selected[]")).get(index).click();
    // click(By.name("selected[]"));
  }

  public void initGroupModification() {
    click(By.name("edit"));

  }

  public void submitGroupModification() {
    click(By.name("update"));
  }

  /*public boolean findAnyGroup() {
    return isElementPresent(By.name("selected[]"));
  }*/


  public void create(GroupData groupData) {
    initGroupCreation();
    fillGroupForm(groupData);
    submitGroupCreation();
    groupsCache=null;
    returnToGroupPage();

  }
  public void modify( GroupData group) {
    selectGroupById(group.getId());
    initGroupModification();
    fillGroupForm( group);
    submitGroupModification();
    groupsCache=null;
    returnToGroupPage();
  }

  /*public void delete(int index) {
   selectGroup(index);
    deleteSelectedGroups();
   returnToGroupPage();
  }*/

  public void delete(GroupData deletedGroup) {
    selectGroupById(deletedGroup.getId());
    deleteSelectedGroups();
    groupsCache=null;
    returnToGroupPage();
  }

  private void selectGroupById(int id) {
    wd.findElement(By.cssSelector( "input[value='"+id +"']")).click();

  }

  public int count() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public List<GroupData> list() {

    List<GroupData> groups = new ArrayList<GroupData>();
    List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));//находит все элементы по css сектору с тегом span и классом group
    for (WebElement element : elements) {
      GroupData group = new GroupData()
              .withId(Integer.parseInt( element.findElement(By.tagName("input")).getAttribute("value"))).withName(element.getText());
              //(Integer.parseInt( element.findElement(By.tagName("input")).getAttribute("value")), element.getText(), null, null);
      groups.add(group);
    }
    ;

    return groups;

  }

  private Groups groupsCache=null;

  public Groups all() {
    if(groupsCache!=null){
      return new Groups(groupsCache);
    }

    Groups groupsCache = new Groups();
    List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));//находит все элементы по css сектору с тегом span и классом group
    for (WebElement element : elements) {
      GroupData group = new GroupData()
              .withId(Integer.parseInt( element.findElement(By.tagName("input")).getAttribute("value"))).withName(element.getText());
      //(Integer.parseInt( element.findElement(By.tagName("input")).getAttribute("value")), element.getText(), null, null);
      groupsCache.add(group);
    }
    ;

    return new Groups(groupsCache);

  }



}
