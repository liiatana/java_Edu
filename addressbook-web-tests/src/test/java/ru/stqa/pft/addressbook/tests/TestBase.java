package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
//import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
//import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.addressbook.appmanager.ApplicationManager;

import static org.openqa.selenium.remote.BrowserType.*;
//import ru.stqa.pft.addressbook.model.NewContactData;

public class TestBase {


  protected static final ApplicationManager app
           = new ApplicationManager(System.getProperty("browser", BrowserType.FIREFOX)); // в настроках запуска теста нужно дописать  -Dbrowser=firefox( в поле VM)

         /*protected static final ApplicationManager app = new ApplicationManager (BrowserType.CHROME);*/
  //@BeforeMethod // если beforemethod-то запускается перед каждым тестовым методом lecture 5.1
  @BeforeSuite
  public void setUp() throws Exception {

    app.init();
  }

  //@AfterMethod //после каждого медода
  @AfterSuite
  public void tearDown() {
    app.stop();
  }

}
