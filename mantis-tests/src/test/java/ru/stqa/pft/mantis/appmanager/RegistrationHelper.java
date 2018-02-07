package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;


public class RegistrationHelper extends HelperBase {
  //private final ApplicationManager app;
  //private WebDriver wd;

  public RegistrationHelper(ApplicationManager app) {
    super(app);
    //this.app=app;
    //wd=app.getDiver();
  }

  public void start(String userName, String email) {
    wd.get(app.getProperty("web.baseUrl") + "/signup_page.php");
    type(By.name("username"),userName);
    type(By.name("email"),email);
    click(By.cssSelector(".button"));//.button
  }

  public void finish(String confirmationLink, String password) {
    wd.get(confirmationLink);
    type(By.name("password"),password);
    type(By.name("password_confirm"),password);
    click(By.cssSelector("input[value='Update User']"));
  }
}


