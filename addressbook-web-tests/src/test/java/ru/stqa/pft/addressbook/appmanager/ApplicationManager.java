package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.Objects;

public class ApplicationManager {

  WebDriver wd;

  private NavigationManager navigationManager;
  private GroupHelper groupHelper;
  private SessionHelper sessionHelper;
  private ContactHelper contactHelper;
  private String browser;

  public ApplicationManager(String browser) {

    this.browser = browser;
  }

  public void init() {

    //String browser = BrowserType.FIREFOX;

    if (Objects.equals(browser, BrowserType.FIREFOX)) {
      wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
    } else if (Objects.equals(browser, BrowserType.CHROME)) {
      wd = new ChromeDriver();
    } else if ((Objects.equals(browser, BrowserType.IE))) {
      wd = new InternetExplorerDriver();
    }


    //wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS); //отключение таймаута
    wd.get("http://localhost:8080/addressbook/");
    groupHelper = new GroupHelper(wd);
    navigationManager = new NavigationManager(wd);
    sessionHelper = new SessionHelper(wd);
    contactHelper = new ContactHelper(wd);
    sessionHelper.login("admin", "secret");
  }


  public void stop() {
    wd.quit();
  }

  public GroupHelper group()
  {
    return groupHelper;
  }

  public NavigationManager goTo() {
    return navigationManager;
  }

  public ContactHelper getContactHelper() {
    return contactHelper;
  }


}
