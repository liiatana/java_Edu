package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;

import java.io.File;

public class  NewContactData {
  /*private int id;
  private final String firstName;
  private final String lastName;
  private final String address;
  private final String mobile;
  private final String work;
  private final String email;
  private final String email3;
  private final String address2;
  private String group;*/
  private int id;
  @Expose // аннотация для json.Означает что НАДО выгружать поле в json
  private String firstName;
  @Expose
  private String lastName;
  @Expose
  private String address;
  @Expose
  private String mobile;
  @Expose
  private String work;
  @Expose
  private String home;
  @Expose
  private String email;
  @Expose
  private String email2;
  @Expose
  private String email3;
  @Expose
  private String address2;

  private String allPhones;
  private String allEmails;
  @Expose
  private String group;

  private File photo;

  public String getAllEmails() {
    return allEmails;
  }





  public String getAllPhones() {
    return allPhones;
  }

  public NewContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }



  public String getHome() {
    return home;
  }


  public String getEmail2() {
    return email2;
  }

  public void setGroup(String group) {
    this.group = group;
  }





  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getAddress() {
    return address;
  }

  public String getMobile() {
    return mobile;
  }

  public String getWork() {
    return work;
  }

  public String getEmail() {
    return email;
  }

  public String getEmail3() {
    return email3;
  }

  public String getAddress2() {
    return address2;
  }

  public String getGroup() {
    return group;
  }

  public int getId() {
    return id;
  }

    public NewContactData withId(int id){
    this.id = id;
    return this;
  }

  public NewContactData withFirstName(String firstName){
    this.firstName = firstName;
    return this;
  }
  public NewContactData withLastName(String lastName){
    this.lastName = lastName;
    return this;
  }
  public NewContactData withAddress(String address){
    this.address = address;
    return this;
  }
  public NewContactData withGroup(String group){
    this.group = group;
    return this;
  }
  public NewContactData withMobile(String mobile){
    this.mobile = mobile;
    return this;
  }
  public NewContactData withWorkPhone(String workPhone){
    this.work = workPhone;
    return this;
  }
  public NewContactData withHomePhone(String homePhone){
    this.home = homePhone;
    return this;
  }

  public NewContactData withEmail(String email) {
    this.email = email;
    return this;
  }

  public NewContactData withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }

  public NewContactData withEmail3(String email3) {
    this.email3 = email3;
    return this;
  }

  public NewContactData withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }

  public File getPhoto() {
    return photo;
  }

  public NewContactData withPhoto(File photo) {
    this.photo = photo;
    return this;
  }
}
