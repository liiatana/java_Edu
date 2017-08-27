package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

  FirefoxDriver wd;

  private NavigationManager navigationManager;
  private GroupHelper groupHelper;
  private SessionHelper sessionHelper;



  public void init() {
   // groupHelper.wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
    //groupHelper.wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    //groupHelper.wd.get("http://localhost:8080/addressbook/");
    wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
    wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    wd.get("http://localhost:8080/addressbook/");
    groupHelper = new GroupHelper(wd);
    navigationManager = new NavigationManager(wd);
    sessionHelper=new SessionHelper(wd);
    sessionHelper.login("admin", "secret");
  }



  public void stop() {
    wd.quit();
  }

  public GroupHelper getGroupHelper() {
    return groupHelper;
  }

  public NavigationManager getNavigationManager() {
    return navigationManager;
  }
}
