package ru.stqa.pft.addressbook.appmanager;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.addressbook.model.NewContactData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void fillContactForm(NewContactData contactData, boolean creation) {

    type(By.name("firstname"), contactData.getFirstName());
    type(By.name("lastname"), contactData.getLastName());
    type(By.name("address"), contactData.getAddress());
    type(By.name("mobile"), contactData.getMobile());
    type(By.name("work"), contactData.getWork());
    type(By.name("email"), contactData.getEmail());
    type(By.name("email3"), contactData.getEmail3());
    type(By.name("address2"), contactData.getAddress2());

    if(creation) {
      //wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS); //отключение таймаута
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());

    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }

    /*
      if (isElementPresent(By.name("new_group"))) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    }
    */

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

  public void selectContacts( int contactId) {

    /*if(isElementPresent(By.name("selected[]"))){
      click(By.name("selected[]"));
    }*/
    wd.findElements(By.name("selected[]")).get(contactId).click();
    // click(By.name("selected[]"));

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

  public boolean findAnyContact() {

         return isElementPresent(By.name("selected[]"));
  }


  public void createNewContact(NewContactData contactData) {

    fillContactForm(contactData,true);
    submitContactCreation();

  }

  public List<NewContactData> getContactList() {

    List<NewContactData> contacts = new ArrayList<NewContactData>();
    List<WebElement> elements = wd.findElements(By.xpath("//tbody/tr[@name='entry']"));//находит все элементы по css сектору

    for (WebElement element : elements) {
      List<WebElement> elementDes = element.findElements(By.tagName("td"));

      NewContactData contact = new NewContactData(
              Integer.parseInt( element.findElement(By.tagName("input")).getAttribute("value")),
              elementDes.get   (1).getText(),
              elementDes.get   (2).getText(),
              elementDes.get   (3).getText(),
              null,
              null,
              null,
              null,
              null,
              null);
      contacts.add(contact);
    }
    ;
    return contacts;
  }
}
