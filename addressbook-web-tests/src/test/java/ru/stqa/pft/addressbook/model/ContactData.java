package ru.stqa.pft.addressbook.model;

import java.io.File;
import java.util.Objects;

public class ContactData {
  private int id = Integer.MAX_VALUE;
  private String firstname;
  private String middlename;
  private String lastname;
  private String address;
  private String homePhone;
  private String mobilePhone;
  private String workPhone;
  private String allPhones;
  private String email;
  private String email2;
  private String email3;
  private String allEmails;
  private String bday;
  private String bmonth;
  private String byear;
  private String group;
  private File photo;

  public String getFirstname() {
    return firstname;
  }

  public String getMiddlename() {
    return middlename;
  }

  public String getLastname() {
    return lastname;
  }

  public String getAddress() {
    return address;
  }

  public String getHomePhone() {
    return homePhone;
  }

  public String getMobilePhone() {
    return mobilePhone;
  }

  public String getWorkPhone() {
    return workPhone;
  }

  public String getEmail() {
    return email;
  }

  public String getBday() {
    return bday;
  }

  public String getBmonth() {
    return bmonth;
  }

  public String getByear() {
    return byear;
  }

  public String getGroup() {
    return group;
  }

  public int getId() {
    return id;
  }

  public String getEmail2() {
    return email2;
  }

  public String getEmail3() {
    return email3;
  }

  public String getAllPhones() {
    return allPhones;
  }

  public File getPhoto() {
    return photo;
  }

  public String getAllEmails() {
    return allEmails;
  }

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactData withFirstname(String firstname) {
    this.firstname = firstname;
    return this;
  }

  public ContactData withMiddlename(String middlename) {
    this.middlename = middlename;
    return this;
  }

  public ContactData withLastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }

  public ContactData withHomePhone(String home) {
    this.homePhone = home;
    return this;
  }

  public ContactData withMobilePhone(String mobile) {
    this.mobilePhone = mobile;
    return this;
  }

  public ContactData withWorkPhone(String work) {
    this.workPhone = work;
    return this;
  }

  public ContactData withEmail(String email) {
    this.email = email;
    return this;
  }

  public ContactData withBday(String bday) {
    this.bday = bday;
    return this;
  }

  public ContactData withBmonth(String bmonth)
  {
    this.bmonth = bmonth;
    return this;
  }

  public ContactData withByear(String byear)
  {
    this.byear = byear;
    return this;
  }

  public ContactData withGroup(String group)
  {
    this.group = group;
    return this;
  }

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  public ContactData withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }

  public ContactData withEmail3(String email3) {
    this.email3 = email3;
    return this;
  }

  public ContactData withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return id == that.id &&
            Objects.equals(firstname, that.firstname) &&
            Objects.equals(lastname, that.lastname);
  }

  public ContactData withPhoto(File photo) {
    this.photo = photo;
    return this;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstname, lastname);
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }
}
