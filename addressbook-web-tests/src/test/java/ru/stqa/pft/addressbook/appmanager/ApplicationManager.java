package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class ApplicationManager {

  WebDriver wd;

  private final Properties properties;

  private NavigationManager navigationManager;
  private GroupHelper groupHelper;
  private SessionHelper sessionHelper;
  private ContactHelper contactHelper;
  private String browser;
  private DbHelper dbHelper;
  private RestApiHelper apiH;

  public ApplicationManager(String browser)  {

    this.browser = browser;
    properties = new Properties();

  }
  public void init() throws IOException {

    //String browser = BrowserType.FIREFOX;
    dbHelper = new DbHelper();

    String target=System.getProperty("target","local");
    properties.load(new FileReader(new File(String.format("src\\test\\resources\\%s.properties",target))));

    if (Objects.equals(browser, BrowserType.FIREFOX)) {
      wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
    } else if (Objects.equals(browser, BrowserType.CHROME)) {
      wd = new ChromeDriver();
    } else if ((Objects.equals(browser, BrowserType.IE))) {
      wd = new InternetExplorerDriver();
    }


    //wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS); //отключение таймаута

    wd.get(properties.getProperty("web.baseUrl"));
    groupHelper = new GroupHelper(wd);
    navigationManager = new NavigationManager(wd);
    sessionHelper = new SessionHelper(wd);
    contactHelper = new ContactHelper(wd);
    sessionHelper.login(properties.getProperty("web.adminLogin"),
            properties.getProperty("web.adminPass"));
    dbHelper = new DbHelper();
    apiH= new RestApiHelper();
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

  public ContactHelper contact() {
    return contactHelper;
  }

  public DbHelper db() {
    return dbHelper;
  }

  public RestApiHelper apiH() {

    return apiH;
  }

}
