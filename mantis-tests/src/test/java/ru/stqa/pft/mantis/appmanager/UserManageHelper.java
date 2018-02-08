package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;

public class UserManageHelper extends HelperBase{

  public UserManageHelper(ApplicationManager app) {
    super(app);
    //this.app=app;
    //wd=app.getDiver();
  }

  public void resetUserPassword(Integer userId) {
    wd.get(app.getProperty("web.baseUrl") +String.format( "/manage_user_edit_page.php?user_id=%s",userId)); ///manage_user_page.php
    click(By.cssSelector( "input[value='Reset Password']")); //click(By.cssSelector("input[value='Reset Password']"));
    System.out.println("ОК");
  }

  public void confirmChangePassword(String confirmationLink, String password) {
    wd.get(confirmationLink);
    type(By.name("password"),password);
    type(By.name("password_confirm"),password);
    click(By.cssSelector("input[value='Update User']"));
  }


}
