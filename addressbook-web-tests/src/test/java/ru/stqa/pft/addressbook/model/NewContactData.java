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
  private String home;
  private String email;
  private String email3;
  private String address2;
  private String allPhones;

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




  public void setGroup(String group) {
    this.group = group;
  }

  private String group;



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

}
