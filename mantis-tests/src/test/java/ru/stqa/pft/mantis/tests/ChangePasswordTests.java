package ru.stqa.pft.mantis.tests;

import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.model.MailMessage;
import ru.stqa.pft.mantis.model.UserData;
import ru.stqa.pft.mantis.model.Users;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.*;

import static org.testng.Assert.assertTrue;

public class ChangePasswordTests extends TestBase{

  @Test
  public void testChangePassword() throws IOException, MessagingException {
    Users users = app.db().users().without(app.getProperty("web.adminLogin"));
    UserData user = users.iterator().next();
    String mailPassword = "password";
    String userNewPassword = "new_password";
    app.changePassword().start();
    app.changePassword().forUser(user);
    //ждем половину минуты, чтобы гарантировано пришло письмо с подтверждением
    try {
      Thread.sleep(30000);
    } catch (InterruptedException e){
      e.printStackTrace();
    }
    List<MailMessage> mailMessagesAfter = app.james().waitForMail(user.getUsername(),mailPassword,60000);
    String confirmationLink = findConfirmationLink(mailMessagesAfter);
    app.registration().finish(confirmationLink, userNewPassword);
    assertTrue(app.newSession().login(user.getUsername(),userNewPassword));
  }
  private String findConfirmationLink(List<MailMessage> mailMessages) {
    // выбираем письмо с самой новой датой
    MailMessage mailMessage = Collections.max(mailMessages,Comparator.comparing(mailMessage1 -> mailMessage1.sentDate));
    //MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
    VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
    return regex.getText(mailMessage.text);
  }
}
