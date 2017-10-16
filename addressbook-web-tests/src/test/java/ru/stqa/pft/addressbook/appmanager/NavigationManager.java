package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationManager extends HelperBase {


  public NavigationManager(WebDriver wd) {
    super(wd);
  }

  public void gotoGroupPage() {

    //if(isElementPresent(By.tagName("h1")) && )
    click(By.linkText("groups"));
  }

  public void gotoAddNewPage() {
    click(By.linkText("add new"));
  }

  public void gotoHome() {
    click(By.linkText("home page"));
  }

  public void gotoHomeMenuLevel() {
    click(By.linkText("home"));
  }
}
