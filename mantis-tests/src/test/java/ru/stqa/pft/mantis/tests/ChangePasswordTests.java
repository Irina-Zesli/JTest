package ru.stqa.pft.mantis.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.mantis.model.MailMessage;
import ru.stqa.pft.mantis.model.UserData;
import ru.stqa.pft.mantis.model.Users;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

public class ChangePasswordTests extends TestBase{

  @Test
  public void testChangePassword() throws IOException, MessagingException {
    Users users = app.db().users().without(app.getProperty("web.adminLogin"));
    UserData user = users.iterator().next();
    System.out.println(user);
    app.changePassword().start();
    app.changePassword().forUser(user);
    List<MailMessage> mailMessages = app.james().waitForMail(user.getUsername(),user.getPassword(),60000);
  }
}
