package ru.stqa.pft.addressbook.model;


import com.google.common.collect.ForwardingSet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.*;

public class Groups extends ForwardingSet<GroupData> {

   private Set<GroupData> delegate;

  public Groups(Groups groups) {
    this.delegate= new HashSet<GroupData>(groups.delegate);
  }

  public Groups() {
    this.delegate=new HashSet<GroupData>();
  }

  public Groups(Collection<GroupData> result) {
    this.delegate= new HashSet<GroupData>(result);

  }

  @Override
  protected Set<GroupData> delegate() {
    return delegate;
  }

  public Groups withAdded(GroupData group){
    Groups groups=new Groups(this);
    groups.add(group);
    return groups;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;

    Groups groupData = (Groups) o;

    return delegate != null ? delegate.equals(groupData.delegate) : groupData.delegate == null;
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + (delegate != null ? delegate.hashCode() : 0);
    return result;
  }

  public Groups without(GroupData group){
    Groups groups=new Groups(this);
    groups.remove(group);
    return groups;
  }



}
