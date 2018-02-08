package ru.stqa.pft.mantis.model;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@javax.persistence.Entity //для hibernate (объекто-реляц преобразования)
@Table(name="mantis_user_table")
public class UserData {

  @Id
  @Column(name="id")
  private Integer id=Integer.MAX_VALUE;

  @Column(name="username")
  private String username;

  @Column(name="email")
  private String email;

  public Integer getId() {
    return id;
  }

  public String getUsername() {
    return username;
  }

  public String getEmail() {
    return email;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    UserData userData = (UserData) o;

    if (id != null ? !id.equals(userData.id) : userData.id != null) return false;
    if (username != null ? !username.equals(userData.username) : userData.username != null) return false;
    return email != null ? email.equals(userData.email) : userData.email == null;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (username != null ? username.hashCode() : 0);
    result = 31 * result + (email != null ? email.hashCode() : 0);
    return result;
  }

}
