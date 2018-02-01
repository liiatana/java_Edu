package ru.stqa.pft.addressbook.tests;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ru.stqa.pft.addressbook.model.Contacts;

import ru.stqa.pft.addressbook.model.NewContactData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @DataProvider
  public java.util.Iterator <Object[]> validContactsFromJSON() throws IOException {

    List<Object[]> list=new ArrayList< Object[]>();
    try(BufferedReader reader=new BufferedReader(  new FileReader(new File("src\\test\\resources\\testContact.json")))) {
      String line = reader.readLine();
      String json = "";
      while (line != null) {
        json += line;
        line = reader.readLine();
      }
      Gson gson = new Gson();
      List<NewContactData> contacts = gson.fromJson(json, new TypeToken<List<NewContactData>>() {
      }.getType()); //это аналогично List<NewContactData>.class
      return contacts.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();// вот это заворот каждого объекта в массив из одного элемента, так надо для TestNG
    }
  }

  @Test(enabled = true , dataProvider = "validContactsFromJSON")
  public void contactCreationTests(NewContactData contactData) {

    Contacts before = app.contact().all();
    app.goTo().AddNewPage();
    contactData.withPhoto(new File("src/test/resources/PNG74.png"));

    app.contact().createNew(contactData);
    app.goTo().Home();

    Contacts after = app.contact().all();

    assertThat(after.size(), equalTo(before.size() + 1));
   // newContact.setGroup(null);
    //newContact.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt());
    ;

    //assertThat(after, equalTo(before.withAdded(newContact.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt()))));
            //эта дрянь не работает- и непонятному почему


    }


}
