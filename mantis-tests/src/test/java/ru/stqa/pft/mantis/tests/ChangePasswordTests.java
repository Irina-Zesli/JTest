package ru.stqa.pft.mantis.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.mantis.model.UserData;
import ru.stqa.pft.mantis.model.Users;

public class ChangePasswordTests extends TestBase{

  @Test
  public void testChangePassword(){
    Users users = app.db().users().without(app.getProperty("web.adminLogin"));
    UserData user = users.iterator().next();
    System.out.println(user);
    app.changePassword().start();
    app.changePassword().forUser(user);
  }
}
