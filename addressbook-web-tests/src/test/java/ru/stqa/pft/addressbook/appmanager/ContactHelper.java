package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.NewContactData;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void fillContactForm(NewContactData contactData) {

    type(By.name("firstname"), contactData.getFirstName());
    type(By.name("lastname"), contactData.getLastName());
    type(By.name("address"), contactData.getAddress());
    type(By.name("mobile"), contactData.getMobile());
    type(By.name("work"), contactData.getWork());
    type(By.name("email"), contactData.getEmail());
    type(By.name("email3"), contactData.getEmail3());
    type(By.name("address2"), contactData.getAddress2());

  }

  public void submitContactCreation() {
    click(By.name("submit"));
  }

  public void initContantactModificationByEditClick() {

    click(By.xpath("//html/body/div/div[4]/form[2]/table/tbody/tr[2]/td[8]/a/img"));

  }


  public void submitContactModification() {
    click(By.name("update"));
  }

  public void selectContacts(String contactId) {

    click(By.id(contactId));

  }

  public void openContactDetails() {
    click(By.xpath("/html/body/div/div[4]/form[2]/table/tbody/tr[2]/td[7]/a/img"));
  }

  public void initContantactModificationByDetails() {
    click(By.name("modifiy"));

  }

  public void deleteSelectedContacts() {

    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    wd.switchTo().alert().accept();
  }
}