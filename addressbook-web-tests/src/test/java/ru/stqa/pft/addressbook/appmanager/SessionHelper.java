package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SessionHelper extends HelperBase {

  //private FirefoxDriver wd; //ссылка на драйвер больше не нужна так как наследуется из базового класса HelperBase

  public SessionHelper(WebDriver wd) {
    super(wd);
    //this.wd=wd;
  }

  public void login(String username, String password) {
    type(By.name("user"), username);
    type(By.name("pass"), password);
    click(By.xpath("//form[@id='LoginForm']/input[3]"));

  }
}
