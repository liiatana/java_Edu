package ru.stqa.pft.addressbook.appmanager;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;
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
    //type(By.name("mobile"), contactData.getMobile());
    //type(By.name("work"), contactData.getWork());
    //type(By.name("email"), contactData.getEmail());
    //type(By.name("email3"), contactData.getEmail3());
    //type(By.name("address2"), contactData.getAddress2());

    if(creation ) {
      //wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS); //отключение таймаута
      if (contactData.getGroup()!=null){
        new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
      }

    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }


  }

  public void submitContactCreation() {
    click(By.name("submit"));
  }

  public void initContantactModificationByEditClick(int id) {

    //click(By.xpath("//html/body/div/div[4]/form[2]/table/tbody/tr[2]/td[8]/a/img"));
    wd.findElement(By.xpath(String.format("//input[@id='%s']/../..//img[@title='Edit']", id))).click();

  }


  public void submitContactModification() {
    click(By.name("update"));
  }

  public void select(int contactId) {

        //wd.findElements(By.name("selected[]")).get(contactId).click();
    wd.findElement(By.cssSelector("input[id='" + contactId + "']")).click();


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

  public boolean findAny() {

         return isElementPresent(By.name("selected[]"));
  }


  public void createNew(NewContactData contactData) {

    fillContactForm(contactData,true);
    submitContactCreation();

  }


  public Contacts all() {

    Contacts contacts = new Contacts();

    List<WebElement> elements = wd.findElements(By.xpath("//tbody/tr[@name='entry']"));
    for (WebElement element : elements) {
      List<WebElement> elementDes = element.findElements(By.tagName("td"));
      NewContactData contact = new NewContactData()
              .withId(Integer.parseInt( element.findElement(By.tagName("input")).getAttribute("value")))
              .withLastName(elementDes.get   (1).getText())
              .withFirstName(elementDes.get   (2).getText())
              .withAddress(elementDes.get   (3).getText());

      contacts.add(contact);
    }
    ;

    return contacts;

  }


  public void delete(NewContactData deletedContact) {
    select(deletedContact.getId());
    deleteSelectedContacts();
  }

  public void modifyByEditClick(NewContactData newContactInfo) {
   // initContantactModificationByEditClick(newContactInfo.getId());
    fillContactForm(newContactInfo,false);
    submitContactModification();

  }


}
