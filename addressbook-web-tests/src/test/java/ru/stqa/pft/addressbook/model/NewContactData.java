package ru.stqa.pft.addressbook.model;

public class NewContactData {
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
  private String firstName;
  private String lastName;
  private String address;
  private String mobile;
  private String work;
  private String email;
  private String email3;
  private String address2;

  public void setGroup(String group) {
    this.group = group;
  }

  private String group;


  /*public NewContactData(int id, String firstName, String lastName, String address, String mobile, String work, String email, String email3, String address2, String group) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
    this.mobile = mobile;
    this.work = work;

    this.email = email;
    this.email3 = email3;
    this.address2 = address2;

    this.group = group;
  }

  public NewContactData(String firstName, String lastName, String address, String mobile, String work, String email, String email3, String address2, String group) {
    this.id = 0;
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
    this.mobile = mobile;
    this.work = work;

    this.email = email;
    this.email3 = email3;
    this.address2 = address2;

    this.group = group;
  }*/


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

  public void setId(int id) {
    this.id = id;
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

}
