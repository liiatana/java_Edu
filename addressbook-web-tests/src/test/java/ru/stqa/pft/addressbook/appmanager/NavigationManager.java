package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationManager extends HelperBase {


  public NavigationManager(FirefoxDriver wd) {
    super(wd);
  }

  public void gotoGroupPage() {

    click(By.linkText("groups"));
  }

  public void gotoAddNewPage() {
    click(By.linkText("add new"));
  }

  public void gotoHome() {
    click(By.linkText("home page"));
  }
}
