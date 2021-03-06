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

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void fillContactForm(NewContactData contactData, boolean creation) {

    if (contactData.getFirstName()!=null){
      type(By.name("firstname"), contactData.getFirstName());
    }
    type(By.name("lastname"), contactData.getLastName());

    if (contactData.getAddress()!=null) {
      type(By.name("address"), contactData.getAddress());
    }
    if (contactData.getAddress2()!=null) {
      type(By.name("address2"), contactData.getAddress2());
    }

    if(contactData.getMobile()!=null){
      type(By.name("mobile"), contactData.getMobile());
    }
    if(contactData.getWork()!=null) {
      type(By.name("work"), contactData.getWork());
    }
    if(contactData.getEmail()!=null) {
      type(By.name("email"), contactData.getEmail());
    }
    if(contactData.getEmail2()!=null) {
      type(By.name("email2"), contactData.getEmail2());
    }
    if(contactData.getEmail3()!=null) {
      type(By.name("email3"), contactData.getEmail3());
    }
    if(contactData.getHome()!=null) {
      type(By.name("home"), contactData.getHome());
    }
    if(contactData.getPhoto()!=null){
        attach(By.name("photo"),contactData.getPhoto().getAbsolutePath());}


    if(creation ) {
      //wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS); //отключение таймаута
      if (contactData.getGroups().size()>0){
        Assert.assertTrue(contactData.getGroups().size()==1);
        new Select(wd.findElement(By.name("new_group")))
                .selectByVisibleText(contactData.getGroups().iterator().next().getName());
      }

    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }


  }

  private void attach(By photo, String file) {
    if(file!=null) {
        wd.findElement(photo).sendKeys(file);
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


  /*public Contacts all() {// старая версия до лекции 5,9( чтение и разделение телефонов)

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

  }*/

  public Contacts all() {

    Contacts contacts = new Contacts();

    List<WebElement> elements = wd.findElements(By.xpath("//tbody/tr[@name='entry']"));
    for (WebElement element : elements) {
      List<WebElement> elementDes = element.findElements(By.tagName("td"));

      NewContactData contact = new NewContactData()
              .withId(Integer.parseInt( element.findElement(By.tagName("input")).getAttribute("value")))
              .withLastName(elementDes.get   (1).getText())
              .withFirstName(elementDes.get   (2).getText())
              .withAddress(elementDes.get   (3).getText())
              .withAllEmails(elementDes.get   (4).getText())
              .withAllPhones(elementDes.get   (5).getText());
      contacts.add(contact);
    }


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


  public NewContactData infoFromEditForm(int contactId) {
    initContantactModificationByEditClick(contactId);
    NewContactData contactInfo = new NewContactData();

    contactInfo.withId(contactId);
    contactInfo.withFirstName(wd.findElement(By.name("firstname")).getAttribute("value"));
    contactInfo.withLastName(wd.findElement(By.name("lastname")).getAttribute("value"));
    contactInfo.withAddress(wd.findElement(By.name("address")).getAttribute("value"));
    contactInfo.withHomePhone(wd.findElement(By.name("home")).getAttribute("value"));
    contactInfo.withMobile(wd.findElement(By.name("mobile")).getAttribute("value"));
    contactInfo.withWorkPhone(wd.findElement(By.name("work")).getAttribute("value"));
    contactInfo.withEmail(wd.findElement(By.name("email")).getAttribute("value"));
    contactInfo.withEmail2(wd.findElement(By.name("email2")).getAttribute("value"));
    contactInfo.withEmail3(wd.findElement(By.name("email3")).getAttribute("value"));

    wd.navigate().back();

    return contactInfo;
  }

  public void addToGroup(NewContactData contact, GroupData addedGroup) {



    select(contact.getId());

    new Select(wd.findElement(By.name("to_group")))
            .selectByValue(Integer.toString( addedGroup.getId()));

    click(By.name("add"));

  }

  public void deleteFromGroup(NewContactData contact, GroupData deletedGroup) {

    new Select(wd.findElement(By.name("group")))
            .selectByValue(Integer.toString( deletedGroup.getId()));

    select(contact.getId());
    click(By.name("remove"));


  }
}
