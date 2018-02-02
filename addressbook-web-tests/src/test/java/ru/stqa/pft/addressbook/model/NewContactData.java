package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
@Entity
@Table (name="addressbook")

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
  @Id
  @Column (name="id")
  private int id;

  @Expose // аннотация для json.Означает что ПОЛЕ НАДО выгружать поле в json
  @Column (name="firstname")
  private String firstName;

  @Expose
  @Column (name="lastname")
  private String lastName;

  @Expose
  @Column (name="address")
  @Type(type="text")
  private String address;

  @Expose
  @Column (name="mobile")
  @Type(type="text")
  private String mobile;

  @Expose
  @Column (name="work")
  @Type(type="text")
  private String work;

  @Expose
  @Column (name="home")
  @Type(type="text")
  private String home;

  @Expose
  @Type(type="text")
  @Column (name="email")
  private String email;

  @Expose
  @Column (name="email2")
  @Type(type="text")
  private String email2;

  @Expose
  @Column (name="email3")
  @Type(type="text")
  private String email3;

  @Expose
  @Type(type="text")
  @Column (name="address2")
  private String address2;

  @Transient
  private String allPhones;

  @Transient
  private String allEmails;

  @Expose
  @Transient // означает, что пропускать , т.к информация о группе контакта не хранится в таблице, либо
  // можно использовать аналогичное слово перед аннотацией, т.е чтобы выглядело объявление так: transient private String group;
  private String group;

  @Expose
  // В Бд у нас строка, а в объекте тип поля=ФАЙЛ, поэтому декларацию (private File photo;) меняем на String и меняем getter +setter
  // так чтобы они сами преобразовывали в тип File
  @Column (name="photo")
  @Type(type="text")
  private String photo;

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
    return new File(photo);
  }

  public NewContactData withPhoto(File photo) {
    this.photo = photo.getPath();
    return this;
  }

  @Override
  public String toString() {
    return "NewContactData{" +
            "id=" + id +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            '}';
  }
}
