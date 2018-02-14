package ru.stqa.pft.addressbook.tests;

import org.hamcrest.MatcherAssert;
import org.openqa.selenium.remote.BrowserType;
//import org.testng.annotations.AfterMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
//import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.addressbook.appmanager.ApplicationManager;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalToObject;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.openqa.selenium.remote.BrowserType.*;
//import ru.stqa.pft.addressbook.model.NewContactData;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestBase {
  Logger logger= LoggerFactory.getLogger(TestBase.class);


  protected static final ApplicationManager app
           = new ApplicationManager(System.getProperty("browser", BrowserType.FIREFOX)); // в настроках запуска теста нужно дописать  -Dbrowser=firefox( в поле VM)

         /*protected static final ApplicationManager app = new ApplicationManager (BrowserType.CHROME);*/
  //@BeforeMethod // если beforemethod-то запускается перед каждым тестовым методом lecture 5.1
  @BeforeSuite
  public void setUp() throws Exception {

    app.init();
  }

  //@AfterMethod //после каждого медода
  @AfterSuite(alwaysRun = true)
  public void tearDown() {
    app.stop();
  }

  @BeforeMethod
  public void logTestStart(Method m, Object[] p){
    logger.info("start " + m.getName()+ " with parametrs " + Arrays.asList(p));

  }

  @AfterMethod(alwaysRun = true)
  public void logTestStop(Method m){
    logger.info("end " + m.getName());

  }

  public void verifyListGroupInUI() {
    if(Boolean.getBoolean("verifyUi")) {
      Groups dbGroups = app.db().groups();
      Groups uiGroups = app.group().all();
      MatcherAssert.assertThat(uiGroups, equalToObject(dbGroups.stream()
              .map((g) -> new GroupData().withId(g.getId()).withName(g.getName()))
              .collect(Collectors.toSet())));
    }
  }

  public boolean isIssueOpen(int issueId){
    int issueStatusFromBugify = app.apiH().getIssueStatusFromBugify(issueId);
    if (issueStatusFromBugify==2 || issueStatusFromBugify==3){
      return false;
    }else return true;
  }

  public void skipIfNotFixed(int issueId) {
    if (isIssueOpen(issueId)) {
      throw new SkipException("Ignored because of issue " + issueId);
    }
  }

}
