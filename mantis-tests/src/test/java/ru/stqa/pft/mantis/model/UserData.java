package ru.stqa.pft.mantis.model;

public class UserData {

  private int id = Integer.MAX_VALUE;
  private String username;
  private String email;
  private String password;

  public UserData withId(int id) {
    this.id = id;
    return this;
  }

}
