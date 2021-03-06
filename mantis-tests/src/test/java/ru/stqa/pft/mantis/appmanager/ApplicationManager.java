package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class ApplicationManager {

  private WebDriver wd;

  private final Properties properties;

  private String browser;
  private RegistrationHelper registrationHelper;
  private FtpHelper ftp;
  private MailHelper mail;
  private DbHelper db;
  private UserManageHelper um;
  private SoapHelper sp;



  public ApplicationManager(String browser)  {

    this.browser = browser;
    properties = new Properties();

  }
  public void init() throws IOException {

    //String browser = BrowserType.FIREFOX;

    String target=System.getProperty("target","local");
    properties.load(new FileReader(new File(String.format("src\\test\\resources\\%s.properties",target))));
    //db = new DbHelper();

   }

  public void stop() {
    if (wd != null) {
         wd.quit();
    }
  }

  public HttpSession newSession(){
    return new HttpSession(this);
  }


  public String getProperty(String key) {
       return properties.getProperty(key);
  }

  public RegistrationHelper registration() {
    if (registrationHelper==null) {
      registrationHelper = new RegistrationHelper(this);
    }
    return registrationHelper;
  }

  public WebDriver getDiver() {
    if (wd==null){
          if (Objects.equals(browser, BrowserType.FIREFOX)) {
            wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
          } else if (Objects.equals(browser, BrowserType.CHROME)) {
            wd = new ChromeDriver();
          } else if ((Objects.equals(browser, BrowserType.IE))) {
            wd = new InternetExplorerDriver();
          }
    }
    //wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS); //отключение таймаута
    wd.get(properties.getProperty("web.baseUrl"));
    return wd;
  }

  public FtpHelper ftp() {
    if (ftp ==null) {
      ftp = new FtpHelper(this);
    }
    return ftp;
  }

  public MailHelper mail() {
    if (mail ==null) {
      mail = new MailHelper(this);
    }
    return mail;
  }

  public DbHelper db() {
    if (db==null){
      db = new DbHelper(this);
    }
    return db;
  }

  public UserManageHelper um(){
    um=new UserManageHelper(this);
    return um;
  }

  public SoapHelper sp(){
    if(sp==null) {
      sp = new SoapHelper(this);
    }
    return sp;
  }
}
