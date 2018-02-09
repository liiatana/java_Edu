package ru.stqa.pft.mantis.tests;


import org.openqa.selenium.remote.BrowserType;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.mantis.appmanager.ApplicationManager;
import ru.stqa.pft.mantis.appmanager.FtpHelper;

import javax.xml.rpc.ServiceException;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;


public class TestBase {



  protected static final ApplicationManager app
           = new ApplicationManager(System.getProperty("browser", BrowserType.FIREFOX)); // в настроках запуска теста нужно дописать  -Dbrowser=firefox( в поле VM)


  /*protected static final ApplicationManager app = new ApplicationManager (BrowserType.CHROME);*/
  //@BeforeMethod // если beforemethod-то запускается перед каждым тестовым методом lecture 5.1
  @BeforeSuite
  public void setUp() throws Exception {

    app.init();
    app.ftp().upload(new File("src/test/resources/config_inc.php"),"config_inc.php","config_inc.php.bak");
  }

  //@AfterMethod //после каждого медода
  @AfterSuite(alwaysRun = true)
  public void tearDown() throws IOException {
    app.ftp().restore("config_inc.php.bak","config_inc.php");
    app.stop();
  }


  public boolean isIssueOpen(int issueId) throws RemoteException, ServiceException, MalformedURLException {


    String status="resolved";
        return  status.equals(app.sp().checkIssueStatus(issueId));

  }


  public void skipIfNotFixed(int issueId) throws RemoteException, ServiceException, MalformedURLException {
    if (!isIssueOpen(issueId)) {
      throw new SkipException("Ignored because of issue " + issueId);
    }
  }

}
