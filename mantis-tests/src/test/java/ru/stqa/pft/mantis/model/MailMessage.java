package ru.stqa.pft.mantis.model;

import java.util.Date;

public class MailMessage {
  public String to;
  public Date sentDate;
  public String text;

  public MailMessage(String to, Date sentDate, String text){
    this.to = to;
    this.sentDate = sentDate;
    this.text = text;
  }

  @Override
  public String toString() {
    return "MailMessage{" +
            "to='" + to + '\'' +
            ", sentDate='" + sentDate + '\'' +
            '}';
  }
}
