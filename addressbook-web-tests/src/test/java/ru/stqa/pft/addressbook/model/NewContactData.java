package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

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

  //@Expose
  //@Transient // означает, что пропускать , т.к информация о группе контакта не хранится в таблице, либо
  // можно использовать аналогичное слово перед аннотацией, т.е чтобы выглядело объявление так: transient private String group;
  //private String group;

  @ManyToMany(fetch=FetchType.EAGER)// чтобы сразу извлекалась и инфа о контактах
  @JoinTable(name="address_in_groups",
          joinColumns = @JoinColumn(name="id"),inverseJoinColumns = @JoinColumn (name="group_id"))
  private Set<GroupData> groups= new HashSet<GroupData>();



  @Expose
  // В Бд у нас строка, а в объекте тип поля=ФАЙЛ, поэтому декларацию (private File photo;) меняем на String и меняем getter +setter
  // так чтобы они сами преобразовывали в тип File
  //@Column (name="photo")
  //@Type(type="text")
  @Transient
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


  public NewContactData withMobile(String mobile){
    this.mobile = mobile;
    return this;
  }

  public Groups getGroups() {

    return new Groups(groups);
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
    if (photo != null) {
      return new File(photo);
    } return null;
    //return new File(photo);
  }

  public NewContactData withPhoto(File photo) {

    this.photo = photo.getPath();
    return this;
  }

  public NewContactData withAddress2(String address2) {
    this.address2 = address2;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    NewContactData that = (NewContactData) o;

    if (id != that.id) return false;
    if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
    if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
    if (address != null ? !address.equals(that.address) : that.address != null) return false;
    if (mobile != null ? !mobile.equals(that.mobile) : that.mobile != null) return false;
    if (work != null ? !work.equals(that.work) : that.work != null) return false;
    if (home != null ? !home.equals(that.home) : that.home != null) return false;
    if (email != null ? !email.equals(that.email) : that.email != null) return false;
    if (email2 != null ? !email2.equals(that.email2) : that.email2 != null) return false;
    if (email3 != null ? !email3.equals(that.email3) : that.email3 != null) return false;
    return address2 != null ? address2.equals(that.address2) : that.address2 == null;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
    result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
    result = 31 * result + (address != null ? address.hashCode() : 0);
    result = 31 * result + (mobile != null ? mobile.hashCode() : 0);
    result = 31 * result + (work != null ? work.hashCode() : 0);
    result = 31 * result + (home != null ? home.hashCode() : 0);
    result = 31 * result + (email != null ? email.hashCode() : 0);
    result = 31 * result + (email2 != null ? email2.hashCode() : 0);
    result = 31 * result + (email3 != null ? email3.hashCode() : 0);
    result = 31 * result + (address2 != null ? address2.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "NewContactData{" +
            "id=" + id +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            '}';
  }

  public NewContactData inGroup(GroupData group) {
    groups.add(group);
    return this;

  }
}
