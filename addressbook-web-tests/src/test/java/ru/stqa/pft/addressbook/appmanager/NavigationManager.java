package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationManager extends HelperBase {


  public NavigationManager(WebDriver wd) {
    super(wd);
  }

  public void groupPage() {

    if(isElementPresent(By.tagName("h1"))
            && wd.findElement(By.tagName("h1")).getText().equals("Groups")
            && isElementPresent(By.tagName("new"))){
      return;
    }
    click(By.linkText("groups"));
  }

  public void gotoAddNewPage() {
    if(isElementPresent(By.id("Enter"))){
      return;
    }
    click(By.linkText("add new"));
  }

  public void gotoHome() {

    if(isElementPresent(By.id("maintable"))){
      return;
    }
    click(By.linkText("home page"));
  }

  public void gotoHomeMenuLevel() {
    click(By.linkText("home"));
  }
}
