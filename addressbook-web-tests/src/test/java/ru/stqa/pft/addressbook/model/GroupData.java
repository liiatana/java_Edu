package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Entity;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@XStreamAlias("group")//аннотация для второго способа экспорта в xml

@javax.persistence.Entity //для hibernate (объекто-реляц преобразования)
@Table (name="group_list")
public class GroupData {

@XStreamOmitField //аннотация для поля int id-означает, что в xml не надо загружать данное поле
@Id //указыватся для уникального идентификатора( ключа наверно)
@Column(name="group_id")
private int id;//=Integer.MAX_VALUE;

  @Expose // аннотация для json.Означает что НАДО выгружать поле в json
  @Column(name="group_name") //Если в классе= имени поля в БД , то не надо этой строки
  //иначе- нужно указать name=соответствующий столбец в Бд
  private String name;
  @Expose
  @Column(name="group_header")
  @Type(type="text") // указывается столбцов, в которых многострочные данные( иначе преобразование типов не работает, будет ошибка при компиляции)
  private String header;
  @Expose
  @Column(name="group_footer")
  @Type(type="text")
  private String footer;

  /*public GroupData(int id, String name, String header, String footer) {
    this.id =   id;
    this.name = name;
    this.header = header;
    this.footer = footer;

  }

  public GroupData(String name, String header, String footer) {
    this.id = 0;
    this.name = name;
    this.header = header;
    this.footer = footer;

  }*/

  public int getId() {
    return id;
  }

  public GroupData withId(int id) {
    this.id = id;
    return this;
  }

  public GroupData withName(String name) {
    this.name = name;
    return this;

  }

  public GroupData withHeader(String header) {
    this.header = header;
    return this;
  }

  public GroupData withFooter(String footer) {
    this.footer = footer;
    return this;
  }

  public String getName() {
    return name;
  }

  public String getHeader() {
    return header;
  }

  public String getFooter() {
    return footer;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    GroupData groupData = (GroupData) o;

    if (id != groupData.id) return false;
    if (name != null ? !name.equals(groupData.name) : groupData.name != null) return false;
    if (header != null ? !header.equals(groupData.header) : groupData.header != null) return false;
    return footer != null ? footer.equals(groupData.footer) : groupData.footer == null;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (header != null ? header.hashCode() : 0);
    result = 31 * result + (footer != null ? footer.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {//то, что здесь формируется, отображается в отчете по тесту групп
    return "GroupData{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            '}';
  }


}
